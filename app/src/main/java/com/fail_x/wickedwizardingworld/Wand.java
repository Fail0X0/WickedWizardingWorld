package com.fail_x.wickedwizardingworld;


public class Wand {

    public Wand(String name, WandTag tag, int picture_path) {
        this.name = name;
        this.tag = tag;
        this.picture_path = picture_path;
    }

    public Wand(String name, WandTag tag) {
        this.name = name;
        this.tag = tag;
    }

    private String name;
    private WandTag tag;
    private int picture_path;

    public int getPicture_path() {
        return picture_path;
    }

    public WandTag getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }


    public enum WandTag {
        cherry,
        oak
    }
}


