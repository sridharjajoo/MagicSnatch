package com.example.sridharjajoo.magicsnatch.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.sridharjajoo.magicsnatch.core.Dashboard.MagicSnatchViewModel;
import com.example.sridharjajoo.magicsnatch.di.MagicSnatchViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MagicSnatchViewModel.class)
    public abstract ViewModel bindMagicSnatchViewModel(MagicSnatchViewModel magicSnatchViewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(MagicSnatchViewModelFactory factory);
}
