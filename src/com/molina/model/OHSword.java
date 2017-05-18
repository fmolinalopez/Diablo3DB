package com.molina.model;

/**
 * Created by User01 on 17/05/2017.
 */
public class OHSword extends _Weapon implements OneHanded{

    // Atributos

    private int attackSpeed;
    private RandomMagicPropertie randomMagicPropertie1;
    private RandomMagicPropertie randomMagicPropertie2;
    private RandomMagicPropertie randomMagicPropertie3;

    // Constructores

    public OHSword(String weaponName, String legendaryPower, double dps) {
        super(weaponName, legendaryPower, dps);
        this.attackSpeed = _Weapon.randomAttackSpeed();
        this.randomMagicPropertie1 = _Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie2 = _Weapon.generateRandomMagicPropertie();
        this.randomMagicPropertie3 = _Weapon.generateRandomMagicPropertie();
    }

    // Metodos

    @Override
    public String toString() {
        return "Weapon Type: " + "One Handed Sword" + '\n' +
                super.toString() + '\n' +
                "AttackSpeed=" + attackSpeed + '\n' +
                "RandomMagicPropertie1=" + randomMagicPropertie1.getRANDOM_NUM() + " " + randomMagicPropertie1.getMAGIC_PORPERTIE() + '\n' +
                "RandomMagicPropertie2=" + randomMagicPropertie2.getRANDOM_NUM() + " " + randomMagicPropertie2.getMAGIC_PORPERTIE() + '\n' +
                "RandomMagicPropertie3=" + randomMagicPropertie3.getRANDOM_NUM() + " " + randomMagicPropertie3.getMAGIC_PORPERTIE() ;
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
