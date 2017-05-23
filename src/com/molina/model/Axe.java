package com.molina.model;

/**
 * Created by User01 on 22/05/2017.
 */
public class Axe extends Weapon{


    // Atributos

    private int attackSpeed;
    private int armorPenetration;
    private RandomMagicPropertie randomMagicPropertie1;
    private RandomMagicPropertie randomMagicPropertie2;

    // Constructores

    public Axe(String weaponName, String legendaryPower, double dps) {
        super(weaponName, legendaryPower, dps);
        this.attackSpeed = Weapon.randomAttackSpeed();
        this.armorPenetration = randomArmorPen();
        this.randomMagicPropertie1 = new RandomMagicPropertie();
        this.randomMagicPropertie2 = new RandomMagicPropertie();
    }

    // Metodos

    private int randomArmorPen() {
        return (int)(10+Math.random()*15);
    }

    @Override
    public String toString() {
        return  "Weapon type: " + this.getClass().getSimpleName() + '\n' +
                super.toString() + '\n' +
                "AttackSpeed: +" + attackSpeed + "% \n" +
                "Armor penetration: +" + armorPenetration + "% \n" +
                "+" + randomMagicPropertie1.getNum() + "" + randomMagicPropertie1.getStat() + '\n' +
                "+" + randomMagicPropertie2.getNum() + "" + randomMagicPropertie2.getStat();
    }


    // Accesores

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getArmorPenetration() {
        return armorPenetration;
    }

    public RandomMagicPropertie getRandomMagicPropertie1() {
        return randomMagicPropertie1;
    }

    public RandomMagicPropertie getRandomMagicPropertie2() {
        return randomMagicPropertie2;
    }
}
