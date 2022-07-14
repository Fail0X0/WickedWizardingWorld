package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character{
    private static final boolean D = true;
    private static final String TAG = Enemy.class.getName();

    public Enemy(String name, House house) {
        this.name = name;
        Enemy.house = house;
        this.mana = 10;
        this.damage = 0.01f;
        this.life = 1;
        this.spell_list = new ArrayList<>();  //don't forget to fill the empty list
    }

    public Enemy(String name, EnemyTag enemy_tag, int mana, float damage, float life, House house) {
        this.name = name;
        Enemy.enemy_tag = enemy_tag;
        this.mana = mana;
        this.damage = damage;
        this.life = life;
        Enemy.house = house;
        this.spell_list = new ArrayList<>();  //don't forget to fill the empty list
    }

    public Enemy() {
    }

    public EnemyTag getEnemy_name() {
        return enemy_tag;
    }

    public void setEnemy_name(EnemyTag enemy_name) {
        Enemy.enemy_tag = enemy_name;
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

    enum EnemyTag {
        troll,
        acromantula,
        goyle,
        fire_slug,
        deatheater
    }
}
