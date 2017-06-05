package com.molina.controller;

import com.molina.model.*;
import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Fran on 17/05/2017.
 */
public class DiabloApp {

    private Scanner input = new Scanner(System.in);
    private DiabloDB diabloDB = new DiabloDB();

    public DiabloApp() {
        diabloDB = new DiabloDB();
        diabloDB.loadWeapons();
    }

    public void run(){
        int option;

        while ( (option=showMenu()) != 0){
            switch (option){
                case 1:
                    readWeapon();
                    break;
                case 2:
                    readRemoveIndex();
                    break;
                case 3:
                    readModifyIndex();
                    break;
                case 4:
                    showWeaponsName();
                    break;
                case 5:
                    showWeaponsDps();
                    break;
                case 6:
                    showWeaponsType();
                    break;
                case 7:
                    showWeaponsStats();
                    break;

            }
        }
        diabloDB.saveWeapons();
    }

//    // Metodo que carga armas de prueba al arraylist weapons.
//
//    public void loadTestWeapons() {
//        diabloDB.addWeapon(new Sword("Fulminator", "Chance on hit to apply lightning damage", 125.3));
//        diabloDB.addWeapon(new Sword("Doombringer","Physical skills deals 15-20% more damage", 200));
//        diabloDB.addWeapon(new Axe("Genzaniku", "Chance to summon a ghostly fallen champion when attacking", 150));
//        diabloDB.addWeapon(new Axe("Hack", "75-100% of your Thorns damage is applied on every attack", 50));
//        diabloDB.addWeapon(new Crossbow("Calamity", "Enemies you hit become Marked for Death", 90));
//        diabloDB.addWeapon(new Crossbow("Balefire caster", "Fire skills deal 15-20% more damage", 70));
//        diabloDB.addWeapon(new Wand("Aether walker", "Teleport no longer has a cooldown but cost 25 Arcane power", 40));
//        diabloDB.addWeapon(new Wand("Serpent's sparker", "You may have one extra Hydra active at a time", 30));
//    }

    // Metodo que imprime el nombre de las armas en orden alfabetico.

    private void showWeaponsName() {
        diabloDB.sortByName();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# " + weapon.getWeaponName());
            index++;
        }
    }

    // Metodo que imprime el nombre y el dps de las armas ordenadas de mas a menos dps.

    private void showWeaponsDps() {
        diabloDB.sortByDps();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# Weapon name: " + weapon.getWeaponName() + ", Type: " + weapon.getClass().getSimpleName() + ", Dps: " + weapon.getDps());
            index++;
        }
    }

    // Metodo que imprime el nombre y el tipo de las armas ordenadas alfabeticamente por el tipo.

    private void showWeaponsType() {
        diabloDB.sortByType();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# Weapon name: " + weapon.getWeaponName() + ", Type: " + weapon.getClass().getSimpleName());
            index++;
        }
    }


    // Metodo que imprime las armas con todas sus estadisticas ordenadas alfabeticamente por tipo.

    private void showWeaponsStats() {
        diabloDB.sortByType();

        int index = 1;
        for (Weapon weapon: diabloDB.getWeapons()) {
            System.out.println(index + "# " + weapon);
            System.out.println();
            index++;
        }
    }

    // Metodo que pide datos al usuario para añadir un nuevo arma al arraylist weapons.

    private void readWeapon() {
        int weaponType;
        String name;
        String legendaryPower;
        double dps;

        do {
            System.out.println("Enter weapon type");
            weaponType = weaponTypeExcpt();
        } while (weaponType < 1 || weaponType > 4 );

        do {
            System.out.println("Enter weapon name:");
            name = input.nextLine().trim().replaceAll("\\s+", " ");
        } while (name.equals(""));

        do {
            System.out.println("Enter weapon Legendary power:");
            legendaryPower = input.nextLine().trim().replaceAll("\\s+", " ");
        } while (legendaryPower.equals(""));

        do {
            System.out.println("Enter weapon dps:");
            dps = weaponDps();
        } while (dps < 0);

        diabloDB.addWeapon(weaponType(weaponType, name, legendaryPower, dps));
    }

    // Metodo que implementa una excepcion para que no falle al introducir una letra en la eleccion de tipo de arma

    private int weaponTypeExcpt() {
        Scanner input = new Scanner(System.in);
        int type;

        System.out.println("1.- Sword");
        System.out.println("2.- Axe");
        System.out.println("3.- Crossbow");
        System.out.println("4.- Wand");

        try {
            type = input.nextInt();
            return type;
        } catch (InputMismatchException e) {
            System.out.println("Enter a correct number:");
        }

        return weaponTypeExcpt();
    }

    // Metodo que creara un arma en funcion del tipo de arma que introduzca el usuario.

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

    // Metodo que implementa una excepcion para que no falle al introducir letras en el dps

    private double weaponDps() {
        Scanner input = new Scanner(System.in);
        double dps;

        try {
            dps = input.nextDouble();
            return dps;
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid dps");
        }

        return weaponDps();
    }

    // Metodo que implementa una excepcion al leer el indice para que no falle al introducir una letra en vez de un entero.

    public int indexExcpt() {
        Scanner input = new Scanner(System.in);
        int index;

        try {
            index = input.nextInt() - 1;
            return index;
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid index");
        }

        return indexExcpt();
    }

    // Metodo que pide el indice de un arma al usuario para borrarla del arraylist weapons.

    private void readRemoveIndex() {
        int index;

        showWeaponsType();

        do {
            System.out.println("Enter weapon index:");
            index = indexExcpt();
        }while (!correctIndex(index));

        diabloDB.removeWeapon(index);
    }


    // Metodo que pide el indice y los datos del arma que se desea modificar

    private void readModifyIndex() {
        int index;
        String name;
        String legendaryPower;
        double dps;

        showWeaponsType();

        do {
            System.out.println("Enter weapon index:");
            index = indexExcpt();
        }while (!correctIndex(index));

        do {
            System.out.println("Enter new weapon name:");
            name = input.nextLine().trim().replaceAll("\\s+", " ");
        } while (name.equals(""));

        do {
            System.out.println("Enter new weapon Legendary power:");
            legendaryPower = input.nextLine().trim().replaceAll("\\s+", " ");
        } while (legendaryPower.equals(""));

        do {
            System.out.println("Enter new weapon dps:");
            dps = weaponDps();
        } while (dps < 0);


        diabloDB.modifyWeapon(name, legendaryPower, dps, index);
    }

    // Metodo que comprueba que el indice introducido por el usuario corresponde a un arma
    // existente en el arraylist weapons.

    private boolean correctIndex(int index){
        if (index < 0 || index > diabloDB.getWeapons().size()) {
            return false;
        } else {
            return true;
        }
    }

    // Metodo que imprime el menu principal

    private int showMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("***********************************");
        System.out.println("* 1.- Add Weapon                  *");
        if (diabloDB.getWeapons().size() > 0) {
            System.out.println("* 2.- Remove Weapon               *");
            System.out.println("* 3.- Modify Weapon               *");
            System.out.println("* 4.- Sort Weapons by name        *");
            System.out.println("* 5.- Sort Weapons by dps         *");
            System.out.println("* 6.- Show Weapons by type        *");
            System.out.println("* 7.- Show Weapons with all stats *");
        }
        System.out.println("* 0.- Exit                        *");
        System.out.println("***********************************");
        System.out.println("Option: ");

        try {
            option = input.nextInt();
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid option");
        }

        return showMenu();
    }
}
