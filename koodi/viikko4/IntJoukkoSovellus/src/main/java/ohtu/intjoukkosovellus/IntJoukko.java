package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int CAPACITY = 5, 
            DEFAULTINCREMENT = 5;
    private int incrementSize;    
    private int[] queue;
    private int numberOfItems;

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

    public boolean lisaa(int numberToAdd) {
        if (!kuuluu(numberToAdd)) {
            queue[numberOfItems] = numberToAdd;
            numberOfItems++;
            if (numberOfItems % queue.length == 0) {
                int[] oldArray = queue;
                queue = new int[numberOfItems + incrementSize];
                kopioiTaulukko(oldArray, queue);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int number) {
        if (location(number) == -1) {
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

    public boolean poista(int numberToRemove) {
        int locationOfItemToRemove = location(numberToRemove);
        if (locationOfItemToRemove != -1) {
            for (int j = locationOfItemToRemove; j < numberOfItems - 1; j++) {
                queue[j] = queue[j + 1];
            }
            numberOfItems--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] oldArray, int[] newArray) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

    }

    public int mahtavuus() {
        return numberOfItems;
    }

    @Override
    public String toString() {
        String arrayAsString = "{";
        for (int i = 0; i < numberOfItems - 1; i++) {
            arrayAsString += queue[i];
            arrayAsString += ", ";
        }
        if (numberOfItems > 0) {
            arrayAsString += queue[numberOfItems - 1];
        }
        arrayAsString += "}";
        return arrayAsString;
    }

    public int[] toIntArray() {
        int[] array = new int[numberOfItems];
        for (int i = 0; i < array.length; i++) {
            array[i] = queue[i];
        }
        return array;
    }

}
