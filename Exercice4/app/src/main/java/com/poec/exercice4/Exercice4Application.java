package com.poec.exercice4;

import android.app.Application;
import android.util.Log;

import com.poec.exercice4.model.Question;
import com.poec.exercice4.utils.FileSystemUtils;

import java.io.IOException;
import java.util.List;

public class Exercice4Application extends Application {

    private static final String TAG = Exercice4Application.class.getSimpleName();
    private List<Question> questions;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            questions = FileSystemUtils.getQuestionsFromJson(this, R.raw.quiz);
        } catch (IOException e) {
            Log.e(TAG, "Cannot load punchlines from json file");
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
