package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.RegisterRequest;

import javax.inject.Inject;

public class MagicSnatchViewModel extends ViewModel {

    private final MagicSnatchService magicSnatchService;
    private final MutableLiveData<String> register = new MutableLiveData<>();
    private final MutableLiveData<String> login = new MutableLiveData<>();

    @Inject
    public MagicSnatchViewModel(MagicSnatchService magicSnatchService) {
        this.magicSnatchService = magicSnatchService;
    }

    @SuppressLint("CheckResult")
    public void loginHandle(String email, String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.username = email;
        loginRequest.password = password;
        magicSnatchService.login(loginRequest).subscribe(response -> {
            register.setValue(response.mssg);
            Log.i("MagicSnatchViewModel", "loginHandle: " + response.mssg);
        }, erroor -> {
            register.setValue(erroor.getMessage());
            Log.i("MagicSnatchViewModel", "loginHandle: " + erroor.getMessage());
        });
    }

    @SuppressLint("CheckResult")
    public void registerHandle(String email, String password) {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.username = email;
        registerRequest.password = password;
        magicSnatchService.register(registerRequest).subscribe(registerResponse -> {
            login.setValue(registerResponse.mssg);
            Log.i("MagicSnatchViewModel", "registerHandle: " + registerResponse.mssg);
        }, error -> {
            login.setValue(error.getMessage());
            Log.i("MagicSNatchVIewmODEL", "registerHandle: " + error.getMessage());
        });
    }

    public LiveData<String> getRegister() {
        return register;
    }

    public LiveData<String> getLogin() {
        return login;
    }
}
