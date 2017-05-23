package com.molina.model;

import java.util.*;

/**
 * Created by Fran on 22/05/2017.
 */
public class DiabloDB {

    // Atributos

    private ArrayList<Weapon> weapons = new ArrayList<>();

    // Constructores

    public DiabloDB() {
        weapons = new ArrayList<>();
    }

    // Metodos

    public Comparator<Weapon> sortByWeaponsName = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon wp1, Weapon wp2) {
            int res;

            res = wp1.getWeaponName().compareToIgnoreCase(wp2.getWeaponName());

            if (res != 0) { return res; }

            return (int)(wp1.getDps() - wp2.getDps());
        }
    };

    public Comparator<Weapon> sortByWeaponsDps = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon wp1, Weapon wp2) {
            int res;

            res = (int)(wp2.getDps() - wp1.getDps());

            if (res != 0 ) { return res; }

            return wp1.getWeaponName().compareToIgnoreCase(wp2.getWeaponName());
        }
    };

    public Comparator<Weapon> sortByWeaponsType = new Comparator<Weapon>() {
        @Override
        public int compare(Weapon wp1, Weapon wp2) {
            int res;

            res = wp1.getClass().getSimpleName().compareToIgnoreCase(wp2.getClass().getSimpleName());

            if (res != 0) { return res; }

            return wp1.getWeaponName().compareToIgnoreCase(wp2.getWeaponName());
        }
    };

    public void sortByDps() {
        Collections.sort(weapons, sortByWeaponsDps);
    }

    public void sortByName() {
        Collections.sort(weapons, sortByWeaponsName);
    }

    public void sortByType() {
        Collections.sort(weapons, sortByWeaponsType);
    }

    public void addWeapon(Weapon weapon) {
        if (weapon != null){
            weapons.add(weapon);
        }
    }

    public void removeWeapon(int index) {
        weapons.remove(index);
    }

    // Accesores

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
