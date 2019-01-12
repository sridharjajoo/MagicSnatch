package com.example.sridharjajoo.magicsnatch.di.modules;

import android.content.Context;

import com.example.sridharjajoo.magicsnatch.MagicSnatchMainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    @Provides
    @Singleton
    Context providesContext() {
        return MagicSnatchMainApplication.context;
    }
}
