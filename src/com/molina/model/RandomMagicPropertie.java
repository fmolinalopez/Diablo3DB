package com.molina.model;

/**
 * Created by Fran on 17/05/2017.
 */
public enum RandomMagicPropertie {
    DAMAGE_PERCENT (randomNum(), "% Damage"),
    LIFE_PERCENT (randomNum(), "% Life"),
    VITALITY(randomStatNum(), " Vitality"),
    ARMOR(randomStatNum(), " Armor");

    private final int RANDOM_NUM;
    private final String MAGIC_PORPERTIE;

    RandomMagicPropertie(int RANDOM_NUM, String MAGIC_PORPERTIE) {
        this.RANDOM_NUM = RANDOM_NUM;
        this.MAGIC_PORPERTIE = MAGIC_PORPERTIE;
    }

    private static int randomNum(){
        return (int)(1+Math.random()*10);
    }

    private static int randomStatNum() {
        return (int)(500+Math.random()*150);
    }

    public int getRANDOM_NUM() {
        return RANDOM_NUM;
    }

    public String getMAGIC_PORPERTIE() {
        return MAGIC_PORPERTIE;
    }
}
