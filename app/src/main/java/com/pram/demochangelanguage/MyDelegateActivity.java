package com.pram.demochangelanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate;
import com.akexorcist.localizationactivity.core.OnLocaleChangedListener;

import java.util.Locale;

/** implements OnLocaleChangedListener */
public class MyDelegateActivity extends AppCompatActivity implements OnLocaleChangedListener {
    private static final String TAG = "MyDelegateActivity";

    /**
     * In case that you don't wanna use 'LocalizationActivity'
     * You wanna keep using 'AppCompatActivity'
     * You can use 'LocalizationDelegate' instead
     * By Define Everything Following Below
     * */

    private LocalizationActivityDelegate localizationDelegate = new LocalizationActivityDelegate(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        localizationDelegate.addOnLocaleChangedListener(this); /** set addOnLocaleChangedListener */
        localizationDelegate.onCreate(); /** set onCreate */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_delegate);

        initInstances();
    }

    private void initInstances() {
        TextView tvHello = findViewById(R.id.tvHello);
        Button btnChange = findViewById(R.id.btnChange);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
                Log.e(TAG, "btnChange onClick: ");
            }
        });
    }

    private void changeLanguage() {
        String currentLanguage = getCurrentLanguage().getLanguage();

        switch (currentLanguage) {
            case "en":
                changeToTH();
                break;
            case "th":
                changeToEN();
                break;
        }
    }

    private void changeToEN() {
        setLanguage(Locale.ENGLISH); /** setLanguage with Locale */
    }

    private void changeToTH() {
        setLanguage("th"); /** setLanguage with String */
    }

    @Override
    protected void onResume() {
        super.onResume();
        localizationDelegate.onResume(this); /** set onResume */
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(newBase)); /** set attachBaseContext */
    }

    @Override
    public Context getApplicationContext() {
        return localizationDelegate.getApplicationContext(super.getApplicationContext()); /** set getApplicationContext */
    }

    @Override
    public Resources getResources() {
        return localizationDelegate.getResources(super.getResources()); /** set getResources */
    }

    public final void setLanguage(String language) {
        localizationDelegate.setLanguage(this, language); /** set setLanguage */
    }

    public final void setLanguage(Locale locale) {
        localizationDelegate.setLanguage(this, locale); /** set setLanguage */
    }

    public final Locale getCurrentLanguage() {
        return localizationDelegate.getLanguage(this); /** getCurrentLanguage */
    }

    /** onBeforeLocaleChanged */
    @Override
    public void onBeforeLocaleChanged() {
        Toast.makeText(this, "onBeforeLocaleChanged...", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onBeforeLocaleChanged: " + getCurrentLanguage());
    }


    /** onAfterLocaleChanged */
    @Override
    public void onAfterLocaleChanged() {
        Toast.makeText(this, "onAfterLocaleChanged...", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onAfterLocaleChanged: " + getCurrentLanguage());
    }
}
