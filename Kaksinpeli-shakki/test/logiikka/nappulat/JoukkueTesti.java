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
public class JoukkueTesti {
    
    public JoukkueTesti() {
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
    // @Test
    // public void hello() {}
    @Test
    public void testaaMusta() {
        assertEquals(Joukkue.MUSTA.getTallennusMerkki(), 'm');
    }
    
    @Test
    public void testaaValkoinen() {
        assertEquals(Joukkue.VALKOINEN.getTallennusMerkki(), 'v');
    }
}
