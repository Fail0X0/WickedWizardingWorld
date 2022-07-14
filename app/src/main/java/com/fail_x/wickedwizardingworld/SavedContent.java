package com.fail_x.wickedwizardingworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//This class is for saving and loading gaming content like User information and later upload it to the Server
public class SavedContent {
    private static Context context;
    final Player User = new Player().getInstancePlayer();

    /*Saved players attributes*/
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SPELLS = "player_spells";
    public static final String WANDS = "player_wands";
    public static final String HOUSE = "player_house";
    public static final String LIFE = "player_life";
    public static final String MANA = "player_mana";


    public void SaveData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /*Save Player attributes*/
        editor.putInt(HOUSE, User.getHouse().ordinal());
        editor.putFloat(LIFE, User.getLife());
        editor.putInt(MANA, User.getMana());
        //CANNOT SAVE LISTS OR OBJECTS! GSON LIBRARY NOT WORKING!
//        editor.putStringSet(SPELLS, User.getSpell_list());
//        editor.putInt(WANDS, User.getWand_list());

        /*Other attributes to save*/
        //will be inserted here

        editor.apply();
    }

    public void LoadData() {
        //CANNOT CAST INTO ENUM!
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        /*Load Player attributes*/
        int house = sharedPreferences.getInt(HOUSE, 0);
        int life = sharedPreferences.getInt(LIFE, 0);
        int mana = sharedPreferences.getInt(MANA, 0);
    }
}
