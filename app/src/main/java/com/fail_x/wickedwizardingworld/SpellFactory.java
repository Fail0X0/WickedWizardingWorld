package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SpellFactory {
    private static final boolean D = true;
    private static final String TAG = SpellFactory.class.getName();

    public SpellFactory() {
        CreateSpells();
    }

    public List<Spell> getSpellList() {
        return spell_list;
    }

    public void setSpellList(List<Spell> spell_list) {
        this.spell_list = spell_list;
    }


    public String[] getSpellNames() {
        String[] name_list = new String[spell_list.size()];

        for (int i = 0; i < spell_list.size(); i++) {
            name_list[i] = spell_list.get(i).getName();
        }

        return name_list;
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

    private List<Spell> spell_list = new ArrayList<>();

    void CreateSpells() {
        spell_list.add(new Spell("Stupor", 0.01f, -1, Spell.Type.curse, Spell.SpellTag.stupor));
        spell_list.add(new Spell("Finite Incantatem", 0.1f, -1, Spell.Type.curse, Spell.SpellTag.finite_incantatem));
        spell_list.add(new Spell("Draught of Living Death", 0.01f, -1, Spell.Type.curse, Spell.SpellTag.poisen));
        spell_list.add(new Spell("Eat Slugs", 0.1f, -1, Spell.Type.curse, Spell.SpellTag.eat_slugs));
        spell_list.add(new Spell("Troll club", 0.01f, -1, Spell.Type.curse, Spell.SpellTag.club));
        spell_list.add(new Spell("Expelliarmus", 0.01f, -1, Spell.Type.protect, Spell.SpellTag.expelliarmus));
        spell_list.add(new Spell("Protego", 0.01f, -1, Spell.Type.protect, Spell.SpellTag.protego));
    }
}