package com.poec.exercice3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    private RadioButton rbCountry;
    private RadioButton rbSize;
    private RadioButton rbPart1;
    private RadioButton rbPart2;
    private RadioButton rbLifetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbCountry = (RadioButton) findViewById(R.id.rbCountry);
        rbSize = (RadioButton) findViewById(R.id.rbSize);
        rbPart1 = (RadioButton) findViewById(R.id.rbPart1);
        rbPart2 = (RadioButton) findViewById(R.id.rbPart2);
        rbLifetime = (RadioButton) findViewById(R.id.rbLifetime);

        View btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isMexico = rbCountry.isChecked();
                boolean isFourty = rbSize.isChecked();
                boolean isLarva = rbPart1.isChecked();
                boolean isRegen = rbPart2.isChecked();
                boolean isTen = rbLifetime.isChecked();

                if (isMexico) {
                    score++;
                }

                if (isFourty) {
                    score++;
                }

                if (isLarva) {
                    score++;
                }

                if (isRegen) {
                    score++;
                }

                if (isTen) {
                    score++;
                }

                Toast.makeText(MainActivity.this, getString(R.string.info_message_score, score), Toast.LENGTH_LONG).show();

                score = 0;
            }
        });
    }

}
