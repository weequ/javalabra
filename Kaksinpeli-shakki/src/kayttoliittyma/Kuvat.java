/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import logiikka.joukkueet.Joukkue;
import logiikka.nappulat.Nappula;

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
        MUSTA_KUNINGAS = lataaKuva("kuvat/nappulat/mustat/Kuningas.png");
        MUSTA_KUNINGATAR = lataaKuva("kuvat/nappulat/mustat/Kuningatar.png");
        MUSTA_TORNI = lataaKuva("kuvat/nappulat/mustat/Torni.png");
        MUSTA_LAHETTI = lataaKuva("kuvat/nappulat/mustat/Lahetti.png");
        MUSTA_RATSU = lataaKuva("kuvat/nappulat/mustat/Ratsu.png");
        MUSTA_SOTILAS = lataaKuva("kuvat/nappulat/mustat/Sotilas.png");
        
        VALKOINEN_KUNINGAS = lataaKuva("kuvat/nappulat/valkoiset/Kuningas.png");
        VALKOINEN_KUNINGATAR = lataaKuva("kuvat/nappulat/valkoiset/Kuningatar.png");
        VALKOINEN_TORNI = lataaKuva("kuvat/nappulat/valkoiset/Torni.png");
        VALKOINEN_LAHETTI = lataaKuva("kuvat/nappulat/valkoiset/Lahetti.png");
        VALKOINEN_RATSU = lataaKuva("kuvat/nappulat/valkoiset/Ratsu.png");
        VALKOINEN_SOTILAS = lataaKuva("kuvat/nappulat/valkoiset/Sotilas.png");
    }
    
    /**
     * Siirtää kuvan kovalevyltä välimuistiin.
     * @param polku Tiedostopolku josta kuvaa etsitään.
     * @return Kuva. Null jos kuvan avaaminen epäonnistuu.
     */
    private static BufferedImage lataaKuva(String polku) {
        try {
            File file = new File(polku);
            return ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(e.getCause());
            return null;
        }
    }
    
}
