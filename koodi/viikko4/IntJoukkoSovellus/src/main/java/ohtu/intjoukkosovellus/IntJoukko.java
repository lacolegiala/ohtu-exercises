package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int CAPACITY = 5, // aloitustalukon koko
            DEFAULTINCREMENT = 5;  // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] queue;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int numberOfItems;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        queue = createQueue(CAPACITY);
        numberOfItems = 0;
        this.kasvatuskoko = DEFAULTINCREMENT;
    }

    public IntJoukko(int capacity) {
        if (capacity < 0) {
            return;
        }
        queue = createQueue(capacity);
        numberOfItems = 0;
        this.kasvatuskoko = DEFAULTINCREMENT;

    }


    public IntJoukko(int capacity, int kasvatuskoko) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("capacity2");//heitin vaan jotain :D
        }
        queue = createQueue(capacity);
        numberOfItems = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        return z;
    }

    private int[] createQueue(int capacity) {
        int[] queue = new int[capacity];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = 0;
        }
        return queue;
    }

    public boolean lisaa(int luku) {

        if (numberOfItems == 0) {
            queue[0] = luku;
            numberOfItems++;
            return true;
        }
        if (!kuuluu(luku)) {
            queue[numberOfItems] = luku;
            numberOfItems++;
            if (numberOfItems % queue.length == 0) {
                int[] taulukkoOld = new int[queue.length];
                taulukkoOld = queue;
                kopioiTaulukko(queue, taulukkoOld);
                queue = new int[numberOfItems + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, queue);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < numberOfItems; i++) {
            if (luku == queue[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < numberOfItems; i++) {
            if (luku == queue[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                queue[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < numberOfItems - 1; j++) {
                queue[j] = queue[j + 1];
            }
            numberOfItems--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return numberOfItems;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < numberOfItems - 1; i++) {
            tuotos += queue[i];
            tuotos += ", ";
        }
        if (numberOfItems > 0) {
            tuotos += queue[numberOfItems - 1];
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[numberOfItems];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = queue[i];
        }
        return taulu;
    }

}
