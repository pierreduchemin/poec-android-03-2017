package com.poec.exercice10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.poec.exercice10.R;
import com.poec.exercice10.model.Repository;

import java.util.List;
import java.util.Locale;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<Repository> repositories;

    public RepositoryAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public void updateRepositories(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_repo_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.tvRepoName.setText(String.format(Locale.getDefault(), "%s", repository.getName()));

        if (repository.getPrivate()) {
            holder.ivPrivate.setImageResource(R.drawable.ic_lock);
        } else {
            holder.ivPrivate.setImageResource(R.drawable.ic_lock_open);
        }
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPrivate;
        TextView tvRepoName;

        ViewHolder(View view) {
            super(view);
            this.ivPrivate = (ImageView) view.findViewById(R.id.ivPrivate);
            this.tvRepoName = (TextView) view.findViewById(R.id.tvRepoName);
        }
    }
}
