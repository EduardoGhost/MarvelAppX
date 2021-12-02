package com.example.marvelappx.data.di.Application;

import android.app.Activity;
import android.app.Application;
import com.example.marvelappx.data.di.components.ApplicationComponentes;
import com.example.marvelappx.data.di.components.DaggerApplicationComponentes;
import com.example.marvelappx.data.di.module.ContextModule;

public class MyApplication extends Application {

    ApplicationComponentes applicationComponentes;

    @Override
    public void onCreate() {
        super.onCreate();


   applicationComponentes = DaggerApplicationComponentes.builder().
            contextModule(new ContextModule(this)).build();

        applicationComponentes.injectApplication(this);
    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponentes getApplicationComponent() {
        return applicationComponentes;
    }
}