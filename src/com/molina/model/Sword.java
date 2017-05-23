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
        this.randomMagicPropertie1 = new RandomMagicPropertie();
        this.randomMagicPropertie2 = new RandomMagicPropertie();
        this.randomMagicPropertie3 = new RandomMagicPropertie();
    }

    // Metodos

    @Override
    public String toString() {
        return  "Weapon type: " + this.getClass().getSimpleName() + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "+" + randomMagicPropertie1.getNum() + "" + randomMagicPropertie1.getStat() + '\n' +
                "+" + randomMagicPropertie2.getNum() + "" + randomMagicPropertie2.getStat() + '\n' +
                "+" + randomMagicPropertie3.getNum() + "" + randomMagicPropertie3.getStat() ;
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
