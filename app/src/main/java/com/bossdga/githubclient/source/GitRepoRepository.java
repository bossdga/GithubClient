package com.bossdga.githubclient.source;

import com.bossdga.githubclient.model.GitRepository;
import com.bossdga.githubclient.source.network.api.GitRepoAPI;
import com.bossdga.githubclient.source.persistence.GitRepoDao;

import java.util.List;

import io.reactivex.Observable;

/**
 * Repository to execute database and network operations
 */
public class GitRepoRepository {

    private GitRepoDao dao;
    private GitRepoAPI api;

    public GitRepoRepository(GitRepoDao dao, GitRepoAPI api) {
        this.dao = dao;
        this.api = api;
    }

    /**
     * Gets a list of git repositories
     * @param userName
     * @return
     */
    public Observable<List<GitRepository>> getRepositories(String userName) {
        return this.api.getRepositories(userName);
        // TODO Add local database access in case there is not network connectivity or for caching purposes
        //return this.dao.getRepositories(userName);
    }

}