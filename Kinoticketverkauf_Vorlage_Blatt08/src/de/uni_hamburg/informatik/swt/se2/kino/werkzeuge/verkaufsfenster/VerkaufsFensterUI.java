package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
//import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerkaufsFensterUI
{
    private JFrame _frame = new JFrame("VerkaufsFenster");
    private TastaturPanel _tastatur = new TastaturPanel();
    private JPanel _linkeSeite = new JPanel();
    private JPanel _verkaufsDialog = new JPanel();
    private JPanel _bestaetigung = new JPanel();
    private JLabel _preis = new JLabel("Preis: ");
    private JTextField _erhaltenerBetrag = new JTextField(14);
    private JLabel _rueckgeld = new JLabel("Rückgeld: ");
    private JButton _ok = new JButton("OK");
    private JButton _abbrechen = new JButton("Abbrechen");

    public VerkaufsFensterUI()
    {
        _frame.setLayout(new FlowLayout());
        _frame.add(_linkeSeite);

        _linkeSeite.setLayout(new BorderLayout());
        _linkeSeite.add(_verkaufsDialog, BorderLayout.CENTER);
        _linkeSeite.add(_bestaetigung, BorderLayout.PAGE_END);

        _verkaufsDialog.setLayout(new GridLayout(3, 1));
        _verkaufsDialog.add(_preis);
        _verkaufsDialog.add(_erhaltenerBetrag);
        _erhaltenerBetrag.setEditable(false);
        _verkaufsDialog.add(_rueckgeld);

        _bestaetigung.setLayout(new FlowLayout());
        _bestaetigung.add(_ok);
        _bestaetigung.add(_abbrechen);

        _frame.add(_tastatur);

        _frame.pack();
        _frame.setLocation(1200, 500);
        _frame.setAlwaysOnTop(true);

    }

    /*
    public void fehlermeldung()
    {
        final JDialog dialog = new JDialog(_frame, "Fehler");
        dialog.setModal(true);
        dialog.add(new JLabel("MEHR GELD!"));
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(_frame);
        dialog.setVisible(true);
    }
    **/

    public void aktiviere()
    {
        _frame.setVisible(true);
    }

    public void setPreis(String preis)
    {
        _preis.setText(preis);
    }

    public void setErhaltenenBetrag(String erhaltenerBetrag)
    {
        _erhaltenerBetrag.setText(erhaltenerBetrag);
    }

    public void setRueckgeld(String rueckgeld)
    {
        _rueckgeld.setText(rueckgeld);
    }

    public void deaktiviere()
    {
        _frame.setVisible(false);
    }

    public JButton getOKButton()
    {
        return _ok;
    }

    public JButton getAbbrechenButton()
    {
        return _abbrechen;
    }

    public JButton getZiffernButton(int index)
    {
        return _tastatur.getButton(index);
    }
    
    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _frame.dispose();
    }
}
