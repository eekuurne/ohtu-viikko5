package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5;
    public final static int OLETUSKASVATUSKOKO = 5;

    private int kasvatuskoko; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;   // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm; // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUSKOKO);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUSKOKO);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            kapasiteetti = OLETUSKAPASITEETTI;
        }
        if (kasvatuskoko < 0) {
            kasvatuskoko = OLETUSKASVATUSKOKO;
        }
        alusta(kapasiteetti, kasvatuskoko);
    }

    private void alusta(int kapasiteetti, int kasvatuskoko) {
        this.lukujono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        kasvataTaulukkoaTarvittaessa();
        lukujono[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
    }

    private void kasvataTaulukkoaTarvittaessa() {
        if (alkioidenLkm < lukujono.length) {
            return;
        }
        int[] uusiJono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(lukujono, uusiJono);
        lukujono = uusiJono;
    }

    public boolean kuuluu(int luku) {
        return kuuluu(luku, toIntArray());
    }

    public static boolean kuuluu(int luku, int[] jono) {
        for (int i = 0; i < jono.length; i++) {
            if (luku == jono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                poistaIndeksista(i);
                return true;
            }
        }
        return false;
    }

    private void poistaIndeksista(int i) {
        for (int j = i; j < alkioidenLkm - 1; j++) {
            lukujono[j] = lukujono[j + 1];
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            return "{" + alkioLista() + "}";
        }
    }

    private String alkioLista() {
        String tuotos = "";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += lukujono[i];
            tuotos += ", ";
        }
        tuotos += lukujono[alkioidenLkm - 1];
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            yhdisteJoukko.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            yhdisteJoukko.lisaa(b.toIntArray()[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (kuuluu(a.toIntArray()[i], b.toIntArray())) {
                leikkausJoukko.lisaa(a.toIntArray()[i]);
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            erotusJoukko.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            erotusJoukko.poista(b.toIntArray()[i]);
        }
        return erotusJoukko;
    }
}
