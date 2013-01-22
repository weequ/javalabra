/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

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
        Nappula mustaSotilas = new Sotilas(Vari.MUSTA);
        Nappula valkoinenSotilas = new Sotilas(Vari.VALKOINEN);
        
        assertEquals(mustaSotilas.getTallennusMerkki(), 's');
        assertEquals(mustaSotilas.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenSotilas.getTallennusMerkki(), 's');
        assertEquals(valkoinenSotilas.getVari(), Vari.VALKOINEN);
    }
    
    @Test
    public void testaaLahetinLuonti() {
        Nappula mustaLahetti = new Lahetti(Vari.MUSTA);
        Nappula valkoinenLahetti = new Lahetti(Vari.VALKOINEN);
        
        assertEquals(mustaLahetti.getTallennusMerkki(), 'l');
        assertEquals(mustaLahetti.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenLahetti.getTallennusMerkki(), 'l');
        assertEquals(valkoinenLahetti.getVari(), Vari.VALKOINEN);
    }
    
    @Test
    public void testaaRatsunLuonti() {
        Nappula mustaRatsu = new Ratsu(Vari.MUSTA);
        Nappula valkoinenRatsu = new Ratsu(Vari.VALKOINEN);
        
        assertEquals(mustaRatsu.getTallennusMerkki(), 'r');
        assertEquals(mustaRatsu.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenRatsu.getTallennusMerkki(), 'r');
        assertEquals(valkoinenRatsu.getVari(), Vari.VALKOINEN);
    }
    
    @Test
    public void testaaTorninLuonti() {
        Nappula mustaTorni = new Torni(Vari.MUSTA);
        Nappula valkoinenTorni = new Torni(Vari.VALKOINEN);
        
        assertEquals(mustaTorni.getTallennusMerkki(), 't');
        assertEquals(mustaTorni.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenTorni.getTallennusMerkki(), 't');
        assertEquals(valkoinenTorni.getVari(), Vari.VALKOINEN);
    }
    
    @Test
    public void testaaKuningattarenLuonti() {
        Nappula mustaKuningatar = new Kuningatar(Vari.MUSTA);
        Nappula valkoinenKuningatar = new Kuningatar(Vari.VALKOINEN);
        
        assertEquals(mustaKuningatar.getTallennusMerkki(), 'd');
        assertEquals(mustaKuningatar.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenKuningatar.getTallennusMerkki(), 'd');
        assertEquals(valkoinenKuningatar.getVari(), Vari.VALKOINEN);
    }
    
    @Test
    public void testaaKuninkaanLuonti() {
        Nappula mustaKuningas = new Kuningas(Vari.MUSTA);
        Nappula valkoinenKuningas = new Kuningas(Vari.VALKOINEN);
        
        assertEquals(mustaKuningas.getTallennusMerkki(), 'k');
        assertEquals(mustaKuningas.getVari(), Vari.MUSTA);
        
        assertEquals(valkoinenKuningas.getTallennusMerkki(), 'k');
        assertEquals(valkoinenKuningas.getVari(), Vari.VALKOINEN);
    }
   
}
