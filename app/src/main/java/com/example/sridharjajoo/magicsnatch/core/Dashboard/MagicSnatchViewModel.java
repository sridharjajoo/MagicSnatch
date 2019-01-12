package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.arch.lifecycle.ViewModel;

import com.example.sridharjajoo.magicsnatch.data.LoginRequest;

import javax.inject.Inject;

public class MagicSnatchViewModel extends ViewModel {

    private final MagicSnatchService magicSnatchService;

    @Inject
    public MagicSnatchViewModel(MagicSnatchService magicSnatchService) {
        this.magicSnatchService = magicSnatchService;
    }

    public void loginHandle() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.userName = "1234";
        loginRequest.password = "1234";
        magicSnatchService.login(loginRequest);
    }
}
