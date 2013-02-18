/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import logiikka.ShakkiPeli;
import tiedostonKasittely.PeliTiedostoMuuntaja;

/**
 * Luokka joka sisältää ohjelman graafiset komponentit
 * @author Antti
 */
public class GUI extends JFrame {

    private LautaKangas lautaKangas;
    private ShakkiPeli shakkiPeli;
    
    public GUI(ShakkiPeli shakkiPeli) {
        this.shakkiPeli = shakkiPeli;
        setTitle("Kaksinpeli-shakki");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.lautaKangas = new LautaKangas(shakkiPeli);
        setLayout(new FlowLayout());
        add(lautaKangas);
        lisaaNappulat();
        setVisible(true);
        pack();
    }
    
    
    private String kayttajanValitsemaTiedosto(String hyvaksyNappulanTeksti) {
        JFileChooser fileChooser = new JFileChooser();
        int tulos = fileChooser.showDialog(this, hyvaksyNappulanTeksti);
        if (tulos == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
    
    private void lisaaNappulat() {
        //Avaa nappula
        JButton avaaPeli = new JButton("Avaa peli");
        avaaPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polku = kayttajanValitsemaTiedosto("Open");
                ShakkiPeli uusiPeli = PeliTiedostoMuuntaja.avaaPeli(polku);
                if (uusiPeli != null) {
                    setShakkiPeli(uusiPeli);
                } else {
                    System.out.println("Virhe avattaessa tiedostoa");
                }
            }
        });
        add(avaaPeli);
        
        //Tallenna nappula
        JButton tallennaPeli = new JButton("Tallenna peli");
        tallennaPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polku = kayttajanValitsemaTiedosto("Save");
                boolean tallennusOnnistui = PeliTiedostoMuuntaja.tallennaPeli(shakkiPeli, polku);
                if (!tallennusOnnistui) System.out.println("Tallennus epäonnistui");
            }
        });
        add(tallennaPeli);
    }
    
    public ShakkiPeli getShakkiPeli() {
        return shakkiPeli;
    }
    
    public void setShakkiPeli(ShakkiPeli shakkiPeli) {
        lautaKangas.setShakkiPeli(shakkiPeli);
        this.shakkiPeli = shakkiPeli;
    }
    
}
