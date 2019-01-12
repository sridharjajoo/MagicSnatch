package com.example.sridharjajoo.magicsnatch.data;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);
}
