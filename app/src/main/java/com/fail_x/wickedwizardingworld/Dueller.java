package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Dueller {
    private static final boolean D = true;
    private static final String TAG = Dueller.class.getName();

    public Dueller(String name, House house) {
        this.name = name;
        Dueller.house = house;
        this.mana = 10;
        this.damage = 0.01f;
        this.life = 1;
        this.spell_list = new ArrayList<>();  //don't forget to fill the empty list
    }

    public Dueller(String name, EnemyTag enemy_tag, int mana, float damage, float life, House house) {
        this.name = name;
        this.enemy_tag = enemy_tag;
        this.mana = mana;
        this.damage = damage;
        this.life = life;
        Dueller.house = house;
        this.spell_list = new ArrayList<>();  //don't forget to fill the empty list
    }

    public Dueller() {
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        Dueller.house = house;
    }

    public List<Spell> getSpell_list() {
        return spell_list;
    }

    public void setSpell_list(List<Spell> spell_list) {
        this.spell_list = spell_list;
    }

    public void setSpell(Spell spell) {
        this.spell_list.add(spell);
    }

    public Spell getSpell(Spell.SpellTag tag) {
        int i;
        boolean found = false;

        for (i = 0; i < spell_list.size(); i++) {
            if (spell_list.get(i).getTag() == tag) {
                found = true;
                break;
            }
        }
        if (found)
            return spell_list.get(i);
        else {
            if (D)
                Log.e(TAG, "Spell could not be found in list. Check writing. getSpell returned NULL!");
            return null;
        }
    }

    public Spell getSpell(int position) {
        if (position < spell_list.size())
            return spell_list.get(position);
        else {
            if (D)
                Log.e(TAG, "Spell could not be found in list. Check writing. getSpell returned NULL!");
            return null;
        }
    }

    public EnemyTag getEnemy_name() {
        return enemy_tag;
    }

    public void setEnemy_name(EnemyTag enemy_name) {
        this.enemy_tag = enemy_name;
    }

    private int mana;
    private float damage;
    private float life;
    private String name;
    private static House house;
    private static EnemyTag enemy_tag;
    private List<Spell> spell_list;


    enum House {
        griffindor,
        hufflepuff,
        ravenclaw,
        slytherin,
        monster
    }

    public enum EnemyTag {
        troll,
        acromantula,
        goyle,
        fire_slug,
        deatheater
    }
}
