package com.example.sridharjajoo.magicsnatch.di;

import com.example.sridharjajoo.magicsnatch.MagicSnatchMainApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,})

public interface AppComponent extends AndroidInjector<MagicSnatchMainApplication> {

    void inject(MagicSnatchMainApplication magicSnatchMainApplication);
}
