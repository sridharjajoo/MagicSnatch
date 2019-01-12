package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import com.example.sridharjajoo.magicsnatch.data.LoginApi;
import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.LoginResponse;
import com.example.sridharjajoo.magicsnatch.data.RegisterRequest;
import com.example.sridharjajoo.magicsnatch.data.RegisterResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MagicSnatchServiceImpl implements MagicSnatchService {

    private final LoginApi loginApi;

    @Inject
    public MagicSnatchServiceImpl(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    @Override
    public Observable<LoginResponse> login(LoginRequest login) {
        return loginApi.login(login).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<RegisterResponse> register(RegisterRequest registerRequest) {
        return loginApi.register(registerRequest.username, registerRequest.password).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
