/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonKasittely;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logiikka.ShakkiPeli;
import logiikka.joukkueet.Joukkue;
import logiikka.lauta.Ruudukko;

/**
 * KESKEN
 * @author Antti
 */
public class PeliTiedostoMuuntaja {
    
    private static String[] trimArr(String[] arr) {
        String[] tulos = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tulos[i] = arr[i].trim();
        }
        return tulos;
    }
    
    
    private static ShakkiPeli tekstiShakkiPeliksi(String teksti) throws Exception {
        String rivinVaihto = System.getProperty("line.separator");
        int ensimmainenRivinVaihto = teksti.indexOf(rivinVaihto);
        String ensimmainenRivi = teksti.substring(0, ensimmainenRivinVaihto);
        System.out.println(ensimmainenRivi);
        String[] parametrit = trimArr(ensimmainenRivi.split(","));
        String ruudukkoString = teksti.substring(ensimmainenRivinVaihto+rivinVaihto.length());
        Ruudukko ruudukko = new Ruudukko(ruudukkoString);
        return new ShakkiPeli(ruudukko, Joukkue.getJoukkue(parametrit[0]));
    }
    
    private static String shakkiPeliTekstiksi(ShakkiPeli shakkiPeli) {
        return shakkiPeli.toString();
    }
    
    public static ShakkiPeli avaaPeli(String tiedostoPolku) {
        Lukija lukija;
        try {
            lukija = new Lukija(tiedostoPolku);
            return tekstiShakkiPeliksi(lukija.getText());
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public static boolean tallennaPeli(ShakkiPeli shakkiPeli, String tiedostoPolku) {
        Kirjoittaja kirjoittaja = new Kirjoittaja(tiedostoPolku);
        try {
            kirjoittaja.kirjoita(shakkiPeliTekstiksi(shakkiPeli));
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
