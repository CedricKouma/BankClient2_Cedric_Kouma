package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    public EcouteurOperationsCompte(Client client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter :
        Object source = e.getSource();
        String nomAction;
        int res;
        if (source instanceof JButton) {
            nomAction = ((JButton) source).getActionCommand();
            switch (nomAction) {
                case "EPARGNE":
                    client.envoyer("EPARGNE");
                    break;
                case "DEPOT":
                    if (!client.isConnecte()) {
                        break;
                    }
                    PanneauDepot panneauDepot = new PanneauDepot();
                    res = JOptionPane.showConfirmDialog(null, panneauDepot,
                            "Depot",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);

                    if (res == JOptionPane.OK_OPTION) {
                        try {
                            String montantString = panneauDepot.getMontant();
                            double montant = Double.parseDouble(montantString);

                            if (montant > 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Montant du dépôt accepté : " + montant,
                                        "Succès",
                                        JOptionPane.INFORMATION_MESSAGE);
                                client.envoyer("DEPOT " + montant);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Le montant doit être supérieur à zéro.",
                                        "Erreur de saisie",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException exp) {
                            JOptionPane.showMessageDialog(null,
                                    "Veuillez entrer un montant valide.",
                                    "Erreur de saisie",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dépôt annulé.",
                                "Annulation",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "RETRAIT":
                    if (!client.isConnecte()) {
                        break;
                    }

                    PanneauRetrait panneauRetrait = new PanneauRetrait();
                    res = JOptionPane.showConfirmDialog(null, panneauRetrait,
                            "Retrait",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);

                    if (res == JOptionPane.OK_OPTION) {
                        try {
                            String montantString = panneauRetrait.getMontant();
                            double montant = Double.parseDouble(montantString);

                            if (montant > 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Montant du retrait accepté : " + montant,
                                        "Succès",
                                        JOptionPane.INFORMATION_MESSAGE);
                                client.envoyer("RETRAIT " + montant);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Le montant doit être supérieur à zéro.",
                                        "Erreur de saisie",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException exp) {
                            JOptionPane.showMessageDialog(null,
                                    "Veuillez entrer un montant valide.",
                                    "Erreur de saisie",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Retrait annulé.",
                                "Annulation",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    break;

                case "TRANSFER":
                    if (!client.isConnecte()) {
                        break;
                    }

                    PanneauTransfert panneauTransfert = new PanneauTransfert();

                    res = JOptionPane.showConfirmDialog(
                            null,
                            panneauTransfert,
                            "Transfert",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );

                    if (res == JOptionPane.OK_OPTION) {
                        try {
                            String montantString = panneauTransfert.getMontant();
                            double montant = Double.parseDouble(montantString);

                            String numeroCompteDestinataire = panneauTransfert.getNoCompteDestinataire().trim();

                            if (montant > 0 && !numeroCompteDestinataire.isEmpty()) {
                                JOptionPane.showMessageDialog(null,
                                        "Tentative de Transfert accepté :\nMontant : " + montant +
                                                "\nNuméro de compte destinataire : " + numeroCompteDestinataire,
                                        "Succès",
                                        JOptionPane.INFORMATION_MESSAGE);
                                client.envoyer("TRANSFER " + montant + " " + numeroCompteDestinataire);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Veuillez entrer un montant supérieur à zéro et un numéro de compte destinataire valide.",
                                        "Erreur de saisie",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException exp) {
                            JOptionPane.showMessageDialog(null,
                                    "Veuillez entrer un montant valide.",
                                    "Erreur de saisie",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Transfert annulé.",
                                "Annulation",
                                JOptionPane.WARNING_MESSAGE);

                    }
                    break;

                case "FACTURE":
                    if (!client.isConnecte()) {
                        break;
                    }

                    PanneauFacture panneauFacture = new PanneauFacture();

                    int result = JOptionPane.showConfirmDialog(
                            null,
                            panneauFacture,
                            "Facture",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );

                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            String montantString = panneauFacture.getMontant();
                            double montant = Double.parseDouble(montantString);

                            String numeroFacture = panneauFacture.getNoFacture().trim();
                            String description = panneauFacture.getDescription().trim();

                            if (montant > 0 && !numeroFacture.isEmpty() && !description.isEmpty()) {
                                JOptionPane.showMessageDialog(null,
                                        "Tentative de Paiement de Facture acceptée :\nMontant : " + montant +
                                                "\nNuméro de facture : " + numeroFacture +
                                                "\nDescription : " + description,
                                        "Succès",
                                        JOptionPane.INFORMATION_MESSAGE);
                                client.envoyer("FACTURE " + montant + " " + numeroFacture + " " + description);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Veuillez entrer un montant supérieur à zéro, un numéro de facture, et une description.",
                                        "Erreur de saisie",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException exp) {
                            JOptionPane.showMessageDialog(null,
                                    "Veuillez entrer un montant valide.",
                                    "Erreur de saisie",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Création de la facture annulée.",
                                "Annulation",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case "HIST":
                    client.envoyer("HIST");
            }

        }
    }
}
