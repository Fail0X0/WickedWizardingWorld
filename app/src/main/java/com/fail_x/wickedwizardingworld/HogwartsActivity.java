package com.fail_x.wickedwizardingworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import java.util.Enumeration;

public class HogwartsActivity extends AppCompatActivity {
    private static final boolean D = true;
    private static final String TAG = HogwartsActivity.class.getName();

    /*For exiting purposes*/
    private enum Exit {
        none,
        asked,
        end
    }

    final Player User = new Player().getInstancePlayer();
    private Exit exit;
    private TextView blur;
    private TextView exit_text;

    /*Saved players attributes*/
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SPELLS = "player_spells";
    public static final String WANDS = "player_wands";
    public static final String HOUSE = "player_house";
    public static final String LIFE = "player_life";
    public static final String MANA = "player_mana";


    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogwarts);

        ImageView duel_activity_button = findViewById(R.id.duel_activity_button);
        ImageView settings_activity_button = findViewById(R.id.settings_activity_button);
        ImageView user_house = findViewById(R.id.user_house);
        final ImageView maze_image = findViewById(R.id.maze_image);
        final ImageView settings_activity_start = findViewById(R.id.settings_activity_start);
        TextView user_name = findViewById(R.id.user_name);
        TextView user_spells = findViewById(R.id.user_spells);
        TextView user_wands = findViewById(R.id.user_wands);
        blur = findViewById(R.id.blur);
        exit_text = findViewById(R.id.exit_text);

        /*Initiate user interface*/
        user_name.setText(User.getName());
        user_spells.setText(getText(R.string.spells_learned) + " " + User.getSpell_list().size());
        user_wands.setText(getString(R.string.wands) + " " + User.getWand_list().size());
        if (User.getHouse().equals(Dueller.House.griffindor)) {
            user_house.setImageResource(R.drawable.griffindor_icon);
        } else if (User.getHouse().equals(Dueller.House.slytherin)) {
            user_house.setImageResource(R.drawable.slytherin_icon);
        } else if (User.getHouse().equals(Dueller.House.ravenclaw)) {
            user_house.setImageResource(R.drawable.ravenclaw_icon);
        } else if (User.getHouse().equals(Dueller.House.hufflepuff)) {
            user_house.setImageResource(R.drawable.hufflepuff_icon);
        }

        duel_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDuelActivity();
            }
        });

        settings_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSettingsActivity();
            }
        });

        settings_activity_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenImageActivity(settings_activity_start);
            }
        });

        blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blur.setVisibility(View.GONE);
                exit_text.setVisibility(View.GONE);
                exit = Exit.end;
            }
        });

        exit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blur.setVisibility(View.GONE);
                exit_text.setVisibility(View.GONE);
                exit = Exit.end;
            }
        });
    }

    public void OpenImageActivity(ImageView settings_activity_start) {
        if (D) Log.d(TAG, "Directing to settings");
        Intent intent = new Intent(this, SettingsActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, settings_activity_start, "start_duel");
        startActivity(intent, options.toBundle());

    }

    public void OpenDuelActivity() {
        if (D) Log.d(TAG, "Direct to the DuelActivity");
        Intent intent = new Intent(this, DuelActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void OpenSettingsActivity() {
        if (D) Log.d(TAG, "Direct to the DuelActivity");
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        switch (exit) {
            case none: {
                blur.setVisibility(View.VISIBLE);
                exit_text.setVisibility(View.VISIBLE);
                MyAnimations ani = new MyAnimations();
                ani.ZoomAnimation(exit_text);
                exit = Exit.asked;
                break;
            }
            case asked: {
                blur.setVisibility(View.GONE);
                exit_text.setVisibility(View.GONE);
                exit = Exit.end;
                break;
            }
            case end: {
                moveTaskToBack(true);
                break;
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        exit = Exit.none;
    }

    public void SaveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HOUSE, User.getHouse().ordinal());
        editor.putFloat(LIFE, User.getLife());
        editor.putInt(MANA, User.getMana());
                                //CANNOT SAVE LISTS OR OBJECTS! GSON LIBRARY NOT WORKING!
//        editor.putStringSet(SPELLS, User.getSpell_list());
//        editor.putInt(WANDS, User.getWand_list());
        editor.apply();
    }

    public void LoadData() {
                                //CANNOT CAST INTO ENUM!
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        int house = sharedPreferences.getInt(HOUSE, 0);
        int life = sharedPreferences.getInt(LIFE, 0);
        int mana = sharedPreferences.getInt(MANA, 0);
    }
}
