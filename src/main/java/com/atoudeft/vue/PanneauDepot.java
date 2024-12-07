package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauDepot extends JPanel {
    private JTextField txtMontant;

    public PanneauDepot() {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblMontant = new JLabel("Montant du dépôt : ");
        txtMontant = new JTextField(15);

        p1.add(lblMontant);
        p1.add(txtMontant);


        add(lblMontant);
        add(txtMontant);

        JPanel pTout = new JPanel(new GridLayout(1,1));

        pTout.add(p1);

        this.add(pTout);

    }

    public String getMontant() {
        return txtMontant.getText();
    }

}
