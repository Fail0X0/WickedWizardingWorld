package com.fail_x.wickedwizardingworld;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Wand {

    public Wand(String name, WandTag tag, Drawable wanddrawable){
        this.name = name;
        this.tag = tag;
        this.wanddrawable = wanddrawable;
    }

    public Wand(String name, WandTag tag){
        this.name = name;
        this.tag = tag;
    }

    public WandTag getTag() {
        return tag;
    }

    private String name;
    private WandTag tag;

    public String getName() {
        return name;
    }

    public Drawable getWanddrawable() {
        return wanddrawable;
    }

    private Drawable wanddrawable;

    public enum WandTag {
        cherry,
        oak
    }
}


