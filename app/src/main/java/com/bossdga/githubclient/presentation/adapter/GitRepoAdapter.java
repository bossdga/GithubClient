package com.bossdga.githubclient.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bossdga.githubclient.OnItemClickListener;
import com.bossdga.githubclient.R;
import com.bossdga.githubclient.model.GitRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide views to RecyclerView.
 */
public class GitRepoAdapter extends RecyclerView.Adapter<GitRepoAdapter.ViewHolder> {

    private List<GitRepository> gitRepositoryList;
    private OnItemClickListener listener;

    /**
     * Provide a reference to the type of views used (custom ViewHolder)
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView url;

        ViewHolder(View v) {
            super(v);

            name = v.findViewById(R.id.Name);
            url = v.findViewById(R.id.Url);
        }

        void bind(final GitRepository gitRepository, final OnItemClickListener listener) {
            this.name.setText(gitRepository.getName());
            this.url.setText(gitRepository.getUrl());

            itemView.setOnClickListener(v -> listener.onItemClick(gitRepository));
        }
    }

    /**
     * Initialize the data set of the Adapter.
     *
     * @param context
     */
    public GitRepoAdapter(Context context, OnItemClickListener listener) {
        this.gitRepositoryList = new ArrayList<>();
        this.listener = listener;
    }

    /**
     * Sets the data set to the recyclerview
     * @param gitRepositoryList
     */
    public void setItems(List<GitRepository> gitRepositoryList) {
        this.gitRepositoryList = gitRepositoryList;
        notifyDataSetChanged();
    }

    /**
     * Create new views (invoked by the layout manager)
     * @param viewGroup
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_repo_data, viewGroup, false);

        return new ViewHolder(v);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.bind(gitRepositoryList.get(position), listener);
    }

    /**
     * Return the size of the data set (invoked by the layout manager)
     * @return
     */
    @Override
    public int getItemCount() {
        return gitRepositoryList.size();
    }

}