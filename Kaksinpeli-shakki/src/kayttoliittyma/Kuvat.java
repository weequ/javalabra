/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Kuvien hallintaan tarkoitettu luokka
 * @author Antti
 */
public class Kuvat {
    
    public static BufferedImage MUSTA_KUNINGAS;
    public static BufferedImage MUSTA_KUNINGATAR;
    public static BufferedImage MUSTA_TORNI;
    public static BufferedImage MUSTA_LAHETTI;
    public static BufferedImage MUSTA_RATSU;
    public static BufferedImage MUSTA_SOTILAS;
    
    public static BufferedImage VALKOINEN_KUNINGAS;
    public static BufferedImage VALKOINEN_KUNINGATAR;
    public static BufferedImage VALKOINEN_TORNI;
    public static BufferedImage VALKOINEN_LAHETTI;
    public static BufferedImage VALKOINEN_RATSU;
    public static BufferedImage VALKOINEN_SOTILAS;
 
    
    private Kuvat() {
    }
    
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
