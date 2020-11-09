package ohtu.verkkokauppa.interfaces;

public interface VarastoInterface {

  public TuoteInterface haeTuote(int id);

  public int saldo(int id);
  
  public void otaVarastosta(TuoteInterface t);
  
  public void palautaVarastoon(TuoteInterface t);
  
}
