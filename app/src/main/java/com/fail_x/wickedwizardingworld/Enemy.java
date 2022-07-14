package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character{
    private static final boolean D = true;
    private static final String TAG = Enemy.class.getName();

    public Enemy(String name, House house) {
        this.setName(name);
        this.setHouse(house);
        this.setMana(10);
        this.setDamage(0.01f);
        this.setLife(1);
        this.setSpell_list(new ArrayList<>());  //don't forget to fill the empty list
    }

    public Enemy(String name, EnemyTag enemy_tag, int mana, float damage, float life, House house) {
        this.setName(name);
        Enemy.enemy_tag = enemy_tag;
        this.setMana(mana);
        this.setDamage(damage);
        this.setLife(life);
        this.setHouse(house);
        this.setSpell_list(new ArrayList<>());  //don't forget to fill the empty list
    }

    public Enemy() {
    }

    public EnemyTag getEnemy_name() {
        return enemy_tag;
    }

    public void setEnemy_name(EnemyTag enemy_name) {
        Enemy.enemy_tag = enemy_name;
    }


    private static EnemyTag enemy_tag;

    enum EnemyTag {
        troll,
        acromantula,
        goyle,
        fire_slug,
        deatheater
    }
}
