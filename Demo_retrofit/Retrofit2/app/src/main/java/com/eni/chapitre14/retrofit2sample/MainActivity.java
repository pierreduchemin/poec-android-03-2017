package com.eni.chapitre14.retrofit2sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.eni.chapitre14.retrofit2sample.api.BlogApi;
import com.eni.chapitre14.retrofit2sample.api.BlogApiService;
import com.eni.chapitre14.retrofit2sample.model.Post;
import com.eni.chapitre14.retrofit2sample.model.RecentPosts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlogApi blogApi = BlogApiService.getInstance();
        Call<RecentPosts> call = blogApi.getRecentPosts("get_recent_posts");
        //asynchronous call
        call.enqueue(new Callback<RecentPosts>() {
            @Override
            public void onResponse(Call<RecentPosts> call, Response<RecentPosts> response) {
                Log.e(TAG, "onResponse = " + response.toString());
                RecentPosts recentPosts = response.body();
                if (recentPosts != null) {
                    for (Post post : recentPosts.getPosts()) {
                        Log.d(TAG, "post title = " + post.getTitle());
                        Log.d(TAG, "post content = " + post.getContent());
                        Log.d(TAG, "post author = " + post.getAuthor());
                    }
                }
            }

            @Override
            public void onFailure(Call<RecentPosts> call, Throwable t) {
                Log.e(TAG, "onFailure = " + t.getMessage());
            }
        });
    }
}
