package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;

    public EcouteurListeComptes(Client client) {
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        //à compléter
        if (evt.getClickCount() == 2) {
            Object source = evt.getSource();
            String ligneDeCompte;
            JList<String> jlNumComptes;

            if (source instanceof JList) {
                jlNumComptes = (JList<String>) source;
                int index = jlNumComptes.locationToIndex(evt.getPoint());
                ligneDeCompte = jlNumComptes.getModel().getElementAt(index);

                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(ligneDeCompte);
                if (matcher.find()) {
                    String typeCompte = matcher.group(1);

                    client.envoyer("SELECT " + typeCompte.toLowerCase());
                }
            }



        }
    }
}