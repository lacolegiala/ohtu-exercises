package ohtu.kivipaperisakset;

public class KPSTekoaly extends RockPaperScissors {
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto(String firstMove) {
        String secondMove = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + secondMove);
        tekoaly.asetaSiirto(firstMove);
        return secondMove;
    }

}