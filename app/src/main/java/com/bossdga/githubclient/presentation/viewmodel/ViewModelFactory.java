package com.bossdga.githubclient.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bossdga.githubclient.source.Injector;
import com.bossdga.githubclient.source.GitRepoRepository;

/**
 * Factory that returns ViewModel
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private GitRepoRepository gitRepoRepository;

    public static ViewModelFactory getInstance(Application application) {
        synchronized (ViewModelFactory.class) {
            if (INSTANCE == null) {
                INSTANCE = new ViewModelFactory(Injector.provideGitRepoRepository(application));
            }
        }
        return INSTANCE;
    }

    private ViewModelFactory(GitRepoRepository gitRepoRepository) {
        this.gitRepoRepository = gitRepoRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(gitRepoRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}