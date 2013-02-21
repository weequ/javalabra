/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import logiikka.joukkueet.Joukkue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiedostonKasittely.PeliTiedostoMuuntaja;
import tiedostonKasittely.ResurssienLukija;

/**
 *
 * @author Antti
 */
public class ShakkiPeliTest {
    private ShakkiPeli shakkiPeli;
    
    public ShakkiPeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        shakkiPeli = PeliTiedostoMuuntaja.tekstiShakkiPeliksi(ResurssienLukija.lueTiedostoTekstiksi("/resurssit/aloitusLauta.txt"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRuudukko() {
    }

    @Test
    public void testGetVuoro() {
        assertEquals(shakkiPeli.getVuoro(), Joukkue.VALKOINEN);
    }

    @Test
    public void testSetVuoro() {
        shakkiPeli.setVuoro(Joukkue.MUSTA);
        assertEquals(shakkiPeli.getVuoro(), Joukkue.MUSTA);
    }

    @Test
    public void testVaihdaVuoroa() {
        shakkiPeli.vaihdaVuoroa();
        assertEquals(shakkiPeli.getVuoro(), Joukkue.MUSTA);
    }
}
