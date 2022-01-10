package com.fail_x.wickedwizardingworld;

public class Spell {

    public Spell(String name, float damage, int mana, float healing, Type type, SpellTag tag) {
        this.name = name;
        this.damage = damage;
        this.healing = healing;
        this.mana = mana;
        this.type = type;
        this.tag = tag;
    }

    public Spell(String name, int mana, float healing, Type type, SpellTag tag) {
        this.name = name;
        this.damage = 0;
        this.healing = healing;
        this.mana = mana;
        this.type = type;
        this.tag = tag;
    }

    public Spell(String name, float damage, int mana, Type type, SpellTag tag) {
        this.name = name;
        this.damage = damage;
        this.healing = 0;
        this.mana = mana;
        this.type = type;
        this.tag = tag;
    }

    public Spell(String name, float damage, float healing, Type type, SpellTag tag) {
        this.name = name;
        this.damage = damage;
        this.healing = healing;
        this.mana = 0;
        this.type = type;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getHealing() {
        return healing;
    }

    public void setHealing(float healing) {
        this.healing = healing;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public SpellTag getTag() {
        return tag;
    }

    public void setTag(SpellTag tag) {
        this.tag = tag;
    }

    private String name;
    private float damage;
    private float healing;
    private Type type;
    private int mana;
    private SpellTag tag;

    public enum Type {
        curse,
        protect,
        heal,
        mana
    }

    public enum SpellTag {
        stupor,
        expelliarmus,
        protego,
        finite_incantatem,
        club,
        eat_slugs,
        poisen
    }
}
