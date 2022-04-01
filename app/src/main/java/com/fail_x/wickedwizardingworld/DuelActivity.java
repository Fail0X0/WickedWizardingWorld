package com.fail_x.wickedwizardingworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

public class DuelActivity extends AppCompatActivity {
    private static final boolean D = true;
    private static final String TAG = DuelActivity.class.getName();

    private Player User = new Player().getInstancePlayer();
    private com.fail_x.wickedwizardingworld.Enemy Enemy = new EnemyFactory().getEnemy(com.fail_x.wickedwizardingworld.Enemy.EnemyTag.goyle);

    private float balance_guideline = (float) 0.5;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        final TextView duel_line = findViewById(R.id.duel_line);
        final TextView lifebar_enemy = findViewById(R.id.lifebar_enemy);
        final TextView lifebar_player = findViewById(R.id.lifebar_player);
        final TextView player_life_text = findViewById(R.id.player_life_text);
        final TextView enemy_life_text = findViewById(R.id.enemy_life_text);
        final Guideline guideline = findViewById(R.id.guideline);
        final ListView spell_listview = findViewById(R.id.spell_listview);

        final ArrayAdapter<String> spells = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, User.getSpellNamesforDisplay());
        spell_listview.setAdapter(spells);

        enemy_life_text.setText(getText(R.string.enemy_life).toString() + (int) (Enemy.getLife() * 100) + "%");
        player_life_text.setText(getText(R.string.player_life).toString() + (int) (User.getLife() * 100) + "%");

        spell_listview.setOnItemClickListener((parent, view, position, id) -> {
            if (spell_listview.getItemAtPosition(position) == spells.getItem(0)) {
                damage_to_enemy(duel_line, guideline, lifebar_enemy, enemy_life_text, position);
            } else if (spell_listview.getItemAtPosition(position) == spells.getItem(1)) {
                damage_to_enemy(duel_line, guideline, lifebar_enemy, enemy_life_text,position);
            } else if (spell_listview.getItemAtPosition(position) == spells.getItem(2)) {
                damage_to_player(duel_line, guideline, lifebar_player, player_life_text,position);
            } else if (spell_listview.getItemAtPosition(position) == spells.getItem(3)) {
                damage_to_player(duel_line, guideline, lifebar_player, player_life_text,position);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    void damage_to_player(TextView duel_line, Guideline guideline, TextView lifebar_player, TextView player_life_text, int position) {
        float total_damage = Enemy.getDamage() * Enemy.getSpell(position).getDamage();

        if (D) Log.d(TAG, "Player got attacked with " + total_damage + " damage");

        User.setLife(User.getLife() -total_damage);
        lifebar_player.setAlpha(User.getLife());
        player_life_text.setText(getText(R.string.player_life).toString() + Math.round(User.getLife() * 100) + "%");
        if (D) Log.d(TAG, "Player Life is by: " + User.getLife());

        duel_line.setBackgroundColor(getColor(R.color.colorAccent));

        if (balance_guideline <= 1.01) {
            balance_guideline += total_damage;
            guideline.setGuidelinePercent(balance_guideline);
        } else {
            if (D) Log.d(TAG, "Line is at then end of the screen at " + balance_guideline + "%");
        }

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(200);
        }
    }

    @SuppressLint("SetTextI18n")
    void damage_to_enemy(TextView duel_line, Guideline guideline, TextView lifebar_enemy, TextView enemy_life_text, int position) {
        float total_damage = User.getDamage() * User.getSpell(position).getDamage();

        if (D) Log.d(TAG, "Enemy got attacked with " + total_damage + " damage");
        Enemy.setLife(Enemy.getLife() - total_damage);
        lifebar_enemy.setAlpha(Enemy.getLife());
        enemy_life_text.setText(getText(R.string.enemy_life).toString() + Math.round(Enemy.getLife() * 100) + "%");
        if (D) Log.d(TAG, "Enemy Life is by: " + Enemy.getLife());
        duel_line.setBackgroundColor(getColor(R.color.colorPrimary));

        if (balance_guideline > 0) {
            balance_guideline -= total_damage;
            guideline.setGuidelinePercent(balance_guideline);
        } else {
            if (D) Log.d(TAG, "Line is at then end of the screen at " + balance_guideline + "%");

        }
    }
    @Override
    public void onBackPressed() {
        if (D) Log.d(TAG, "Direct back to the HogwartsActivity");
        Intent intent = new Intent(this, HogwartsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}