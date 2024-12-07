package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauHistorique  extends JPanel {
    private JTextArea txtHistorique;

    public PanneauHistorique() {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        txtHistorique = new JTextArea();

        txtHistorique = new JTextArea(20,50);
        txtHistorique.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtHistorique);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        p1.add(scrollPane, BorderLayout.CENTER);

        this.add(p1, BorderLayout.CENTER);
    }

    public JTextArea getTxtHistorique() {
        return txtHistorique;
    }
    public void ecrireHistorique(String historique) {
        txtHistorique.setText(historique);
    }
}
