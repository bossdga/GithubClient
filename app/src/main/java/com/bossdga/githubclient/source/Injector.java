package com.bossdga.githubclient.source;

import android.app.Application;

import androidx.annotation.NonNull;

import com.bossdga.githubclient.source.network.RetrofitService;
import com.bossdga.githubclient.source.persistence.AppDatabase;

/**
 * Class responsible of injecting repositories to a view model factory
 */
public class Injector {

    /**
     * Provides a profile repository
     * @param application
     * @return
     */
    public static GitRepoRepository provideGitRepoRepository(@NonNull Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        return new GitRepoRepository(db.gitRepoDao(), RetrofitService.getInstance().getGitRepoApi());
    }

}