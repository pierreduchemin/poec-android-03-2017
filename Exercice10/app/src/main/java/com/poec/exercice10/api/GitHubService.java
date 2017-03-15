package com.poec.exercice10.api;

import com.poec.exercice10.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);
}