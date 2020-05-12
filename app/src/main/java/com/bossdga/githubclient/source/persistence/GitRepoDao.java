package com.bossdga.githubclient.source.persistence;

import androidx.room.Dao;
import androidx.room.Query;

import com.bossdga.githubclient.model.GitRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Dao to interact with the database
 */
@Dao
public interface GitRepoDao {

    @Query("SELECT * FROM git_repo")
    Observable<List<GitRepository>> getRepositories();

}