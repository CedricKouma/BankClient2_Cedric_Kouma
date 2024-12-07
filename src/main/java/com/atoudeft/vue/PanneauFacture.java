package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtNoFacture, txtDescription;

    public PanneauFacture() {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblMontant = new JLabel("Montant du dépôt : ");
        txtMontant = new JTextField(15);
        p1.add(lblMontant);
        p1.add(txtMontant);


        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblNumFacture = new JLabel("Numero de la Facture : ");
        txtNoFacture = new JTextField(15);
        p2.add(lblNumFacture);
        p2.add(txtNoFacture);


        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblDescription = new JLabel("Description : ");
        txtDescription = new JTextField(15);
        p3.add(lblDescription);
        p3.add(txtDescription);


        JPanel pTout = new JPanel(new GridLayout(3,1));

        pTout.add(p1);
        pTout.add(p2);
        pTout.add(p3);

        this.add(pTout);

    }

    public String getMontant() {
        return txtMontant.getText();
    }

    public String getNoFacture() {
        return txtNoFacture.getText();
    }

    public String getDescription() {
        return txtDescription.getText();
    }
}
