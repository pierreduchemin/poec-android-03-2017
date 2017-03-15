package com.poec.exercice11.service;

import com.poec.exercice11.model.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("api.php")
    Call<Forecast> getForecast(@Query("city") String city);
}
