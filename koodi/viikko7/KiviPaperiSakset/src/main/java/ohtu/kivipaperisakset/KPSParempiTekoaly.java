package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends RockPaperScissors {
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    private KPSParempiTekoaly() {

    }

    public static KPSParempiTekoaly createGame() {
        return new KPSParempiTekoaly();
    }

    @Override
    protected String toisenSiirto(String firstMove) {
        String secondMove = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + secondMove);
        tekoaly.asetaSiirto(firstMove);
        return secondMove;
    }

}
