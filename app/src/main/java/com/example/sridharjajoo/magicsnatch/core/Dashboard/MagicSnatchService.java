package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.LoginResponse;
import com.example.sridharjajoo.magicsnatch.data.RegisterRequest;
import com.example.sridharjajoo.magicsnatch.data.RegisterResponse;

import io.reactivex.Observable;

public interface MagicSnatchService {

    Observable<LoginResponse> login(LoginRequest login);

    Observable<RegisterResponse> register(RegisterRequest registerRequest);
}
