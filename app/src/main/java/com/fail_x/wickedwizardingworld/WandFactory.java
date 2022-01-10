package com.fail_x.wickedwizardingworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WandFactory {
    private static final boolean D = true;
    private static final String TAG = WandFactory.class.getName();

    public WandFactory() {
        CreateWands();
    }

    private List<Wand> wand_list = new ArrayList<>();

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

    void CreateWands() {        //DRAWABLE KANN NICHT INTEGRIERT WERDEN
        wand_list.add(new Wand("Oak Wand", Wand.WandTag.oak));
    }

}
