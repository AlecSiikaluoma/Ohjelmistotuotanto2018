/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author alecsiikaluoma
 */
public class Summa implements Komento {
    
    private TextField syottokentta;
    private TextField tuloskentta;
    private Sovelluslogiikka s;
    private Button nollaa;
    private Button undo;
    private int arvo;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka s) {
        this.syottokentta = syottokentta;
        this.tuloskentta = tuloskentta;
        this.s = s;
        this.nollaa = nollaa;
        this.undo = undo;
        this.arvo = Integer.parseInt(syottokentta.getText());
    }

    @Override
    public void suorita() {    
        s.plus(arvo);
        int laskunTulos = s.tulos();
    
        syottokentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        s.miinus(arvo);
        int laskunTulos = s.tulos();
        
        syottokentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        undo.disableProperty().set(true);
    }
    
    
}
