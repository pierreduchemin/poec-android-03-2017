package com.poec.exercice4.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.poec.exercice4.Exercice4Application;
import com.poec.exercice4.R;
import com.poec.exercice4.model.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    int score = 0;

    private LinearLayout llQuestionsContent;
    private List<Question> questions;

    private RadioButton rbCountry;
    private RadioButton rbSize;
    private RadioButton rbPart1;
    private RadioButton rbPart2;
    private RadioButton rbLifetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llQuestionsContent = (LinearLayout) findViewById(R.id.llQuestionsContent);

        Exercice4Application exercice4Application = (Exercice4Application) getApplication();

        questions = exercice4Application.getQuestions();
        for (int indexQuestion = 0; indexQuestion < questions.size(); indexQuestion++) {

            Question question = questions.get(indexQuestion);

            // Ouvre un fichier xml pour le rendre manipulable en java, mais sans l'ajouter à l'activity
            View view = LayoutInflater.from(this).inflate(R.layout.view_question, null, false);

            TextView tvQuestionText = (TextView) view.findViewById(R.id.tvQuestionText);
            tvQuestionText.setText(question.getQuestion());

            RadioGroup rgAnswers = (RadioGroup) view.findViewById(R.id.rgAnswers);

            for (int indexAnswer = 0; indexAnswer < question.getAnswers().size(); indexAnswer++) {
                String answer = question.getAnswers().get(indexAnswer);


                View viewAnswer = LayoutInflater.from(this).inflate(R.layout.view_answer, null, false);

                RadioButton rbAnswer = (RadioButton) viewAnswer.findViewById(R.id.rbAnswer);
                rbAnswer.setText(answer);
                rbAnswer.setTag("q" + indexAnswer);

                rgAnswers.addView(rbAnswer);
            }

            llQuestionsContent.addView(view, indexQuestion);
        }


//        rbCountry = (RadioButton) findViewById(R.id.rbCountry);
//        rbSize = (RadioButton) findViewById(R.id.rbSize);
//        rbPart1 = (RadioButton) findViewById(R.id.rbPart1);
//        rbPart2 = (RadioButton) findViewById(R.id.rbPart2);
//        rbLifetime = (RadioButton) findViewById(R.id.rbLifetime);

        View btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                llQuestionsContent.findViewWithTag()



                boolean isMexico = rbCountry.isChecked();
                boolean isFourty = rbSize.isChecked();
                boolean isLarva = rbPart1.isChecked();
                boolean isRegen = rbPart2.isChecked();
                boolean isTen = rbLifetime.isChecked();

                if (isMexico) {
                    score = +1;
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

                Toast.makeText(MainActivity.this, getString(R.string.info_message_score, score, questions.size()), Toast.LENGTH_LONG).show();

                score = 0;
            }
        });
    }

}
