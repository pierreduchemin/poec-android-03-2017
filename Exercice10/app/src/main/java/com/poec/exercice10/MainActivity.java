package com.poec.exercice10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.poec.exercice10.adapter.RepositoryAdapter;
import com.poec.exercice10.api.GithubApiService;
import com.poec.exercice10.model.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvRepos)
    RecyclerView rvRepos;

    List<Repository> repositories = new ArrayList<>();
    private RepositoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new RepositoryAdapter(repositories);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this));

        getRepositories();
    }

    private void getRepositories() {
        GithubApiService.getInstance().listRepos("ttencate").enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, R.string.error_message_api_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                adapter.updateRepositories(response.body());
                Toast.makeText(MainActivity.this, R.string.info_message_repositories_updated, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_message_network_error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
