/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import logiikka.joukkueet.Joukkue;
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
public class NappulaTesti {
    
    public NappulaTesti() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {
//     }
    
    @Test
    public void testaaSotilaanLuonti() {
        Nappula mustaSotilas = new Sotilas(Joukkue.MUSTA);
        Nappula valkoinenSotilas = new Sotilas(Joukkue.VALKOINEN);
        
        assertEquals(mustaSotilas.getTallennusMerkki(), 's');
        assertEquals(mustaSotilas.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenSotilas.getTallennusMerkki(), 's');
        assertEquals(valkoinenSotilas.getJoukkue(), Joukkue.VALKOINEN);
    }
    
    @Test
    public void testaaLahetinLuonti() {
        Nappula mustaLahetti = new Lahetti(Joukkue.MUSTA);
        Nappula valkoinenLahetti = new Lahetti(Joukkue.VALKOINEN);
        
        assertEquals(mustaLahetti.getTallennusMerkki(), 'l');
        assertEquals(mustaLahetti.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenLahetti.getTallennusMerkki(), 'l');
        assertEquals(valkoinenLahetti.getJoukkue(), Joukkue.VALKOINEN);
    }
    
    @Test
    public void testaaRatsunLuonti() {
        Nappula mustaRatsu = new Ratsu(Joukkue.MUSTA);
        Nappula valkoinenRatsu = new Ratsu(Joukkue.VALKOINEN);
        
        assertEquals(mustaRatsu.getTallennusMerkki(), 'r');
        assertEquals(mustaRatsu.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenRatsu.getTallennusMerkki(), 'r');
        assertEquals(valkoinenRatsu.getJoukkue(), Joukkue.VALKOINEN);
    }
    
    @Test
    public void testaaTorninLuonti() {
        Nappula mustaTorni = new Torni(Joukkue.MUSTA);
        Nappula valkoinenTorni = new Torni(Joukkue.VALKOINEN);
        
        assertEquals(mustaTorni.getTallennusMerkki(), 't');
        assertEquals(mustaTorni.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenTorni.getTallennusMerkki(), 't');
        assertEquals(valkoinenTorni.getJoukkue(), Joukkue.VALKOINEN);
    }
    
    @Test
    public void testaaKuningattarenLuonti() {
        Nappula mustaKuningatar = new Kuningatar(Joukkue.MUSTA);
        Nappula valkoinenKuningatar = new Kuningatar(Joukkue.VALKOINEN);
        
        assertEquals(mustaKuningatar.getTallennusMerkki(), 'd');
        assertEquals(mustaKuningatar.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenKuningatar.getTallennusMerkki(), 'd');
        assertEquals(valkoinenKuningatar.getJoukkue(), Joukkue.VALKOINEN);
    }
    
    @Test
    public void testaaKuninkaanLuonti() {
        Nappula mustaKuningas = new Kuningas(Joukkue.MUSTA);
        Nappula valkoinenKuningas = new Kuningas(Joukkue.VALKOINEN);
        
        assertEquals(mustaKuningas.getTallennusMerkki(), 'k');
        assertEquals(mustaKuningas.getJoukkue(), Joukkue.MUSTA);
        
        assertEquals(valkoinenKuningas.getTallennusMerkki(), 'k');
        assertEquals(valkoinenKuningas.getJoukkue(), Joukkue.VALKOINEN);
    }
   
}
