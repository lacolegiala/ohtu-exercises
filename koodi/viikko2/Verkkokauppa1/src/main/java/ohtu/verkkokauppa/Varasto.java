package ohtu.verkkokauppa;
import ohtu.verkkokauppa.interfaces.*;

import java.util.*;

public class Varasto implements VarastoInterface {

    private static Varasto instanssi;

    public static VarastoInterface getInstance() {
        if (instanssi == null) {
            instanssi = new Varasto();
        }

        return instanssi;
    }
    
    private Kirjanpito kirjanpito;
    private HashMap<TuoteInterface, Integer> saldot;  
    
    private Varasto() {
        kirjanpito = Kirjanpito.getInstance();
        saldot = new HashMap<TuoteInterface, Integer>();
        alustaTuotteet();
    }
            
    public TuoteInterface haeTuote(int id){
        for (TuoteInterface t : saldot.keySet()) {
            if ( t.getId()==id) return t;
        }
        
        return null;
    }

    public int saldo(int id){
        return saldot.get(haeTuote(id));
    }
    
    public void otaVarastosta(TuoteInterface t){        
        saldot.put(t,  saldo(t.getId())-1 );
        kirjanpito.lisaaTapahtuma("otettiin varastosta "+t);
    }
    
    public void palautaVarastoon(TuoteInterface t){
        saldot.put(t,  saldo(t.getId())+1 );
        kirjanpito.lisaaTapahtuma("palautettiin varastoon "+t);
    }    
    
    private void alustaTuotteet() {
        saldot.put(new Tuote(1, "Koff Portteri", 3), 100);
        saldot.put(new Tuote(2, "Fink Bräu I", 1), 25);
        saldot.put(new Tuote(3, "Sierra Nevada Pale Ale", 5), 30);
        saldot.put(new Tuote(4, "Mikkeller not just another Wit", 7), 40);
        saldot.put(new Tuote(5, "Weihenstephaner Hefeweisse", 4), 15);
    }
}
