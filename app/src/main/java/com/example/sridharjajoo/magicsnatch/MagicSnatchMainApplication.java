package com.example.sridharjajoo.magicsnatch;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.sridharjajoo.magicsnatch.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MagicSnatchMainApplication extends MultiDexApplication implements HasActivityInjector {

    public static volatile Context context;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AppInjector.init(this);
    }
}
