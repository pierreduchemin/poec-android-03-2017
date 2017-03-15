package com.poec.exercice9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via tvEmail/tvPassword.
 */
public class LoginActivity extends AppCompatActivity {

    String mylogin = "login@example.com";
    String mypassword = "mypassword";

    @BindView(R.id.tvEmail)
    EditText tvEmail;
    @BindView(R.id.tvPassword)
    EditText tvPassword;
    @BindView(R.id.btnEmailSignIn)
    Button btnEmailSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEmailSignIn)
    public void attemptLogin() {

        // Store values at the time of the login attempt.
        String strEmail = tvEmail.getText().toString();
        String strPassword = tvPassword.getText().toString();

        if (!isEmailValid(strEmail)) {
            Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_LONG).show();
            return;
        }

        if (!isPasswordValid(strPassword)) {
            Toast.makeText(this, R.string.invalid_password, Toast.LENGTH_LONG).show();
            return;
        }

        Call<String> loginCall = PetStoreApiService.getInstance().login(mylogin, mypassword);
        loginCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Erreur du serveur", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(LoginActivity.this, response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Impossible de contacter le serveur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email != null && !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();//&& email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password != null && !password.isEmpty() && password.length() > 4;
    }
}

