package com.poec.exercice9;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PetStoreApiService {

    private static PetStoreService petStoreService;

    public static PetStoreService getInstance() {
        if (petStoreService == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(logging);
            }

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://petstore.swagger.io/")
                    .client(httpClient.build())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            petStoreService = retrofit.create(PetStoreService.class);
        }
        return petStoreService;
    }

}
