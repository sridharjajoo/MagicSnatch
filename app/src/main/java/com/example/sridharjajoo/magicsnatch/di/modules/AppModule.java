package com.example.sridharjajoo.magicsnatch.di.modules;

import dagger.Module;

@Module(includes = {ModelModule.class, NetworkModule.class, AndroidModule.class, ViewModelModule.class
})
public class AppModule {
}
