package com.bossdga.githubclient.presentation.viewmodel;

import com.bossdga.githubclient.model.GitRepository;
import com.bossdga.githubclient.source.GitRepoRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * ViewModel used with the MainActivity
 */
public class MainViewModel extends BaseViewModel {

    private GitRepoRepository gitRepoRepository;

    public MainViewModel(GitRepoRepository gitRepoRepository) {
        this.gitRepoRepository = gitRepoRepository;
    }

    /**
     * Method that returns an Observable of a Collection of git repositories
     * @return
     */
    public Observable<List<GitRepository>> getRepositories(String userName) {
        return gitRepoRepository.getRepositories(userName);
    }

}