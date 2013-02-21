/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logiikka.ShakkiPeli;
import tiedostonKasittely.PeliTiedostoMuuntaja;
import tiedostonKasittely.ResurssienLukija;

/**
 * Luokka joka sisältää ohjelman graafiset komponentit
 * @author Antti
 */
public class GUI extends JFrame {

    private LautaKangas lautaKangas;
    private ShakkiPeli shakkiPeli;
    
    public GUI(ShakkiPeli shakkiPeli) {
        JTextArea lokiText = new LokiTextArea();
        Logger.getGlobal().log(Level.INFO, "Tervetuloa kaksinpelishakkiin.\n"+
                "Klikkaa nappulaa siirtääksesi sitä. Oikeasta laidasta voit tallentaa pelin, avata tallennetun pelin\n"+
                "tai aloittaa kokonaan uuden pelin. Muistathan että uuden pelin aloittaminen pyyhkii käynnissä\n"+
                "olevan pelin tallentamatta sitä ensin.");
        this.shakkiPeli = shakkiPeli;
        setTitle("Kaksinpeli-shakki");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.lautaKangas = new LautaKangas(shakkiPeli);
        setLayout(new BorderLayout());
        add(lautaKangas, BorderLayout.CENTER);
        lisaaNappulat();
        JScrollPane scrollattavaLokiText = new JScrollPane(lokiText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollattavaLokiText, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }
    
    /**
     * Antaa käyttäjälle tiedostonselausikkunan josta hän valitsee tiedoston talletettavaksi tai avattavaksi.
     * @param hyvaksyNappulanTeksti Teksti joka lukee hyväksy nappulassa. Esim Open tai Save.
     * @return Valitun tiedoston tiedostopolku.
     */
    private String kayttajanValitsemaTiedosto(String hyvaksyNappulanTeksti) {
        JFileChooser fileChooser = new JFileChooser();
        int tulos = fileChooser.showDialog(this, hyvaksyNappulanTeksti);
        if (tulos == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
    
    /**
     * Lisää uusi peli-, avaa- ja tallenna nappulan käyttöliittymään.
     */
    private void lisaaNappulat() {
        
        JPanel nappulaPaneeli = new JPanel();
        nappulaPaneeli.setLayout(new GridLayout(3, 1));
        
        //UusiPeli nappula
        JButton uusiPeli = new JButton("Uusi peli");
        uusiPeli.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Logger.getGlobal().log(Level.INFO, "Aloitetaan uusi peli ja pyyhitään vanha.");
                ShakkiPeli uusiPeli = PeliTiedostoMuuntaja.tekstiShakkiPeliksi(ResurssienLukija.lueTiedostoTekstiksi("/resurssit/aloitusLauta.txt"));
                setShakkiPeli(uusiPeli);
            }
        });
        nappulaPaneeli.add(uusiPeli);
        
        //Avaa nappula
        JButton avaaPeli = new JButton("Avaa peli");
        avaaPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logger.getGlobal().log(Level.INFO, "Etsi shakkipeli jonka haluat avata, valitse se ja paina sitten Avaa.");
                String polku = kayttajanValitsemaTiedosto("Open");
                if (polku == null) {
                    Logger.getGlobal().log(Level.INFO, "Peruutit pelin avaamisen.");
                } else {
                    ShakkiPeli uusiPeli = PeliTiedostoMuuntaja.avaaPeli(polku);
                    if (uusiPeli != null) {
                        setShakkiPeli(uusiPeli);
                    } else {
                        Logger.getGlobal().log(Level.WARNING, "Virhe avattaessa tiedostoa. \nVarmista että tiedosto on sisältää tällä ohjelmmalla tallennetun shakkipelin.");
                    }
                }
            }
        });
        nappulaPaneeli.add(avaaPeli);
        
        //Tallenna nappula
        JButton tallennaPeli = new JButton("Tallenna peli");
        tallennaPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logger.getGlobal().log(Level.INFO, "Siirry kansioon johon haluat tallentaa shakkipelin, nimeä se ja paina sitten Tallenna.");
                String polku = kayttajanValitsemaTiedosto("Save");
                if (polku == null) {
                    Logger.getGlobal().log(Level.INFO, "Peruutit pelin talletuksen.");
                } else {
                    boolean tallennusOnnistui = PeliTiedostoMuuntaja.tallennaPeli(shakkiPeli, polku);
                    if (!tallennusOnnistui) {
                        Logger.getGlobal().log(Level.WARNING, "Tallennus epäonnistui");
                    } else {
                        Logger.getGlobal().log(Level.WARNING, "Shakkipeli tallennettu tiedostoon "+polku);
                    }
                }
            }
        });
        nappulaPaneeli.add(tallennaPeli);
        
        add(nappulaPaneeli, BorderLayout.EAST);
    }
    
    /**
     * Palauttaa käyttöliittymän käyttämän ShakkiPeli olion.
     * @return ShakkiPeli olio jota käyttöliittymä käyttää.
     */
    public ShakkiPeli getShakkiPeli() {
        return shakkiPeli;
    }
    
    /**
     * Asettaa ShakkiPeli olion käyttöliittymän käytettäväksi.
     * @param shakkiPeli ShakkiPeli joka asetetaan käyttöliittymän käytettäväksi.
     */
    public void setShakkiPeli(ShakkiPeli shakkiPeli) {
        lautaKangas.setShakkiPeli(shakkiPeli);
        this.shakkiPeli = shakkiPeli;
    }
    
}
