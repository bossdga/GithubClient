package com.bossdga.githubclient.presentation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bossdga.githubclient.R;
import com.bossdga.githubclient.model.GitRepository;
import com.bossdga.githubclient.presentation.adapter.GitRepoAdapter;
import com.bossdga.githubclient.presentation.viewmodel.MainViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Fragment that will show a list of git repositories
 */
public class MainFragment extends BaseFragment {

    private GitRepoAdapter adapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MainViewModel mainViewModel;

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showProgressDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mSwipeRefreshLayout = rootView.findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new GitRepoAdapter(getActivity(), repository -> {
            //TODO implement if needed
        });
        mRecyclerView.setAdapter(adapter);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        subscribeGitRepos(mainViewModel.getRepositories("bossdga"));
    }

    @Override
    public void onStop() {
        super.onStop();

        disposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        disposable.dispose();
    }

    /**
     * Listener for swipe to refresh functionality
     */
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = () -> {
        subscribeGitRepos(mainViewModel.getRepositories("bossdga"));
    };

    /**
     * Method that adds a Disposable to the CompositeDisposable
     * @param gitReposObservable
     */
    private void subscribeGitRepos(Observable<List<GitRepository>> gitReposObservable) {
        disposable.add(gitReposObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<GitRepository>>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<GitRepository> gitRepositoryList) {
                        if(gitRepositoryList != null) {
                            adapter.setItems(gitRepositoryList);
                            mSwipeRefreshLayout.setRefreshing(false);
                            hideProgressDialog();
                        }
                    }
                }));
    }
}