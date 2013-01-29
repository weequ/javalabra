/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import logiikka.ShakkiPeli;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;
import logiikka.nappulat.Nappula;

/**
 *
 * @author Antti
 */
public class LautaKangas extends JComponent {
    private final static int RUUDUN_KOKO = 55;
    private ShakkiPeli shakkiPeli;
    private Nappula valittu;
//    private Ruudukko ruudukko;
//    private Nappula valittu;
    
    public LautaKangas(ShakkiPeli shakkiPeli) {
        this();
        setShakkiPeli(shakkiPeli);
    }
    
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
     * 
     * @param x Mitä saraketta klikattiin
     * @param y Mitä riviä klikattiin
     */
    private void hallitseKlikkaus(int x, int y) {
        if (valittu != null) {
            Ruudukko ruudukko = shakkiPeli.getRuudukko();
            Ruutu klikattuRuutu = ruudukko.getRuutu(x, y);
            if (valittu.getSiirtoMahdollisuudet().contains(klikattuRuutu)) {//Klikattu ruutu on siirtomahdollisuuksien joukossa
                klikattuRuutu.setNappula(valittu);
                valittu.getRuutu().setNappula(null);
                valittu.setRuutu(klikattuRuutu);
                valittu = null;
            } else valittu = shakkiPeli.getRuudukko().getRuutu(x, y).getNappula();
        } else valittu = shakkiPeli.getRuudukko().getRuutu(x, y).getNappula();
        repaint();
    }
    
    public void setShakkiPeli(ShakkiPeli shakkiPeli) {
        this.shakkiPeli = shakkiPeli;
    }
    
    public void piirraTausta(Graphics g) {
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
    
    public void piirraSiirtoMahdollisuudet(Graphics g) {
        if (valittu == null) return;
        Color c = new Color(0f, 1f, 0f, 0.3f);
        g.setColor(c);
        valittu.laskeSiirtoMahdollisuudet(true);
        for (Ruutu r: valittu.getSiirtoMahdollisuudet()) {
            if (r == null) continue;
            System.out.println(r.getX()+", "+r.getY());
            g.fillRect(r.getX()*RUUDUN_KOKO, r.getY()*RUUDUN_KOKO, RUUDUN_KOKO, RUUDUN_KOKO);
        }
    }
    
    public void piirraValittu(Graphics g) {
        if (valittu == null) return;
        Color c = new Color(1f, 0f, 0f, 0.3f);
        g.setColor(c);
        g.fillRect(valittu.getRuutu().getX()*RUUDUN_KOKO, valittu.getRuutu().getY()*RUUDUN_KOKO, RUUDUN_KOKO, RUUDUN_KOKO);
    }
    
    @Override
    public void paint(Graphics g) {
        piirraTausta(g);
        if (shakkiPeli.getRuudukko() == null) return;
        piirraValittu(g);
        piirraSiirtoMahdollisuudet(g);
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                try {
                    g.drawImage(shakkiPeli.getRuudukko().getRuutu(x, y).getNappula().getKuva(), x*RUUDUN_KOKO, y*RUUDUN_KOKO, this);
                } catch (Exception e) {
                    
                }
            }
        }
    }
}