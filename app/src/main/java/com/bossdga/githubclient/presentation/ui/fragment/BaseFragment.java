package com.bossdga.githubclient.presentation.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bossdga.githubclient.ProgressDialogHandler;
import com.bossdga.githubclient.R;

import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Base Fragment that implements common functionality for all the fragments
 */
public class BaseFragment extends Fragment implements ProgressDialogHandler {

    CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog mProgressDialog;
    private boolean showDialog = false;
    private Intent extras;

    public BaseFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        extras = Objects.requireNonNull(getActivity()).getIntent();
    }

    @Override
    public void onPause() {
        super.onPause();

        showDialog = false;
    }

    /**
     * Creates and shows a ProgressDialog
     */
    @Override
    public void showProgressDialog() {
        showDialog = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (showDialog) {
                    mProgressDialog = new ProgressDialog(getActivity());
                    mProgressDialog.setTitle(R.string.please_wait);
                    mProgressDialog.setMessage(getResources().getString(R.string.loading));
                    mProgressDialog.show();
                }
            }
        }, 1);
    }

    /**
     * Hides the ProgressDialog
     */
    @Override
    public void hideProgressDialog() {
        showDialog = false;

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

}