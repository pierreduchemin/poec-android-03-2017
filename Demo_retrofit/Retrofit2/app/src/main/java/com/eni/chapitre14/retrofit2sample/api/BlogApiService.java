package com.eni.chapitre14.retrofit2sample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogApiService {

    private static BlogApi blogApiInstance;

    public static BlogApi getInstance() {
        if (blogApiInstance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.tutos-android.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            blogApiInstance = retrofit.create(BlogApi.class);
        }
        return blogApiInstance;
    }
}
