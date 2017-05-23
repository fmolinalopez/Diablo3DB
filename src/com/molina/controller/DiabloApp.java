package com.molina.controller;

import com.molina.model.*;

import java.util.Scanner;

/**
 * Created by Fran on 17/05/2017.
 */
public class DiabloApp {

    private Scanner input = new Scanner(System.in);
    private DiabloDB diabloDB = new DiabloDB();

    public void run(){
        int option;

        while ( (option=showMenu()) != 0){
            switch (option){
                case 1:
                    readWeapon();
                    break;
                case 2:
                    readIndex();
                    break;
                case 3:
                    showWeaponsName();
                    break;
                case 4:
                    showWeaponsDps();
                    break;
                case 5:
                    showWeaponsStats();
                    break;

            }
        }
    }

    public void loadTestWeapons() {
        diabloDB.addWeapon(new Sword("Fulminator", "Chance on hit to apply lightning damage", 125.3));
        diabloDB.addWeapon(new Sword("Doombringer","Physical skills deals 15-20% more damage", 200));
        diabloDB.addWeapon(new Axe("Genzaniku", "Chance to summon a ghostly fallen champion when attacking", 150));
        diabloDB.addWeapon(new Axe("Hack", "75-100% of your Thorns damage is applied on every attack", 50));
        diabloDB.addWeapon(new Crossbow("Calamity", "Enemies you hit become Marked for Death", 90));
        diabloDB.addWeapon(new Crossbow("Balefire caster", "Fire skills deal 15-20% more damage", 70));
        diabloDB.addWeapon(new Wand("Aether walker", "Teleport no longer has a cooldown but cost 25 Arcane power", 40));
        diabloDB.addWeapon(new Wand("Serpent's sparker", "You may have one extra Hydra active at a time", 30));
    }

    private void showWeaponsName() {
        diabloDB.sortByName();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# " + weapon.getWeaponName());
            index++;
        }
    }

    private void showWeaponsDps() {
        diabloDB.sortByDps();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# Weapon name: " + weapon.getWeaponName() + " Dps: " + weapon.getDps());
            index++;
        }
    }

    private void showWeaponsStats() {
        diabloDB.sortByName();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# " + weapon);
            System.out.println();
            index++;
        }
    }

    private void readWeapon() {
        int weaponType;
        String name;
        String legendaryPower;
        double dps;

        System.out.println("Enter weapon type");
        System.out.println("1.- Sword");
        System.out.println("2.- Axe");
        System.out.println("3.- Crossbow");
        System.out.println("4.- Wand");
        weaponType = input.nextInt();
        input.nextLine();
        System.out.println("Enter weapon name:");
        name = input.nextLine();
        System.out.println("Enter weapon Legendary power:");
        legendaryPower = input.nextLine();
        System.out.println("Enter weapon dps:");
        dps = input.nextDouble();

        diabloDB.addWeapon(weaponType(weaponType, name, legendaryPower, dps));
    }

    private void readIndex() {
        int index;

        showWeaponsName();

        do {
            System.out.println("Enter weapon index:");
            index = input.nextInt()-1;
        }while (!correctIndex(index));

        diabloDB.removeWeapon(index);
    }

    private boolean correctIndex(int index){
        if (index < 0 || index > diabloDB.getWeapons().size()) {
            return false;
        } else {
            return true;
        }
    }

    private Weapon weaponType(int weaponType, String name, String legendaryPower, double dps) {
        Weapon weapon;

            switch (weaponType){
                case 1:
                    weapon = new Sword(name,legendaryPower,dps);
                    break;
                case 2:
                    weapon = new Axe(name,legendaryPower,dps);
                    break;
                case 3:
                    weapon = new Crossbow(name,legendaryPower,dps);
                    break;
                case 4:
                    weapon = new Wand(name,legendaryPower,dps);
                    break;
                default:
                    weapon = new Sword(name, legendaryPower, dps);
            }

        return weapon;
    }

    private int showMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("***********************************");
        System.out.println("* 1.- Add Weapon                  *");
        System.out.println("* 2.- Remove Weapon               *");
        System.out.println("* 3.- Sort Weapons by name        *");
        System.out.println("* 4.- Sort Weapons by dps         *");
        System.out.println("* 5.- Show Weapons with all stats *");
        System.out.println("* 0.- Exit                        *");
        System.out.println("***********************************");
        System.out.println("Option: ");
        option = input.nextInt();

        return option;
    }
}
