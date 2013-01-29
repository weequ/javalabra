/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.lauta;

import logiikka.joukkueet.Joukkue;
import logiikka.nappulat.Kuningas;
import logiikka.nappulat.Lahetti;
import logiikka.nappulat.Nappula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti
 */
public class RuutuTest {
    
    private Ruutu ruutu;
    private Ruudukko ruudukko;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        String line = System.lineSeparator();
        ruudukko = new Ruudukko(
            "mt,mr,ml,md,mk,ml,mr,mt"+line+
            "ms,ms,ms,ms,ms,ms,ms,ms"+line+
            "aa,aa,aa,aa,aa,aa,aa,aa"+line+
            "aa,aa,aa,aa,aa,aa,aa,aa"+line+
            "aa,aa,aa,aa,aa,aa,aa,aa"+line+
            "aa,aa,aa,aa,aa,aa,aa,aa"+line+
            "vs,vs,vs,vs,vs,vs,vs,vs"+line+
            "vt,vr,vl,vd,vk,vl,vr,vt");
        ruutu = new Ruutu(2, 5, ruudukko);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRuudukko() {
        assertEquals(ruutu.getRuudukko(), ruudukko);
    }

    @Test
    public void testGetNappula() {
        assertEquals(ruutu.getNappula(), null);
    }

    @Test
    public void testGetX() {
        assertEquals(ruutu.getX(), 2);
    }

    @Test
    public void testGetY() {
        assertEquals(ruutu.getY(), 5);
    }

    @Test
    public void testSetNappula() {
        Nappula k = new Lahetti(Joukkue.MUSTA);
        ruutu.setNappula(k);
        assertEquals(ruutu.getNappula(), k);
    }
}
