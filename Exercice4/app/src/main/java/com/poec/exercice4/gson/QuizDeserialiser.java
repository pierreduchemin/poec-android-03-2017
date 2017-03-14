package com.poec.exercice4.gson;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.poec.exercice4.model.Question;

import java.lang.reflect.Type;


public class QuizDeserialiser implements JsonDeserializer<Question> {

    private static QuizDeserialiser instance;

    private QuizDeserialiser() {
    }

    @NonNull
    public static QuizDeserialiser get() {
        if (instance == null) {
            instance = new QuizDeserialiser();
        }
        return instance;
    }

    @Override
    @NonNull
    public Question deserialize(@NonNull JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {

        JsonObject jsonObjectQuestion = jsonElement.getAsJsonObject();

        Question question = new Question(jsonObjectQuestion.get("question").getAsString(), jsonObjectQuestion.get("answer").getAsInt());
        JsonArray jsonAnswers = jsonObjectQuestion.get("answers").getAsJsonArray();

        for (JsonElement jsonAnswer : jsonAnswers) {
            question.getAnswers().add(jsonAnswer.getAsString());
        }

        return question;
    }
}
