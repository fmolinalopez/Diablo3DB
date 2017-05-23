package com.molina;

import com.molina.controller.DiabloApp;
import com.molina.model.*;

public class Main {

    public static void main(String[] args) {

        DiabloApp diabloApp = new DiabloApp();

        diabloApp.loadTestWeapons();
        diabloApp.run();

    }
}
