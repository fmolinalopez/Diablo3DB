package com.molina.model;

/**
 * Created by Fran on 17/05/2017.
 */
public class Sword extends Weapon {

    // Atributos

    private int attackSpeed;
    private RandomMagicPropertie randomMagicPropertie1;
    private RandomMagicPropertie randomMagicPropertie2;
    private RandomMagicPropertie randomMagicPropertie3;

    // Constructores

    public Sword(String weaponName, String legendaryPower, double dps) {
        super(weaponName, legendaryPower, dps);
        this.attackSpeed = Weapon.randomAttackSpeed();
        this.randomMagicPropertie1 = Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie2 = Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie3 = Weapon.generateRandomMagicPropertie();
    }

    // Metodos

    @Override
    public String toString() {
        return  "Weapon type: Sword" + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "RandomMagicPropertie1: +" + randomMagicPropertie1.getRANDOM_NUM() + "" + randomMagicPropertie1.getMAGIC_PORPERTIE() + '\n' +
                "RandomMagicPropertie2: +" + randomMagicPropertie2.getRANDOM_NUM() + "" + randomMagicPropertie2.getMAGIC_PORPERTIE() + '\n' +
                "RandomMagicPropertie3: +" + randomMagicPropertie3.getRANDOM_NUM() + "" + randomMagicPropertie3.getMAGIC_PORPERTIE() ;
    }


    // Accesores

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public RandomMagicPropertie getRandomMagicPropertie1() {
        return randomMagicPropertie1;
    }

    public RandomMagicPropertie getRandomMagicPropertie2() {
        return randomMagicPropertie2;
    }

    public RandomMagicPropertie getRandomMagicPropertie3() {
        return randomMagicPropertie3;
    }
}
