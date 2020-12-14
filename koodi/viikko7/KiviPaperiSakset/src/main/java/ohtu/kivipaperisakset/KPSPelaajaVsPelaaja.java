package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends RockPaperScissors {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String toisenSiirto() {
        return scanner.nextLine();
    }

}