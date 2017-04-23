package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {

    @Test
    public void yhdiste() {
        IntJoukko eka = teeJoukko(1, 2);
        IntJoukko toka = teeJoukko(3, 4);

        IntJoukko tulos = IntJoukko.yhdiste(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);

        int[] odotettu = {1, 2, 3, 4};

        assertArrayEquals(odotettu, vastauksenLuvut);
    }

    @Test
    public void leikkaus() {
        IntJoukko eka = teeJoukko(1, 2, 3, 4);
        IntJoukko toka = teeJoukko(3, 4, 8, 15);

        IntJoukko tulos = IntJoukko.leikkaus(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);

        int[] odotettu = {3, 4};

        assertArrayEquals(odotettu, vastauksenLuvut);
    }
    
    @Test
    public void erotus() {
        IntJoukko eka = teeJoukko(1, 2, 3, 4, 6);
        IntJoukko toka = teeJoukko(3, 4, 8, 15);

        IntJoukko tulos = IntJoukko.erotus(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);

        int[] odotettu = {1, 2, 6};

        assertArrayEquals(odotettu, vastauksenLuvut);
    }

    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        for (int luku : luvut) {
            joukko.lisaa(luku);
        }
        return joukko;
    }
}
