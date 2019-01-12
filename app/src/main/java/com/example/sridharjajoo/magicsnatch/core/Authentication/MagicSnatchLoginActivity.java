package com.example.sridharjajoo.magicsnatch.core.Authentication;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.Toast;

import com.example.sridharjajoo.magicsnatch.R;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchDashboardActivity;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchService;
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

    @BindView(R.id.email)
    TextInputEditText email;

    @BindView(R.id.password)
    TextInputEditText password;

    @BindView(R.id.btnRegister)
    AppCompatButton btnRegister;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private MagicSnatchViewModel magicSnatchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_snatch_login);
        ButterKnife.bind(this);
        magicSnatchViewModel = ViewModelProviders.of(this, viewModelFactory).get(MagicSnatchViewModel.class);
        magicSnatchViewModel.getRegister().observe(this, x -> {
            if (x.contentEquals("1")) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MagicSnatchLoginActivity.this, MagicSnatchDashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "User already registered!", Toast.LENGTH_SHORT).show();
            }
        });

        magicSnatchViewModel.getLogin().observe(this, x -> {
            if (x.contentEquals("1")) {
                Intent intent = new Intent(MagicSnatchLoginActivity.this, MagicSnatchDashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(view -> {
            handleLogin();
        });

        btnLogin.setOnClickListener(view -> {
            handleRegister();
        });
    }

    private void handleRegister() {
        magicSnatchViewModel.registerHandle(email.getText().toString(), password.getText().toString());
    }

    private void handleLogin() {
        magicSnatchViewModel.loginHandle(email.getText().toString(), password.getText().toString());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
 }
