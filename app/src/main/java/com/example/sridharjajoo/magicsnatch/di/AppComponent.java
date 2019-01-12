package com.example.sridharjajoo.magicsnatch.di;

import com.example.sridharjajoo.magicsnatch.MagicSnatchMainApplication;
import com.example.sridharjajoo.magicsnatch.di.modules.ActivityBuildersModule;
import com.example.sridharjajoo.magicsnatch.di.modules.AndroidModule;
import com.example.sridharjajoo.magicsnatch.di.modules.ApiModule;
import com.example.sridharjajoo.magicsnatch.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        AndroidSupportInjectionModule.class,})

public interface AppComponent extends AndroidInjector<MagicSnatchMainApplication> {

    void inject(MagicSnatchMainApplication magicSnatchMainApplication);
}
