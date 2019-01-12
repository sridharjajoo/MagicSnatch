package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import com.example.sridharjajoo.magicsnatch.data.LoginApi;
import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MagicSnatchServiceImpl implements MagicSnatchService{

    private LoginApi loginApi;

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
}
