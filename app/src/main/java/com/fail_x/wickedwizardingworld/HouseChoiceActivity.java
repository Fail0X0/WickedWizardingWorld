package com.fail_x.wickedwizardingworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HouseChoiceActivity extends AppCompatActivity {
    private static final boolean D = true;
    private static final String TAG = HouseChoiceActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_choice);

        final Player User = new Player().getInstancePlayer();                       //create a new User (Singleton)
        final EditText person_name = findViewById(R.id.person_name);
        final ImageView sorting_hat = findViewById(R.id.sorting_hat);
        ImageView griffindor = findViewById(R.id.griffindor);
        ImageView slytherin = findViewById(R.id.slytherin);
        ImageView hufflepuff = findViewById(R.id.hufflepuff);
        ImageView ravenclaw = findViewById(R.id.ravenclaw);

        SpellFactory spell_factory = new SpellFactory();                        //Initiating factorys
        WandFactory wand_factory = new WandFactory();
        User.setSpell(spell_factory.getSpell(Spell.SpellTag.stupor));         //fill Users spell list with default spells
        User.setSpell(spell_factory.getSpell(Spell.SpellTag.expelliarmus));
        User.setWand(wand_factory.getWand(Wand.WandTag.oak));

        MyAnimations ani = new MyAnimations();              //To reveal the houses

        person_name.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                hideKeyboard(v);
                if (person_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();
                } else {
                    User.setName(person_name.getText().toString());

                    Toast.makeText(getApplicationContext(), getString(R.string.toast_name_approved) + " " + person_name.getText(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "The Persons name is: " + person_name.getText().toString());

                    ani.ZoomAnimation(griffindor);
                    ani.ZoomAnimation(slytherin);
                    ani.ZoomAnimation(hufflepuff);
                    ani.ZoomAnimation(ravenclaw);

                }
                return false;
            }
        });

        person_name.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                    if (person_name.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();
                    } else {
                        User.setName(person_name.getText().toString());

                        Toast.makeText(getApplicationContext(), getString(R.string.toast_name_approved) + " " + person_name.getText(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "The Persons name is: " + person_name.getText().toString());

                        ani.ZoomAnimation(griffindor);
                        ani.ZoomAnimation(slytherin);
                        ani.ZoomAnimation(hufflepuff);
                        ani.ZoomAnimation(ravenclaw);
                    }
                }
            }
        });

        griffindor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setHouse(Dueller.House.griffindor);
                ani.PressedAnimation(griffindor);
                Toast.makeText(getApplicationContext(), getString(R.string.griffindor), Toast.LENGTH_SHORT).show();
                OpenHogwartsActivity(sorting_hat);
            }
        });
        slytherin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setHouse(Dueller.House.slytherin);
                ani.PressedAnimation(slytherin);
                Toast.makeText(getApplicationContext(), getString(R.string.slytherin), Toast.LENGTH_SHORT).show();
                OpenHogwartsActivity(sorting_hat);
            }
        });
        hufflepuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setHouse(Dueller.House.hufflepuff);
                ani.PressedAnimation(hufflepuff);
                Toast.makeText(getApplicationContext(), getString(R.string.hufflepuff), Toast.LENGTH_SHORT).show();
                OpenHogwartsActivity(sorting_hat);
            }
        });
        ravenclaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setHouse(Dueller.House.ravenclaw);
                ani.PressedAnimation(ravenclaw);
                Toast.makeText(getApplicationContext(), getString(R.string.ravenclaw), Toast.LENGTH_SHORT).show();
                OpenHogwartsActivity(sorting_hat);
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(HouseChoiceActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void OpenHogwartsActivity(ImageView start_image) {
        if (D) Log.d(TAG, "Directing to main menu");
        Intent intent = new Intent(this, HogwartsActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}