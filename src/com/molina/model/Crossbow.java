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
        this.randomMagicPropertie1 = new RandomMagicPropertie();
        this.randomMagicPropertie2 = new RandomMagicPropertie();
    }

    // Metodos

    private int randomPoisonDamage() {
        return (int)(50+Math.random()*20);
    }

    @Override
    public String toString() {
        return  "Weapon type: " + this.getClass().getSimpleName() + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "Poison Damage: +" + poisonDamage + "% \n" +
                "+" + randomMagicPropertie1.getNum() + "" + randomMagicPropertie1.getStat() + '\n' +
                "+" + randomMagicPropertie2.getNum() + "" + randomMagicPropertie2.getStat() ;
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
