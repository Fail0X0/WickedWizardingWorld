package com.fail_x.wickedwizardingworld;

import android.graphics.drawable.Drawable;

public class Wand{

    public Wand(String name, WandTag tag, Drawable wanddrawable) {
        this.name = name;
        this.tag = tag;
        this.wanddrawable = wanddrawable;
    }

    public Wand(String name, WandTag tag) {
        this.name = name;
        this.tag = tag;
    }

    private String name;
    private WandTag tag;
    private Drawable wanddrawable;

    public WandTag getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public Drawable getWanddrawable() {
        return wanddrawable;
    }

    public enum WandTag {
        cherry,
        oak
    }
}


