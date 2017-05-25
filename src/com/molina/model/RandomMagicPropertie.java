package com.molina.model;

import java.io.Serializable;

/**
 * Created by Fran on 17/05/2017.
 */
public class RandomMagicPropertie implements Serializable{

    private int num;
    private String stat;

    RandomMagicPropertie() {
        this.num = randomNum();
        this.stat = randomStat();
    }

    //Metodos

    // Metodo que genera un numero aleatorio entre 10 y 30.

    private int randomNum() {
        return (int)(10+Math.random()*20);
    }

    // Metodo que genera un stat aleatorio entre 4 opciones.

    private String randomStat() {
        String res;
        int num = (int)(1+Math.random()*4);
        switch (num){
            case 1:
                res = "% Damage";
                break;
            case 2:
                res = "% Life";
                break;
            case 3:
                res = "% Vitality";
                break;
            case 4:
                res = "% Armor";
                break;
            default:
                res = "";
                break;
        }

        return res;
    }

    // Accesores

    public int getNum() {
        return num;
    }

    public String getStat() {
        return stat;
    }
}
