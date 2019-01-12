package com.example.sridharjajoo.magicsnatch.core.Authentication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;

import com.example.sridharjajoo.magicsnatch.R;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchDashboardActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MagicSnatchLoginActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_snatch_login);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(MagicSnatchLoginActivity.this, MagicSnatchDashboardActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
 }
