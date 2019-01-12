package com.example.sridharjajoo.magicsnatch.di.modules;

import com.example.sridharjajoo.magicsnatch.data.LoginApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public LoginApi providesLoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }
}
