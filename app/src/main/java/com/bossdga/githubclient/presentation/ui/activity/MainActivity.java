package com.bossdga.githubclient.presentation.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.bossdga.githubclient.R;
import com.bossdga.githubclient.presentation.viewmodel.MainViewModel;

/**
 * Main Activity that holds several fragments
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpActionBar(R.string.title_activity_main, false);
    }

    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this, factory).get(MainViewModel.class);
    }

}