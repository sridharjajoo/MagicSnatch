package com.example.sridharjajoo.magicsnatch.core.Authentication;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;

import com.example.sridharjajoo.magicsnatch.R;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchDashboardActivity;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchViewModel;
import com.example.sridharjajoo.magicsnatch.data.LoginRequest;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MagicSnatchLoginActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private MagicSnatchViewModel magicSnatchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_snatch_login);
        ButterKnife.bind(this);
        magicSnatchViewModel = ViewModelProviders.of(this, viewModelFactory).get(MagicSnatchViewModel.class);

        btnLogin.setOnClickListener(view -> {
            handleLogin();
        });

    }

    private void handleLogin() {
        magicSnatchViewModel.loginHandle();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
 }
