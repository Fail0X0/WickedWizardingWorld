package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class EnemyFactory extends Dueller{
    private static final boolean D = true;
    private static final String TAG = EnemyFactory.class.getName();

    public EnemyFactory() {
        CreateEnemys();
    }

    public List<Dueller> getEnemy_list() {
        return enemy_list;
    }

    public void setEnemy_list(List<Dueller> enemy_list) {
        this.enemy_list = enemy_list;
    }

    List<Dueller> enemy_list = new ArrayList<>();

    public Dueller getEnemy(EnemyTag enemy_name) {
        int i;
        boolean found = false;

        for (i = 0; i < enemy_list.size(); i++) {
            if (enemy_list.get(i).getEnemy_name() == enemy_name) {
                found = true;
                break;
            }
        }
        if (found)
            return enemy_list.get(i);
        else {
            if(D) Log.e(TAG, "Spell could not be found in list. Check writing. getSpell returned NULL!");
            return null;
        }
    }

    private void CreateEnemys(){
        enemy_list.add(new Dueller("Troll", EnemyTag.troll,1, 0.01f,  1.5f, House.monster));
        enemy_list.add(new Dueller("Acromantula", EnemyTag.acromantula,2, 0.01f,1, House.monster));
        enemy_list.add(new Dueller("Goyle", EnemyTag.goyle,6,  0.01f,1, House.slytherin));

    }

    private void AddSpells(){
        //Initiate Spells of Troll
        getEnemy(EnemyTag.troll).setSpell(getSpell(Spell.SpellTag.club));
    }
}
