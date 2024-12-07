package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblAdrServeur = new JLabel("Adresse IP : ");
        txtAdrServeur = new JTextField(20);
        txtAdrServeur.setText(adr);
        p1.add(lblAdrServeur);
        p1.add(txtAdrServeur);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblPort = new JLabel("Port : ");
        txtNumPort = new JTextField(20);
        txtNumPort.setText(Integer.toString(port));
        p2.add(lblPort);
        p2.add(txtNumPort);

        JPanel pTout = new JPanel(new GridLayout(2,1));

        pTout.add(p1);
        pTout.add(p2);

        this.add(pTout);



        //à compléter
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
