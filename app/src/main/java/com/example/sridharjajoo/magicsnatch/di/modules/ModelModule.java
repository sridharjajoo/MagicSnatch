package com.example.sridharjajoo.magicsnatch.di.modules;

import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchService;
import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchServiceImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ModelModule {

    @Binds
    @Singleton
    abstract MagicSnatchService bindsMagicSnatchServiceModule(MagicSnatchServiceImpl magicSnatchService);
}
