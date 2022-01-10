package com.fail_x.wickedwizardingworld;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SettingsActivity extends AppCompatActivity {
    private static final String PERMISSION_ACCESS_VIBRATION = Manifest.permission.VIBRATE;
    private static final boolean D = true;
    private static final String TAG = SettingsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch_vibration = findViewById(R.id.switch_vibration);


        if (ContextCompat.checkSelfPermission(this, PERMISSION_ACCESS_VIBRATION) == PackageManager.PERMISSION_GRANTED)
            switch_vibration.setChecked(true);

        switch_vibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                } else {
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (D) Log.d(TAG, "Direct back to the HogwartsActivity");
        Intent intent = new Intent(this, HogwartsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}