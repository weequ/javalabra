/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonKasittely;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * KESKEN
 * @author Antti
 */
public class Kirjoittaja {
    File tiedosto;
    
    public Kirjoittaja(String tiedostoPolku) {
        tiedosto = new File(tiedostoPolku);
    }
    
    public void kirjoita(String teksti) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }
}
