package com.task.mercari.application;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.task.mercari.di.component.ApplicationComponent;
import com.task.mercari.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Nitish Singh on 2019-06-02.
 */
public class MercariApplication extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
