package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends RockPaperScissors {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto(String firstMove) {
        String secondMove = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + secondMove);
        tekoaly.asetaSiirto(firstMove);
        return secondMove;
    }

}