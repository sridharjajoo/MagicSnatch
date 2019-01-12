package com.example.sridharjajoo.magicsnatch.data;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {

    @POST("insertintable")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("loginValidUser")
    Observable<RegisterResponse> register(@Query(value = "username") String username,
                                          @Query(value = "password") String password);
}
