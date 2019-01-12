package com.example.sridharjajoo.magicsnatch.core.Dashboard;


import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.LoginResponse;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface MagicSnatchService {

    Observable<LoginResponse> login(LoginRequest login);
}
