package com.poec.exercice8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rbCountry)
    RadioButton rbCountry;
    @BindView(R.id.rbSize)
    RadioButton rbSize;
    @BindView(R.id.rbPart1)
    RadioButton rbPart1;
    @BindView(R.id.rbPart2)
    RadioButton rbPart2;
    @BindView(R.id.rbLifetime)
    RadioButton rbLifetime;
    @BindView(R.id.btnCheck)
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCheck)
    public void onClickCheck(View view) {

        int score = 0;

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
    }
}
