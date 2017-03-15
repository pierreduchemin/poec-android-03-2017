package com.poec.exercice9;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PetStoreService {

    @GET("v2/user/login")
    Call<String> login(@Query("username") String username, @Query("password") String password);
}
