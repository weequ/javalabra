/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.image.BufferedImage;
import logiikka.joukkueet.Joukkue;
import logiikka.nappulat.Nappula;
import tiedostonKasittely.ResurssienLukija;

/**
 * Kuvien hallintaan tarkoitettu luokka
 * @author Antti
 */
public class Kuvat {
    
    private static BufferedImage MUSTA_KUNINGAS;
    private static BufferedImage MUSTA_KUNINGATAR;
    private static BufferedImage MUSTA_TORNI;
    private static BufferedImage MUSTA_LAHETTI;
    private static BufferedImage MUSTA_RATSU;
    private static BufferedImage MUSTA_SOTILAS;
    
    private static BufferedImage VALKOINEN_KUNINGAS;
    private static BufferedImage VALKOINEN_KUNINGATAR;
    private static BufferedImage VALKOINEN_TORNI;
    private static BufferedImage VALKOINEN_LAHETTI;
    private static BufferedImage VALKOINEN_RATSU;
    private static BufferedImage VALKOINEN_SOTILAS;
 
    
    private Kuvat() {
    }
    
    /**
     * Palauttaa kuvan joka kuvaa parametria nappula.
     * @param nappula
     * @return Parametrina annettua nappulaa vastaava kuva.
     */
    public static BufferedImage getKuva(Nappula nappula) {
        if (nappula.getJoukkue().equals(Joukkue.MUSTA)) {
            if (nappula instanceof logiikka.nappulat.Kuningas) {
                return MUSTA_KUNINGAS;
            } else if (nappula instanceof logiikka.nappulat.Kuningatar) {
                return MUSTA_KUNINGATAR;
            } else if (nappula instanceof logiikka.nappulat.Torni) {
                return MUSTA_TORNI;
            } else if (nappula instanceof logiikka.nappulat.Lahetti) {
                return MUSTA_LAHETTI;
            } else if (nappula instanceof logiikka.nappulat.Ratsu) {
                return MUSTA_RATSU;
            } else if (nappula instanceof logiikka.nappulat.Sotilas) {
                return MUSTA_SOTILAS;
            }
        } else if (nappula.getJoukkue().equals(Joukkue.VALKOINEN)) {
            if (nappula instanceof logiikka.nappulat.Kuningas) {
                return VALKOINEN_KUNINGAS;
            } else if (nappula instanceof logiikka.nappulat.Kuningatar) {
                return VALKOINEN_KUNINGATAR;
            } else if (nappula instanceof logiikka.nappulat.Torni) {
                return VALKOINEN_TORNI;
            } else if (nappula instanceof logiikka.nappulat.Lahetti) {
                return VALKOINEN_LAHETTI;
            } else if (nappula instanceof logiikka.nappulat.Ratsu) {
                return VALKOINEN_RATSU;
            } else if (nappula instanceof logiikka.nappulat.Sotilas) {
                return VALKOINEN_SOTILAS;
            }
        }
        return null;
    }
    
    /**
     * Lataa kuvat ohjelman tiedostosta välimuistiin.
     */
    public static void lataaKuvat() {
        MUSTA_KUNINGAS = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Kuningas.png");
        MUSTA_KUNINGATAR = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Kuningatar.png");
        MUSTA_TORNI = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Torni.png");
        MUSTA_LAHETTI = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Lahetti.png");
        MUSTA_RATSU = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Ratsu.png");
        MUSTA_SOTILAS = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/mustat/Sotilas.png");
        
        VALKOINEN_KUNINGAS = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Kuningas.png");
        VALKOINEN_KUNINGATAR = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Kuningatar.png");
        VALKOINEN_TORNI = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Torni.png");
        VALKOINEN_LAHETTI = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Lahetti.png");
        VALKOINEN_RATSU = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Ratsu.png");
        VALKOINEN_SOTILAS = ResurssienLukija.lueTiedostoKuvaksi("/resurssit/kuvat/nappulat/valkoiset/Sotilas.png");
    }
    
}
