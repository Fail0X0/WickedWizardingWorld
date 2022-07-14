package com.fail_x.wickedwizardingworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
//This class is the main menu of the game and main return point for overview
public class HogwartsActivity extends AppCompatActivity {
    private static final boolean D = true;
    private static final String TAG = HogwartsActivity.class.getName();

    //For keeping track of the user exiting the game
    private enum Exit {
        none,
        asked,
        end
    }

    final Player User = new Player().getInstancePlayer();
    private Exit exit;
    private TextView blur;
    private TextView exit_text;


    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogwarts);

        ImageView user_house = findViewById(R.id.user_house);
        final ImageView hogwarts_background_image = findViewById(R.id.hogwarts_background_image);
        final ImageView settings_activity_button = findViewById(R.id.settings_activity_button);
        final ImageView duel_activity_button = findViewById(R.id.duel_activity_button);
        final ImageView inventory_activity_button = findViewById(R.id.inventory_activity_button);
        TextView user_name = findViewById(R.id.user_name);
        TextView user_spells = findViewById(R.id.user_spells);
        TextView user_wands = findViewById(R.id.user_wands);
        blur = findViewById(R.id.blur);
        exit_text = findViewById(R.id.exit_text);

        /*Get picture out of path. Replace XXX with Imageview name*/
        //XXX.setImageResource(User.getWand_list().get(0).getPicture_path());

        //Initiate user interface
        user_name.setText(User.getName());
        user_spells.setText(getText(R.string.spells_learned) + " " + User.getSpell_list().size());
        user_wands.setText(getString(R.string.wands) + " " + User.getWand_list().size());
        if (User.getHouse().equals(Character.House.griffindor)) {
            user_house.setImageResource(R.drawable.griffindor_icon);
        } else if (User.getHouse().equals(Character.House.slytherin)) {
            user_house.setImageResource(R.drawable.slytherin_icon);
        } else if (User.getHouse().equals(Character.House.ravenclaw)) {
            user_house.setImageResource(R.drawable.ravenclaw_icon);
        } else if (User.getHouse().equals(Character.House.hufflepuff)) {
            user_house.setImageResource(R.drawable.hufflepuff_icon);
        }

        duel_activity_button.setOnClickListener(v -> OpenDuelActivity(duel_activity_button));
        settings_activity_button.setOnClickListener(v -> OpenSettingsActivity(settings_activity_button));
        inventory_activity_button.setOnClickListener(v -> OpenInventoryActivity(inventory_activity_button));

        blur.setOnClickListener(v -> {
            blur.setVisibility(View.GONE);
            exit_text.setVisibility(View.GONE);
            exit = Exit.end;
        });

        exit_text.setOnClickListener(v -> {
            blur.setVisibility(View.GONE);
            exit_text.setVisibility(View.GONE);
            exit = Exit.end;
        });
    }

    public void OpenSettingsActivity(ImageView settings_activity_start) {
        if (D) Log.d(TAG, "Directing to settings");
        Intent intent = new Intent(this, SettingsActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, settings_activity_start, "start_settings");
        startActivity(intent, options.toBundle());
    }

    public void OpenDuelActivity(ImageView duel_activity_start) {
        if (D) Log.d(TAG, "Direct to the DuelActivity");
        Intent intent = new Intent(this, DuelActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, duel_activity_start, "start_duel");
        startActivity(intent, options.toBundle());
    }

    public void OpenInventoryActivity(ImageView duel_activity_start) {
        if (D) Log.d(TAG, "Direct to the InventoryActivity");
        Intent intent = new Intent(this, InventoryActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, duel_activity_start, "start_inventory");
        startActivity(intent, options.toBundle());
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
}
