package ohtu.verkkokauppa;

import java.util.ArrayList;
import ohtu.verkkokauppa.interfaces.*;

public class Ostoskori {

    ArrayList<TuoteInterface> tuotteet;

    public Ostoskori() {
        tuotteet = new ArrayList<TuoteInterface>();
    }

    public void lisaa(TuoteInterface t) {
        tuotteet.add(t);
    }

    public void poista(TuoteInterface t) {
        tuotteet.remove(t);
    }

    public int hinta() {
        int hinta = 0;

        for (TuoteInterface tuote : tuotteet) {
            hinta += tuote.getHinta();
        }

        return hinta;
    }
}
