package com.fail_x.wickedwizardingworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final boolean D = true;
    private static final String TAG = MainActivity.class.getName();
    Player User = new Player().getInstancePlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView start_image = findViewById(R.id.start_image);
        if (D) Log.d(TAG, "Starting App with picture and a short timer");

        new CountDownTimer(250, 50) {

            @Override
            public void onTick(long millisUntilFinished) {
            }


            @Override
            public void onFinish() {
                if (User.getName().isEmpty())                   //check for a new User
                    OpenHouseChoiceActivity(start_image);
                else
                    OpenHogwartsActivity(start_image);              //Already a configured Player
            }

        }.start();
    }

    public void OpenHogwartsActivity(ImageView start_image) {
        if (D) Log.d(TAG, "Directing to main menu");
        Intent intent = new Intent(this, HogwartsActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void OpenHouseChoiceActivity(ImageView start_image) {
        if (D) Log.d(TAG, "Directing to main menu");
        Intent intent = new Intent(this, HouseChoiceActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}