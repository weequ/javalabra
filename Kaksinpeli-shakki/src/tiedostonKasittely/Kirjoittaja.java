/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonKasittely;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Kirjoittaa merkkijonon tiedostoon.
 * @author Antti
 */
public class Kirjoittaja {
    File tiedosto;
    
    public Kirjoittaja(String tiedostoPolku) {
        tiedosto = new File(tiedostoPolku);
    }
    
    /**
     * Kirjoittaa merkkijonon tiedostoon niin että vanha teksti pyyhkiytyy pois.
     * @param teksti Merkkijono joka kirjoitetaan tiedostoon.
     * @throws IOException 
     */
    public void kirjoita(String teksti) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }
}
