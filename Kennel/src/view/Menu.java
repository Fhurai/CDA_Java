package view;

import entities.*;
import logManagement.LogCreator;
import utilities.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu extends JFrame {
    private JPanel contentPane;
    private JButton btnQuit;
    private JPanel pEspece;
    private JPanel pAction;
    private JPanel pSelection;
    private JLabel lEspeceTitre;
    private JLabel lActionTitre;
    private JLabel lSelectionTitre;
    private JButton bChien;
    private JButton bOiseau;
    private JButton btnCreation;
    private JButton btnListe;
    private JButton btnModification;
    private JButton btnSuppression;
    private JComboBox cbSelection;
    private JButton btnSelection;

    private Dimension minDimension = new Dimension(250, 300);
    private Dimension midDimension = new Dimension(450, 300);
    private Dimension maxDimension = new Dimension(650, 300);

    private Espece espece = null;
    private Action action = null;
    private Animal selectedAnimal = null;


    public Menu() {
        init();
        setListeners();
    }

    private void init() {
        this.setContentPane(contentPane);
        this.getRootPane().setDefaultButton(btnQuit);
        this.setMinimumSize(minDimension);
        this.setLocationRelativeTo(null);

        pAction.setVisible(false);
        pSelection.setVisible(false);
    }

    private void setListeners() {
        setCloseListeners();
        setEspeceListeners();
        setActionListeners();

        // Bouton Sélection
        btnSelection.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Animal selectedAnimal = null;

                for(Animal animal : Animaux.animals){
                    if(animal.getNom() == cbSelection.getSelectedItem()){
                        selectedAnimal = animal;
                    }
                }

                Form form = new Form(espece, action, selectedAnimal);
                form.setVisible(true);
                dispose();
            }
        });
    }

    private void setCloseListeners() {
        // Boutons de fermeture de la fenêtre.
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void setEspeceListeners() {
        // Bouton chien
        bChien.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectEspece(Espece.Chien);
            }
        });

        // Bouton oiseau
        bOiseau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectEspece(Espece.Oiseau);
            }
        });
    }

    private void setActionListeners() {
        // Bouton Création
        btnCreation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectAction(Action.Creation);
                Form form = new Form(espece, action, null);
                form.setVisible(true);
                dispose();
            }
        });

        // Bouton Liste
        btnListe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectAction(Action.Liste);
                new Listing(espece).setVisible(true);
                dispose();
            }
        });

        // Bouton Modification
        btnModification.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectAction(Action.Modification);
            }
        });

        // Bouton Suppression
        btnSuppression.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectAction(Action.Suppression);
            }
        });
    }

    private void onCancel() {
        // Log de l'arrêt de l'application et message utilisateur.
        LogCreator.stop();
        dispose();
    }

    private void selectEspece(Espece enCours) {
        cbSelection.removeAllItems();
        this.espece = enCours;

        pAction.setVisible(true);
        this.setMinimumSize(midDimension);
        this.setMaximumSize(midDimension);

        switch (enCours) {
            case Chien:
                Animaux.animals.stream()
                        .filter(a -> a instanceof Chien)
                        .forEach(a -> cbSelection.addItem(a.getNom()));
                break;
            case Oiseau:
                Animaux.animals.stream()
                        .filter(a -> a instanceof Oiseau)
                        .forEach(a -> cbSelection.addItem(a.getNom()));
                break;
        }
    }

    private void selectAction(Action action) {
        this.action = action;

        if (this.action == Action.Modification || this.action == Action.Suppression) {
            String verbe = switch (this.action) {
                case Modification -> "modifier";
                case Suppression -> "supprimer";
                default -> "";
            };

            lSelectionTitre.setText("Quel " + espece.toString().toLowerCase() +
                    " voulez vous " + verbe + " ?");
            btnSelection.setText(verbe.toUpperCase());
            pSelection.setVisible(true);
            this.setMinimumSize(maxDimension);
        } else {
            pSelection.setVisible(false);
            this.setMinimumSize(midDimension);
            this.setPreferredSize(midDimension);
        }
    }
}
