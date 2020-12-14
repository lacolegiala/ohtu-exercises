package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends RockPaperScissors {

    private static final Scanner scanner = new Scanner(System.in);
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    
    @Override
    protected String toisenSiirto(String firstMove) {
        String secondMove = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + secondMove);
        tekoaly.asetaSiirto(firstMove);
        return secondMove;
    }

}
