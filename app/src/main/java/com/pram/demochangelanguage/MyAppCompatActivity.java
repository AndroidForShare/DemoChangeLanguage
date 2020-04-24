package com.pram.demochangelanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

import java.util.Locale;

public class MyAppCompatActivity extends LocalizationActivity {
    private static final String TAG = "MyAppCompatActivity";

    /**
    * To Change Language in LocalizationActivity
    * You need to Define Your Custom Application like MainApplication in this Project
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_app_compat);

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


    /** onBeforeLocaleChanged */
    @Override
    public void onBeforeLocaleChanged() {
        super.onBeforeLocaleChanged();

        Toast.makeText(this, "onBeforeLocaleChanged...", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onBeforeLocaleChanged: " + getCurrentLanguage());
    }


    /** onAfterLocaleChanged */
    @Override
    public void onAfterLocaleChanged() {
        super.onAfterLocaleChanged();

        Toast.makeText(this, "onAfterLocaleChanged...", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onAfterLocaleChanged: " + getCurrentLanguage());
    }
}
