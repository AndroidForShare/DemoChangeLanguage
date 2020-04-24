package com.pram.demochangelanguage;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate;

import java.util.Locale;

/** Extend the Application */
public class MainApplication extends Application {

    /** the LocalizationApplicationDelegate */
    LocalizationApplicationDelegate localizationDelegate = new LocalizationApplicationDelegate();

    @Override
    protected void attachBaseContext(Context base) {
        localizationDelegate.setDefaultLanguage(base, Locale.ENGLISH); /** setDefaultLanguage */
        super.attachBaseContext(localizationDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localizationDelegate.onConfigurationChanged(this); /** set onConfigurationChanged */
    }

    @Override
    public Context getApplicationContext() {
        return localizationDelegate.getApplicationContext(super.getApplicationContext()); /** set getApplicationContext */
    }
}
