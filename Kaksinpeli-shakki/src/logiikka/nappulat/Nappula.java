/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka.nappulat;

import java.awt.Point;
import logiikka.lauta.Ruudukko;
import logiikka.lauta.Ruutu;

/**
 *
 * @author Antti
 */
public abstract class Nappula {
    
    private Ruutu ruutu;
    private Vari vari;
    
    private Point[][] kaveleTaiSyo;
    
    public Ruutu[] laskeSiirtoMahdollisuudet() {
        return null;
    }
    public abstract char getTallennusMerkki();
    
    public Nappula(Vari vari) {
        this.vari = vari;
    }
    
    
    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    
    public Vari getVari() {
        return vari;
    }
    
    public static class Sotilas extends Nappula {//Ei koodattu ohilyontimahdollisuutta
        private final static char TALLENNUSMERKKI = 's';
        private final Point[] kavele = null;
        private final Point[] syo = null;
        
        public Sotilas(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            Ruutu ruutu = getRuutu();
            Ruudukko ruudukko = ruutu.getRuudukko();
            Vari vari = getVari();
            if (vari.equals(Vari.MUSTA)) {
                ruudukko.getRuutu(ruutu.getX(), ruutu.getY());
            } else if (vari.equals(Vari.VALKOINEN)) {
                ruudukko.getRuutu(ruutu.getX(), ruutu.getY());
            }
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    public static class Lahetti extends Nappula {
        private final static char TALLENNUSMERKKI = 'l';
        private final static Point[] kaveleTaiSyo = 
        {new Point(1, 1), new Point(2, 2), new Point(3, 3), 
         new Point(4, 4), new Point(5, 5), new Point(6, 6), new Point(7, 7)};
        public Lahetti(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    public static class Ratsu extends Nappula {
        private final static char TALLENNUSMERKKI = 'r';
        public Ratsu(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    public static class Torni extends Nappula {
        private final static char TALLENNUSMERKKI = 't';
        public Torni(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    public static class Kuningatar extends Nappula {
        private final static char TALLENNUSMERKKI = 'q';
        public Kuningatar(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    public static class Kuningas extends Nappula {
        private final static char TALLENNUSMERKKI = 'k';
        public Kuningas(Vari vari) {
            super(vari);
        }

        @Override
        public Ruutu[] laskeSiirtoMahdollisuudet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public char getTallennusMerkki() {
            return TALLENNUSMERKKI;
        }
    }
    
    
    
    
    public static void main(String[] args) {
        Sotilas nappula = new Nappula.Sotilas(Vari.MUSTA);
        Lahetti nappula2 = new Nappula.Lahetti(Vari.VALKOINEN);
        Nappula nappula3 = new Nappula.Kuningas(Vari.VALKOINEN);
        System.out.println(nappula.getTallennusMerkki());
        System.out.println(nappula2.getTallennusMerkki());
        System.out.println(nappula3.getTallennusMerkki());
        //nappula.
    }
}
