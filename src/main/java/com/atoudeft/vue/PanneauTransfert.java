package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauTransfert extends JPanel {
    private JTextField txtMontant, txtNoCompteDestinataire;

    public PanneauTransfert() {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblMontant = new JLabel("Montant du dépôt : ");
        txtMontant = new JTextField(15);
        p1.add(lblMontant);
        p1.add(txtMontant);


        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblNoCompteDestinataire = new JLabel("Numero Compte Destinataire : ");
        txtNoCompteDestinataire = new JTextField(15);
        p2.add(lblNoCompteDestinataire);
        p2.add(txtNoCompteDestinataire);


        JPanel pTout = new JPanel(new GridLayout(2,1));

        pTout.add(p1);
        pTout.add(p2);

        this.add(pTout);

    }

    public String getMontant() {
        return txtMontant.getText();
    }

    public String getNoCompteDestinataire() {
        return txtNoCompteDestinataire.getText();
    }
}
