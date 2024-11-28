package view;

import entities.*;
import logManagement.LogCreator;
import utilities.Action;
import utilities.Formats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;

public class Form extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pNom;
    private JPanel pDateNaissance;
    private JPanel pRace;
    private JPanel pPlumes;
    private JLabel lNom;
    private JLabel lDateNaissance;
    private JLabel lRace;
    private JLabel lPlumes;
    private JTextField tfNom;
    private JTextField tfDateNaissance;
    private JTextField tfRace;
    private JTextField tfPlumes;
    private JLabel lException;

    private Espece espece = null;
    private Action action = null;
    private Animal animal = null;

    public Form(Espece espece, Action action, Animal animal) {
        this.espece = espece;
        this.action = action;
        this.animal = animal;
        init();
        setListeners();
    }

    private void init() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        this.setSize(600, 300);
//        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        tfNom.setHorizontalAlignment(SwingConstants.RIGHT);
        tfDateNaissance.setHorizontalAlignment(SwingConstants.RIGHT);
        tfRace.setHorizontalAlignment(SwingConstants.RIGHT);
        tfPlumes.setHorizontalAlignment(SwingConstants.RIGHT);

        lException.setForeground(Color.RED);

        if (this.animal != null) {
            tfNom.setText(animal.getNom());
            tfDateNaissance.setText(animal.getDateNaissance().format(Formats.FORMAT_DDMMYYYY));

            if (this.espece == Espece.Chien) {
                tfRace.setText(((Chien) this.animal).getRace());
                pPlumes.setVisible(false);
            } else if (this.espece == Espece.Oiseau) {
                tfPlumes.setText(String.valueOf(((Oiseau) this.animal).getNombreDePlumes()));
                pRace.setVisible(false);
            }

            if (this.action == Action.Suppression) {
                tfNom.setEditable(false);
                tfDateNaissance.setEditable(false);
                tfRace.setEditable(false);
                tfPlumes.setEditable(false);
            }
        }else{

            if (this.espece == Espece.Chien) {
                lPlumes.setVisible(false);
                pPlumes.setVisible(false);
            } else if (this.espece == Espece.Oiseau) {
                lRace.setVisible(false);
                pRace.setVisible(false);
            }
        }
    }

    private void setListeners() {
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

        tfNom.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) { onFocus();}
        });

        tfDateNaissance.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) { onFocus();}
        });

        tfRace.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) { onFocus();}
        });

        tfPlumes.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) { onFocus();}
        });
    }

    private void onOK() {
        if (this.action == Action.Suppression) {
            delete();
        } else if (this.action == Action.Creation) {
            create();
        } else if (this.action == Action.Modification) {
            update();
        }
    }

    private void onCancel() {
        returnMainWindow();
    }

    private void create() {
        try {
            LocalDate dDateNaissance = LocalDate.parse(tfDateNaissance.getText(),
                            Formats.FORMAT_DDMMYYYY);
            switch (this.espece) {
                case Chien:
                    Chien chien = new Chien(tfNom.getText(), dDateNaissance,
                            tfRace.getText());
                    Animaux.animals.add(chien);
                    break;
                case Oiseau:
                    Oiseau oiseau = new Oiseau(tfNom.getText(),
                            dDateNaissance, Integer.parseInt(tfPlumes.getText()));
                    Animaux.animals.add(oiseau);
                    break;
                default:
                    throw new KennelEntitiesException("Espèce non reconnue !");
            }

            JOptionPane.showMessageDialog(this, "Création réussie");
            returnMainWindow();
        } catch (NumberFormatException nfe) {
            // Exception valeur numérique non valide par utilisateur.
            lException.setText("\nErreur : Valeur numérique non valide!");
            LogCreator.publisher.log(Level.WARNING,
                    Arrays.toString(nfe.getStackTrace()));
        } catch (KennelEntitiesException aee) {
            // Exception info animal non valide par utilisateur.
            lException.setText("\nErreur : " + aee.getMessage());
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(aee.getStackTrace()));
        } catch (DateTimeException dte) {
            lException.setText("\nErreur  : La date de naissance est " +
                    "malformée ou n'est pas au format dd/mm/yyyy");
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(dte.getStackTrace()));
        } catch (Exception e) {
            // Exception non attendue attrapée, utilisateur averti et log.
            lException.setText("\nErreur : " + e.getMessage());
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(e.getStackTrace()));
            System.exit(1);
        }
    }

    private void update(){
        int index = Animaux.animals.indexOf(animal);

        try {
            LocalDate dDateNaissance = LocalDate.parse(tfDateNaissance.getText(),
                    Formats.FORMAT_DDMMYYYY);
            this.animal.setNom(tfNom.getText());
            this.animal.setDateNaissance(dDateNaissance);

            switch (this.espece) {
                case Chien:
                    ((Chien)animal).setRace(tfRace.getText());
                    Animaux.animals.set(index, animal);
                    break;
                case Oiseau:
                    ((Oiseau)animal).setNombreDePlumes(Integer.parseInt(tfPlumes.getText()));
                    Animaux.animals.set(index, animal);
                    break;
                default:
                    throw new KennelEntitiesException("Espèce non reconnue !");
            }

            JOptionPane.showMessageDialog(this, "Modification réussie");
            returnMainWindow();
        } catch (NumberFormatException nfe) {
            // Exception valeur numérique non valide par utilisateur.
            lException.setText("\nErreur : Valeur numérique non valide!");
            LogCreator.publisher.log(Level.WARNING,
                    Arrays.toString(nfe.getStackTrace()));
        } catch (KennelEntitiesException aee) {
            // Exception info animal non valide par utilisateur.
            lException.setText("\nErreur : " + aee.getMessage());
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(aee.getStackTrace()));
        } catch (DateTimeException dte) {
            lException.setText("\nErreur  : La date de naissance n'est pas au format dd/mm/yyyy");
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(dte.getStackTrace()));
        } catch (Exception e) {
            // Exception non attendue attrapée, utilisateur averti et log.
            lException.setText("\nErreur : " + e.getMessage());
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(e.getStackTrace()));
            System.exit(1);
        }
    }

    private void delete() {
        int ret = JOptionPane.showConfirmDialog(this,
                "Voulez vous supprimer " + this.animal.getNom()
        );

        if (ret == JOptionPane.OK_OPTION) {
            Animaux.animals.remove(animal);
            JOptionPane.showMessageDialog(this,"Animal bien supprimé !");
            returnMainWindow();
        }
    }

    private void onFocus(){
        lException.setText("");
    }

    private void returnMainWindow(){
        new Menu().setVisible(true);
        dispose();
    }
}
