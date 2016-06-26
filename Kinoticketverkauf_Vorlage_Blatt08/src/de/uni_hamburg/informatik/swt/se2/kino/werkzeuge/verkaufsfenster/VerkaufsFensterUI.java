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
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

    /**
     * Aktiviert das Frame.
     */
    public void aktiviere()
    {
        _frame.setVisible(true);
    }

    /**
     * Setzt das Preis-Label.
     */
    public void setPreis(String preis)
    {
        _preis.setText(preis);
    }

    /**
     * Setzt das ErhaltenenBetrag-Label.
     */
    public void setErhaltenenBetrag(String erhaltenerBetrag)
    {
        _erhaltenerBetrag.setText(erhaltenerBetrag);
    }

    /**
     * Setzt das Rueckgeld-Label.
     */
    public void setRueckgeld(String rueckgeld)
    {
        _rueckgeld.setText(rueckgeld);
    }

    /**
     * Deaktiviert das Frame.
     */
    public void deaktiviere()
    {
        _frame.setVisible(false);
    }
    
    /**
     * Gibt den OK-Button zurück.
     */
    public JButton getOKButton()
    {
        return _ok;
    }
    
    /**
     * Gibt den Abbrechen-Button zurück.
     */
    public JButton getAbbrechenButton()
    {
        return _abbrechen;
    }

    /**
     * Gibt die Ziffern-Buttons zurück. Beinhaltet auch den Reset- und Löschen-Button.
     * 
     * @require index >= 0 && index <= 12
     */
    public JButton getZiffernButton(int index)
    {
        assert index >= 0 && index <= 12 : "Vorbedingung verletzt: Erhaltener Index verweist auf keinen Button.";
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
