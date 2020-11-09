package ohtu.verkkokauppa;
import ohtu.verkkokauppa.interfaces.*;


public class Viitegeneraattori implements ViitegeneraattoriInterface {

    private static Viitegeneraattori instanssi;

    public static ViitegeneraattoriInterface getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    private Viitegeneraattori(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
