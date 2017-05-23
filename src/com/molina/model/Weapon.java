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

    //Metodo que genera una velocidad de ataque aleatoria entre 1 y 20 para el arma.

    protected static int randomAttackSpeed(){
        return (int)(1+Math.random()*20);
    }

    // Metodo que genera una propiedad aleatoria para el arma.

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
