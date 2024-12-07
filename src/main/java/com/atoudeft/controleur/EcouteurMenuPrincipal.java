package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauConfigServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class EcouteurMenuPrincipal implements ActionListener {
    private Client client;
    private JFrame fenetre;

    public EcouteurMenuPrincipal(Client client, JFrame fenetre) {
        this.client = client;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String action;
        String alias;
        int res;

        if (source instanceof JMenuItem) {
            action = ((JMenuItem)source).getActionCommand();
            switch (action) {
                case "CONNECTER":
                    if (!client.isConnecte()) {
                        if (!client.connecter()) {
                            JOptionPane.showMessageDialog(fenetre, "Le serveur ne répond pas");
                            break;
                        }
                    }
                    break;
                case "DECONNECTER":
                    if (!client.isConnecte())
                        break;
                    res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                            "Confirmation Déconnecter",
                            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                    if (res == JOptionPane.OK_OPTION){
                        client.deconnecter();
                    }
                    break;
                case "CONFIGURER":
                    if(!client.isConnecte()){
                        break;
                    }
                    PanneauConfigServeur panneauConfigServeur = new PanneauConfigServeur("127.0.0.1", 8888);
                    res = JOptionPane.showConfirmDialog(fenetre, panneauConfigServeur,
                            "Configuration Serveur",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (res == JOptionPane.OK_OPTION) {
                        try {
                            String portString = panneauConfigServeur.getPortServeur();
                            int port = Integer.parseInt(portString);

                            JOptionPane.showMessageDialog(null, "Configuration acceptée :\nAdresse IP : "
                                            + panneauConfigServeur.getAdresseServeur() + "\nPort : " + port,
                                    "Succès",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Le numéro de port doit être un entier valide.",
                                    "Erreur de saisie",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Configuration annulée.",
                                "Annulation",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    //TODO : compléter (question 1.3)
                    break;
                case "QUITTER":
                    if (client.isConnecte()) {
                        res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                                "Confirmation Quitter",
                                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        if (res == JOptionPane.OK_OPTION){
                            client.deconnecter();
                            System.exit(0);
                        }
                    }
                    else
                        System.exit(0);
                    break;
            }
        }
    }
}