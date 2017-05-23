package com.molina.model;

/**
 * Created by Fran on 17/05/2017.
 */
public abstract class Weapon {

    // Atributos

    private String weaponName;
    private String legendaryPower;
    private PrimaryStat primaryStat;
    private double dps;

    // Constructores

    public Weapon() {
    }

    public Weapon(String weaponName, String legendaryPower, double dps) {
        this.weaponName = weaponName;
        this.legendaryPower = legendaryPower;
        this.primaryStat = new PrimaryStat();
        this.dps = dps;
    }

    // Metodos

    protected static int randomAttackSpeed(){
        return (int)(1+Math.random()*20);
    }

    protected static RandomMagicPropertie generateRandomMagicPropertie() {
        int res = (int)(1+Math.random()*4);
        RandomMagicPropertie randomMagicPropertie;
        String propertie;


        switch (res){
            case 1:
                propertie = "DAMAGE_PERCENT";
                break;
            case 2:
                propertie = "LIFE_PERCENT";
                break;
            case 3:
                propertie = "VITALITY";
                break;
            case 4:
                propertie = "ARMOR";
                break;
            default:
                propertie = "";
                break;
            }
        randomMagicPropertie = RandomMagicPropertie.valueOf(propertie);
        return randomMagicPropertie;
    }

    @Override
    public String toString() {
        return "Weapon Name: " + weaponName + '\n' +
                "LegendaryPower: " + legendaryPower + '\n' +
                "PrimaryStat: " + primaryStat.getNum() + " " + primaryStat.getStat() + '\n' +
                "Dps: " + dps + " Damage per Second";
    }
    // Accesores

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getLegendaryPower() {
        return legendaryPower;
    }

    public void setLegendaryPower(String legendaryPower) {
        this.legendaryPower = legendaryPower;
    }

    public PrimaryStat getPrimaryStat() {
        return primaryStat;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(double dps) {
        this.dps = dps;
    }
}
