package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Player extends Dueller {
    private static final boolean D = true;
    private static final String TAG = Player.class.getName();

    Player() {
        this.setName("");
        this.setMana(10);
        this.setDamage((float) 0.01);
        this.setFight_spell_list(new ArrayList<Spell>());
        this.setSpell_list(new ArrayList<Spell>());
    }

    protected static Player User = new Player();
    private List<Spell> fight_spell_list = new ArrayList<>();
    private List<Wand> wand_list = new ArrayList<>();

    public List<Wand> getWand_list() {
        return wand_list;
    }

    public void setWand_list(List<Wand> wand_list) {
        this.wand_list = wand_list;
    }

    public void setWand(Wand wand) {
        this.wand_list.add(wand);
    }

    public Wand getWand(Wand.WandTag tag) {
        int i;
        boolean found = false;

        for (i = 0; i < wand_list.size(); i++) {
            if (wand_list.get(i).getTag() == tag) {
                found = true;
                break;
            }
        }
        if (found)
            return wand_list.get(i);
        else {
            if (D)
                Log.e(TAG, "Wand could not be found in list. Check writing. getSpell returned NULL!");
            return null;
        }
    }

    public List<Spell> getFight_spell_list() {
        return fight_spell_list;
    }

    public void setFight_spell_list(List<Spell> fight_spell_list) {
        this.fight_spell_list = fight_spell_list;
    }

    public Player getInstancePlayer() {
        if (User == null) {
            User = new Player();
        }
        return User;
    }

    public String[] getSpellNamesforDisplay() {         //IS THIS STILL NEEDE? LOOK UP SPELLFACTORYS getSpellNames()
        String[] name_list = new String[getInstancePlayer().getSpell_list().size()];

        for (int i = 0; i < getInstancePlayer().getSpell_list().size(); i++) {
            name_list[i] = getInstancePlayer().getSpell_list().get(i).getName();
        }

        return name_list;
    }
}
