package com.molina.model;

/**
 * Created by Fran on 17/05/2017.
 */
public class PrimaryStat {

    private int num;
    private String stat;

    // Constructores

    public PrimaryStat() {
        this.num = randomNum();
        this.stat = randomStat();
    }

    // Metodos

    // Metodo que genera un stat aleatorio para el atributo primaryStat.

    private String randomStat(){
        int res = (int)(1+Math.random()*3);

        switch (res){
            case 1:
                return "Intelligence";
            case 2:
                return "Dexterity";
            case 3:
                return "Strenght";
            default:
                return "Dexterity";
        }
    }

    // Metodo que genera un numero aleatorio entre 500 y 800 para el atributo primaryStat.

    private int randomNum(){
        return (int)(500+Math.random()*300);
    }

    // Accesores

    public int getNum() {
        return num;
    }

    public String getStat() {
        return stat;
    }
}
