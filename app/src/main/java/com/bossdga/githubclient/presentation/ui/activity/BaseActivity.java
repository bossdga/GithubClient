package com.bossdga.githubclient.presentation.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bossdga.githubclient.R;
import com.bossdga.githubclient.presentation.viewmodel.BaseViewModel;
import com.bossdga.githubclient.presentation.viewmodel.ViewModelFactory;

/**
 * Base Activity that implements common functionality for the rest of the activities
 */
public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected ViewModelFactory factory;
    protected VM viewModel;

    @NonNull
    protected abstract VM createViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        factory = ViewModelFactory.getInstance(this.getApplication());
        viewModel = createViewModel();
    }

    /**
     * Sets up the action bar
     * @param titleId
     * @param enableHomeAsUp
     */
    protected void setUpActionBar(int titleId, boolean enableHomeAsUp) {
        setUpActionBar(getString(titleId), enableHomeAsUp);
    }

    /**
     * Sets up the action bar
     * @param title
     * @param enableHomeAsUp
     */
    private void setUpActionBar(String title, boolean enableHomeAsUp) {
        setToolbar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enableHomeAsUp);
            getSupportActionBar().setTitle(title);
        }
    }

    /**
     * Sets up the toolbar
     */
    private void setToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

}