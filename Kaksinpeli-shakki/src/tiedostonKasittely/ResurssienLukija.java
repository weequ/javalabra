/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonKasittely;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Käyetään resurssien lukemiseen samasta jar tiedostosta.
 * @author Antti
 */
public class ResurssienLukija {
    
    /**
     * Lukee jar tiedostossa olevan tiedoston tekstiksi.
     * Toimii myös ilman jar tiedostoa, mutta tiedoston on oltava projektikansiossa tai sen alakansioissa.
     * @param suhteellinenPolku esim "resurssit/aloitusLauta.txt"
     * @return Tiedosto luettuna merkkijonoksi.
     */
    public static String lueTiedostoTekstiksi(String suhteellinenPolku) {
        InputStream iS = getResourceAsStream(suhteellinenPolku);
        if (iS == null) return null;
        Scanner lukija = new Scanner(iS);
        String tulos;
        if (lukija.hasNextLine()) {
            tulos = "";
        } else {
            tulos = null;
        }
        if (lukija.hasNextLine()) {
            while(true) {
                tulos += lukija.nextLine();
                if (!lukija.hasNextLine()) break;
                tulos += System.getProperty("line.separator");
            }
        }
        try {
            iS.close();
        } catch (IOException ex) {
            Logger.getLogger(Lukija.class.getName()).log(Level.SEVERE, null, ex);
        }
        lukija.close();
        return tulos;
    }
    
    /**
     * Lukee jar tiedostossa olevan tiedoston kuvaksi.
     * Toimii myös ilman jar tiedostoa, mutta tiedoston on oltava projektikansiossa tai sen alakansioissa.
     * @param suhteellinenPolku esim "/resurssit/kuvat/nappulat/valkoiset/Torni.png"
     * @return Tiedosto luettuna kuvaksi. Null jos tiedosto ei ole kuvatiedosto.
     */
    public static BufferedImage lueTiedostoKuvaksi(String suhteellinenPolku) {
        InputStream stream = getResourceAsStream(suhteellinenPolku);
        try {//MUSTA_KUNINGAS = lataaKuva(Kuvat.class.getResource("/kuvat/nappulat/mustat/Kuningas.png").toURI());
            return ImageIO.read(stream);
        } catch (IOException e) {
            System.out.println(e.getCause());
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(ResurssienLukija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * Hakee projektikansiossa tai sen alikansioissa olevan tiedoston ja palauttaa sen InputStreamin.
     * @param shuteellinenPolku Tiedoston polku. Oltava projektikansiossa tai sen alakansioissa.
     * @return Löydetyn tiedoston inputstream. Null jos tiedostoa ei löydy.
     */
    private static InputStream getResourceAsStream(String shuteellinenPolku) {
        return ResurssienLukija.class.getResourceAsStream(shuteellinenPolku);
    }
}
