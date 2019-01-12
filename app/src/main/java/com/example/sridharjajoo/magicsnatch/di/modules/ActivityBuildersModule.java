package com.example.sridharjajoo.magicsnatch.di.modules;

import com.example.sridharjajoo.magicsnatch.core.Authentication.MagicSnatchLoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MagicSnatchLoginActivity contributesMagicSnatchLoginActivity();
}
