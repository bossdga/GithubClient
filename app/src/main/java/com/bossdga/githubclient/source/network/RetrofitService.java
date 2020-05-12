package com.bossdga.githubclient.source.network;

import com.bossdga.githubclient.source.network.api.GitRepoAPI;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * API Client that provides access to a single instance of the Service
 */
public class RetrofitService {

    private static final String BASE_URL = "https://api.github.com/";
    private GitRepoAPI gitRepoAPI;
    private static RetrofitService INSTANCE;

    /**
     * Method that returns the instance
     * @return
     */
    public static RetrofitService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitService();
        }
        return INSTANCE;
    }

    private RetrofitService() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        gitRepoAPI = mRetrofit.create(GitRepoAPI.class);
    }

    /**
     * Method that returns the API
     * @return
     */
    public GitRepoAPI getGitRepoApi() {
        return gitRepoAPI;
    }

}