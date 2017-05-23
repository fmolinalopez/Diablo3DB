package com.molina.model;

/**
 * Created by User01 on 22/05/2017.
 */
public class Crossbow extends Weapon {

    // Atributos

    private int attackSpeed;
    private int poisonDamage;
    private RandomMagicPropertie randomMagicPropertie1;
    private RandomMagicPropertie randomMagicPropertie2;

    // Constructores

    public Crossbow(String weaponName, String legendaryPower, double dps) {
        super(weaponName, legendaryPower, dps);
        this.attackSpeed = Weapon.randomAttackSpeed();
        this.poisonDamage = randomPoisonDamage();
        this.randomMagicPropertie1 = Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie2 = Weapon.generateRandomMagicPropertie();
    }

    // Metodos

    private int randomPoisonDamage() {
        return (int)(50+Math.random()*20);
    }

    @Override
    public String toString() {
        return  "Weapon type: Crossbow" + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "Poison Damage: +" + poisonDamage + "% \n" +
                "RandomMagicPropertie1: +" + randomMagicPropertie1.getRANDOM_NUM() + "" + randomMagicPropertie1.getMAGIC_PORPERTIE() + '\n' +
                "RandomMagicPropertie2: +" + randomMagicPropertie2.getRANDOM_NUM() + "" + randomMagicPropertie2.getMAGIC_PORPERTIE() ;
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

    public int getPoisonDamage() {
        return poisonDamage;
    }
}
