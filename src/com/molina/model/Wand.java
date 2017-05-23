package com.molina.model;

/**
 * Created by User01 on 22/05/2017.
 */
public class Wand extends Weapon {

    // Atributos

    private int attackSpeed;
    private int magicDamage;
    private RandomMagicPropertie randomMagicPropertie1;
    private RandomMagicPropertie randomMagicPropertie2;

    // Constructores

    public Wand(String weaponName, String legendaryPower, double dps) {
        super(weaponName, legendaryPower, dps);
        this.attackSpeed = Weapon.randomAttackSpeed();
        this.magicDamage = randomMagicDamage();
        this.randomMagicPropertie1 = Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie2 = Weapon.generateRandomMagicPropertie();
    }

    // Metodos

    private int randomMagicDamage() {
        return (int)(10+Math.random()*90);
    }

    @Override
    public String toString() {
        return  "Weapon type: " + this.getClass().getSimpleName() + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "Magic damage: +" + magicDamage + "% \n" +
                "+" + randomMagicPropertie1.getRANDOM_NUM() + "" + randomMagicPropertie1.getMAGIC_PORPERTIE() + '\n' +
                "+" + randomMagicPropertie2.getRANDOM_NUM() + "" + randomMagicPropertie2.getMAGIC_PORPERTIE();
    }


    // Accesores

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public RandomMagicPropertie getRandomMagicPropertie1() {
        return randomMagicPropertie1;
    }

    public RandomMagicPropertie getRandomMagicPropertie2() {
        return randomMagicPropertie2;
    }

}
