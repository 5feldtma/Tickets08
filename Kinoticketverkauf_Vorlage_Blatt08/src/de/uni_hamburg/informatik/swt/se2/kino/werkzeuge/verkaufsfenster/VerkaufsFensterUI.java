package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerkaufsFensterUI
{
    private JFrame _frame = new JFrame("VerkaufsFenster");;
    private TastaturPanel _tastatur = new TastaturPanel();
    private JPanel _linkeSeite = new JPanel();
    private JPanel _verkaufsDialog = new JPanel();
    private JPanel _bestaetigung = new JPanel();
    private JLabel _preis = new JLabel("Preis: ");
    private JTextField _erhaltenerBetrag = new JTextField(15);
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
        _frame.setVisible(true);
        _frame.pack();
        
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//nur für Testzwecke vorhanden (muss noch raus)
    }

    public void aktiviere()
    {
        _frame.setVisible(true);
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
}
