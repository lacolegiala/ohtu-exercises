package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class RockPaperScissors {

    private static final Scanner scanner = new Scanner(System.in);

    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        // ...

        String ekanSiirto = ensimmaisenSiirto();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ensimmaisenSiirto();

            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto(String firstMove);

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
