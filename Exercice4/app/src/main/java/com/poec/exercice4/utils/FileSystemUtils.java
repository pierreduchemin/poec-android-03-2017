package com.poec.exercice4.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.poec.exercice4.gson.QuizDeserialiser;
import com.poec.exercice4.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileSystemUtils {

    public static List<Question> getQuestionsFromJson(@NonNull Context context, @RawRes int jsonRawResId) throws IOException {
        InputStream jsonInputStream = context.getResources().openRawResource(jsonRawResId);

        String json = readFile(jsonInputStream);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Question.class, QuizDeserialiser.get());
        return gsonBuilder.create().fromJson(json, new TypeToken<List<Question>>() {
        }.getType());
    }

    private static String readFile(@NonNull InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }
}