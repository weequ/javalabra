package kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import logiikka.ShakkiPeli;
import logiikka.lauta.Ruutu;
import logiikka.nappulat.Nappula;

/**
 * Tämän luokan tehtävänä on piirtää shakkipelin tilannetta ja siirtomahdollisuuksia.
 * @author Antti
 */
public class LautaKangas extends JComponent {
    /**
     * Yksittäisen ruudun leveys ja korkeus
     */
    private final static int RUUDUN_KOKO = 55;
    
    /**
     * ShakkiPeli jota pelataan.
     */
    private ShakkiPeli shakkiPeli;
    
    /**
     * Nappula joka on valittu hiirellä. Null jos nappulaa ei ole valittu.
     */
    private Nappula valittu;
    
    /**
     * Luo uuden LautaKangas olion 
     * @param shakkiPeli ShakkiPeli olio jota piirretään.
     */
    public LautaKangas(ShakkiPeli shakkiPeli) {
        this();
        setShakkiPeli(shakkiPeli);
    }
    
    /**
     * Luo uuden lautakangas olion ja alustaa sen.
     */
    public LautaKangas() {
        setPreferredSize(new Dimension(RUUDUN_KOKO*8, RUUDUN_KOKO*8));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (shakkiPeli.getRuudukko() == null) return;
                int x = e.getX()/RUUDUN_KOKO;
                int y = e.getY()/RUUDUN_KOKO;
                hallitseKlikkaus(x, y);
            }
        });
    }
    
    /**
     * Määrittelee mitä tapahtuu kun ruudukon koordinaattia (x, y) klikataan.
     * @param x Mitä saraketta klikattiin
     * @param y Mitä riviä klikattiin
     */
    private void hallitseKlikkaus(int x, int y) {
        Ruutu klikattuRuutu = shakkiPeli.getRuudukko().getRuutu(x, y);
        if (valittu != null) {
            if (valittu.getSiirtoMahdollisuudet().contains(klikattuRuutu) && 
                    valittu.getJoukkue().equals(shakkiPeli.getVuoro())) {//Klikattu ruutu on siirtomahdollisuuksien joukossa
                valittu.siirrä(klikattuRuutu);
                shakkiPeli.vaihdaVuoroa();
                setValittu(null);
                repaint();
                return;
            }
        }
        setValittu(klikattuRuutu.getNappula());
        repaint();
    }
    
    public void setShakkiPeli(ShakkiPeli shakkiPeli) {
        this.shakkiPeli = shakkiPeli;
    }
    
    /**
     * Piirtää shakkilaudan mutta ei nappuloita.
     * @param g Graphics olio johon piirretään.
     */
    private void piirraTausta(Graphics g) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (x%2 == y%2) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x*RUUDUN_KOKO, y*RUUDUN_KOKO, RUUDUN_KOKO, RUUDUN_KOKO);
            }
        }
    }
    
    /**
     * Tummentaa valitun nappulan siirtomahdollisuudet.
     * @param g Graphics olio johon piirretään.
     */
    private void piirraSiirtoMahdollisuudet(Graphics g) {
        if (valittu == null) return;
        Color c = new Color(0f, 1f, 0f, 0.3f);
        g.setColor(c);
        for (Ruutu r: valittu.getSiirtoMahdollisuudet()) {
            if (r == null) continue;
            g.fillRect(r.getX()*RUUDUN_KOKO, r.getY()*RUUDUN_KOKO, RUUDUN_KOKO, RUUDUN_KOKO);
        }
    }
    
    /**
     * Tummentaa valitun nappulan ruudun punaisella.
     * @param g Graphics olio johon piirretään.
     */
    private void piirraValittu(Graphics g) {
        if (valittu == null) return;
        Color c = new Color(1f, 0f, 0f, 0.3f);
        g.setColor(c);
        g.fillRect(valittu.getRuutu().getX()*RUUDUN_KOKO, valittu.getRuutu().getY()*RUUDUN_KOKO, RUUDUN_KOKO, RUUDUN_KOKO);
    }
    
    /**
     * Asettaa nappulan valituksi jos on sen joukkueen vuoro.
     * @param valittu Nappula joka asetetaan valituksi.
     * @return 
     */
    public boolean setValittu(Nappula valittu) {
        if (valittu != null && !valittu.getJoukkue().equals(shakkiPeli.getVuoro())) {
            return false;
        }
        this.valittu = valittu;
        return true;
    }
    
    /**
     * Piirtää ruudukossa olevat shakkinappulat
     * @param g Graphics olio johon piirretään.
     */
    private void piirraNappulat(Graphics g) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                try {
                    BufferedImage kuva = Kuvat.getKuva(shakkiPeli.getRuudukko().getRuutu(x, y).getNappula());
                    g.drawImage(kuva, x*RUUDUN_KOKO, y*RUUDUN_KOKO, this);
                } catch (Exception e) {
                    //Näitä virheitä tulee kun ruudussa ei ole nappulaa.
                }
            }
        }
    }
    
    /**
     * Piirtää shakkilaudan ja nappulat sekä värittää valitun ruudun ja siirtomahdollisuudet.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        piirraTausta(g);
        if (shakkiPeli.getRuudukko() == null) return;
        piirraValittu(g);
        piirraSiirtoMahdollisuudet(g);
        piirraNappulat(g);
    }
}
