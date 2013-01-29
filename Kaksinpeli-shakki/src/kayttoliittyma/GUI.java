/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import logiikka.ShakkiPeli;
import logiikka.lauta.Ruudukko;
import tiedostonLuku.Lukija;

/**
 *
 * @author Antti
 */
public class GUI extends JFrame {

    private LautaKangas lautaKangas;
    private ShakkiPeli shakkiPeli;
    
    public GUI(ShakkiPeli shakkiPeli) {
        this.shakkiPeli = shakkiPeli;
        setTitle("Kaksinpeli-shakki");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.lautaKangas = new LautaKangas(shakkiPeli);
        add(lautaKangas);
        setVisible(true);
        pack();
    }
    
    public ShakkiPeli getShakkiPeli() {
        return shakkiPeli;
    }
    
    public void setShakkiPeli(ShakkiPeli shakkiPeli) {
        lautaKangas.setShakkiPeli(shakkiPeli);
    }
    
}
