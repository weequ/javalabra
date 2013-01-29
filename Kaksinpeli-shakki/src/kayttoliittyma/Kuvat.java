/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;

/**
 *
 * @author Antti
 */
public class Kuvat {
    
    public static final BufferedImage MUSTA_KUNINGAS = lataaKuva("kuvat\\nappulat\\mustat\\Kuningas.png");
    public static final BufferedImage MUSTA_KUNINGATAR = lataaKuva("kuvat\\nappulat\\mustat\\Kuningatar.png");
    public static final BufferedImage MUSTA_TORNI = lataaKuva("kuvat\\nappulat\\mustat\\Torni.png");
    public static final BufferedImage MUSTA_LAHETTI = lataaKuva("kuvat\\nappulat\\mustat\\Lahetti.png");
    public static final BufferedImage MUSTA_RATSU = lataaKuva("kuvat\\nappulat\\mustat\\Ratsu.png");
    public static final BufferedImage MUSTA_SOTILAS = lataaKuva("kuvat\\nappulat\\mustat\\Sotilas.png");
    
    public static final BufferedImage VALKOINEN_KUNINGAS = lataaKuva("kuvat\\nappulat\\valkoiset\\Kuningas.png");
    public static final BufferedImage VALKOINEN_KUNINGATAR = lataaKuva("kuvat\\nappulat\\valkoiset\\Kuningatar.png");
    public static final BufferedImage VALKOINEN_TORNI = lataaKuva("kuvat\\nappulat\\valkoiset\\Torni.png");
    public static final BufferedImage VALKOINEN_LAHETTI = lataaKuva("kuvat\\nappulat\\valkoiset\\Lahetti.png");
    public static final BufferedImage VALKOINEN_RATSU = lataaKuva("kuvat\\nappulat\\valkoiset\\Ratsu.png");
    public static final BufferedImage VALKOINEN_SOTILAS = lataaKuva("kuvat\\nappulat\\valkoiset\\Sotilas.png");
 
    private static BufferedImage lataaKuva(String polku) {
        try {
            return ImageIO.read(new File(polku));
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    
}
