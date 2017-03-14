package com.poec.exercice4.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Question {

    @NonNull
    private String question;
    private int answer;
    @NonNull
    private List<String> answers;

    public Question(@NonNull String question, int answer) {
        this.question = question;
        this.answer = answer;
        this.answers = new ArrayList<>();
    }

    @NonNull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @NonNull
    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(@NonNull List<String> answers) {
        this.answers = answers;
    }
}
