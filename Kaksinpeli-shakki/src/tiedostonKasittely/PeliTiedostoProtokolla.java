/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonKasittely;

import java.io.File;
import java.io.FileNotFoundException;
import logiikka.ShakkiPeli;
import logiikka.lauta.Ruudukko;

/**
 * KESKEN
 * @author Antti
 */
public class PeliTiedostoProtokolla {
    
    public ShakkiPeli tekstiShakkiPeliksi(String teksti) {
        return null;
    }
    
    public String shakkiPeliTekstiksi(ShakkiPeli shakkiPeli) {
        return null;
    }
    
    public static ShakkiPeli avaaPeli(File tiedosto) {
        Lukija lukija;
        try {
            lukija = new Lukija(null);
        } catch (FileNotFoundException ex) {
            return null;
        }
        Ruudukko ruudukko;
        try {
            ruudukko = new Ruudukko(lukija.getText());
        } catch (Exception ex) {
            return null;
        }
        //tulos.setVuoro(Joukkue.VALKOINEN);
        return null;
    }
    
    public static boolean tallennaPeli(ShakkiPeli shakkiPeli, File tiedosto) {
        return false;
    }
}
