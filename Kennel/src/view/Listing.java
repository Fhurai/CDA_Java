package view;

import entities.Animaux;
import entities.Chien;
import entities.Espece;
import entities.Oiseau;
import utilities.Formats;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Listing extends JFrame {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JTable table;

    private Espece espece;

    public Listing(Espece espece) {
        this.espece = espece;
        init();
        setListeners();
        fillTable();
    }

    public Listing() {
        init();
        setListeners();
    }

    private void init() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonCancel);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
    }

    private void setListeners() {
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
    }

    private void onCancel() {
        new Menu().setVisible(true);
        // add your code here if necessary
        dispose();
    }

    private void fillTable() {
        DefaultTableModel modelTable;
        String[] entete;

        switch (this.espece) {
            case Espece.Chien -> entete = new String[]{"Nom", "Age", "Date " +
                    "de naissance", "Race"};
            case Espece.Oiseau -> entete = new String[]{"Nom", "Age", "Date " +
                    "de naissance", "Nombre de plumes"};
            default -> entete = new String[]{"Nom", "Age", "Date de " +
                    "naissance"};
        }

        modelTable = new DefaultTableModel(new Object[][]{}, entete) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        modelTable.addRow(entete);

        switch (this.espece) {
            case Espece.Chien:
                Animaux.animals.stream()
                        .filter(a -> a instanceof Chien)
                        .forEach(a -> modelTable.addRow(new Object[]{
                                a.getNom(),
                                a.getAge() + " ans",
                                a.getDateNaissance().format(Formats.FORMAT_DDMMYYYY),
                                ((Chien) a).getRace()
                        }));
                break;
            case Espece.Oiseau:
                Animaux.animals.stream()
                        .filter(a -> a instanceof Oiseau)
                        .forEach(a -> modelTable.addRow(new Object[]{
                                a.getNom(),
                                a.getAge() + " ans",
                                a.getDateNaissance().format(Formats.FORMAT_DDMMYYYY),
                                ((Oiseau)a).getNombreDePlumes()
                        }));
                break;
            default:
                break;
        }

        table.setModel(modelTable);

    }
}
