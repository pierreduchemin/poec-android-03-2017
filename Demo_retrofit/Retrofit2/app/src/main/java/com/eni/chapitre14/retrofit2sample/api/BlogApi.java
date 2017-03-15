package com.eni.chapitre14.retrofit2sample.api;

import com.eni.chapitre14.retrofit2sample.model.RecentPosts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlogApi {

    @GET("/")
    Call<RecentPosts> getRecentPosts(@Query("json") String order);
}
