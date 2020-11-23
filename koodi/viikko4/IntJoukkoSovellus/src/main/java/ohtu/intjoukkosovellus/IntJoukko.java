package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int CAPACITY = 5, // aloitustalukon koko
            DEFAULTINCREMENT = 5;  // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int incrementSize;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] queue;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int numberOfItems;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(CAPACITY, DEFAULTINCREMENT);
    }

    public IntJoukko(int capacity) {
        this(capacity, DEFAULTINCREMENT);
    }


    public IntJoukko(int capacity, int incrementSize) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Kapasiteetti väärin");//heitin vaan jotain :D
        }
        if (incrementSize < 0) {
            throw new IllegalArgumentException("Kasvatuskoko väärin");//heitin vaan jotain :D
        }
        queue = createQueue(capacity);
        numberOfItems = 0;
        this.incrementSize = incrementSize;

    }

    public static IntJoukko yhdiste(IntJoukko firstIntSet, IntJoukko secondIntSet) {
        IntJoukko finalIntSet = new IntJoukko();
        for (int i = 0; i < firstIntSet.numberOfItems; i++) {
            finalIntSet.lisaa(firstIntSet.queue[i]);
        }
        for (int i = 0; i < secondIntSet.numberOfItems; i++) {
            finalIntSet.lisaa(secondIntSet.queue[i]);
        }
        return finalIntSet;
    }

    public static IntJoukko leikkaus(IntJoukko firstIntSet, IntJoukko secondIntSet) {
        IntJoukko finalIntSet = new IntJoukko();
        for (int i = 0; i < firstIntSet.numberOfItems; i++) {
            for (int j = 0; j < secondIntSet.numberOfItems; j++) {
                if (firstIntSet.queue[i] == secondIntSet.queue[j]) {
                    finalIntSet.lisaa(secondIntSet.queue[j]);
                }
            }
        }
        return finalIntSet;

    }

    public static IntJoukko erotus(IntJoukko firstIntSet, IntJoukko secondIntSet) {
        IntJoukko finalIntSet = new IntJoukko();
        for (int i = 0; i < firstIntSet.numberOfItems; i++) {
            finalIntSet.lisaa(firstIntSet.queue[i]);
        }
        for (int i = 0; i < secondIntSet.numberOfItems; i++) {
            finalIntSet.poista(secondIntSet.queue[i]);
        }

        return finalIntSet;
    }

    private int[] createQueue(int capacity) {
        int[] queue = new int[capacity];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = 0;
        }
        return queue;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            queue[numberOfItems] = luku;
            numberOfItems++;
            if (numberOfItems % queue.length == 0) {
                int[] taulukkoOld = queue;
                queue = new int[numberOfItems + incrementSize];
                kopioiTaulukko(taulukkoOld, queue);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        if (location(luku) == -1) {
            return false;
        }
        return true;
    }

    private int location(int number) {
        for (int i = 0; i < numberOfItems; i++) {
            if (number == queue[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int kohta = location(luku);
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
