package ohtu.verkkokauppa.interfaces;

public interface PankkiInterface {

  public boolean tilisiirto(
    String nimi,
    int viitenumero,
    String tililta,
    String tilille,
    int summa);

}
