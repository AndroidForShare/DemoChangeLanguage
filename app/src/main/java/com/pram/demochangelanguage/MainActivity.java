package com.pram.demochangelanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

public class MainActivity extends LocalizationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        Button btnToAppCompat = findViewById(R.id.btnToAppCompat);
        Button btnToDelegate = findViewById(R.id.btnToDelegate);

        btnToAppCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAppCompatActivity();
            }
        });

        btnToDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDelegateActivity();
            }
        });
    }

    private void toAppCompatActivity() {
        Intent intent = new Intent(MainActivity.this, MyAppCompatActivity.class);
        startActivity(intent);
    }

    private void toDelegateActivity() {
        Intent intent = new Intent(MainActivity.this, MyDelegateActivity.class);
        startActivity(intent);
    }

}
