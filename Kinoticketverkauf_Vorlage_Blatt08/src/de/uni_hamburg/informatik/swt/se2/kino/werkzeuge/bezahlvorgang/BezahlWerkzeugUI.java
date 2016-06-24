package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BezahlWerkzeugUI {
	
	private JDialog _dialog;
	private JButton _bestaetigenButton;
	private JButton _abbrechenButton;
	private JTextField _eingabeFeld;
	private JLabel _preisLabel;
	
	public BezahlWerkzeugUI()
    {
        _dialog = erstelleDialog();
    }

    /**
     * Erzeugt das Panel, in dem der Kinosaal mit den Sitzplätzen dargestellt
     * wird.
     */
    private JDialog erstelleDialog()
    {
        JDialog dialog = new JDialog();
        dialog.setLayout(new BorderLayout());

        JPanel linkesPanel = new JPanel(new BorderLayout());
        JPanel linksObenPanel = new JPanel(new BorderLayout());
        JPanel linksUntenPanel = new JPanel(new BorderLayout());
        
        linkesPanel.add(linksObenPanel, BorderLayout.NORTH);
        linkesPanel.add(linksUntenPanel, BorderLayout.SOUTH);

        _preisLabel = new JLabel("0");
        _eingabeFeld = new JTextField();
        
        linksObenPanel.add(_preisLabel, BorderLayout.NORTH);
        linksObenPanel.add(_eingabeFeld, BorderLayout.SOUTH);
        _bestaetigenButton = new JButton("OK");
        //Buttons unfocusable damit man immer in der Preiseingabe bleibt
        _bestaetigenButton.setFocusable(false);
        linksUntenPanel.add(_bestaetigenButton, BorderLayout.WEST);    
        _abbrechenButton = new JButton("Abbrechen");
        //Buttons unfocusable damit man immer in der Preiseingabe bleibt
        _abbrechenButton.setFocusable(false);
        linksUntenPanel.add(_abbrechenButton, BorderLayout.EAST);
        
        
        JPanel tastaturPanel = erstelleTastatur();   
        
        dialog.add(linkesPanel, BorderLayout.WEST);
        dialog.add(tastaturPanel, BorderLayout.EAST);
        

        return dialog;
    }
    
    public JDialog getUIDialog()
    {
    	return _dialog;
    }
    
    public void showDialog()
    {
    	_dialog.setSize(500, 200);
    	_dialog.setLocation(1200, 500);
    	_dialog.setVisible(true);
    }
    
    public void hideDialog()
    {
    	_dialog.setVisible(false);
    }
    
    public void closeDialog(){
    	_dialog.dispose();
    }
    
    private JPanel erstelleTastatur()
    {
    	return new NumPad();	
    }
    
    public String getInput()
    {
    	return _eingabeFeld.getText();
    }
    
    public void aktualisierePreisAnzeige(String preis)
    {
    	if(preis.equals("-1"))
    	{
    		_preisLabel.setText("Kann nicht verkaufen.");
    	}
    	else 
    	{	
    		
    		_preisLabel.setText(preis);
    	}
    }
    
    /**
     * Gibt den Bestaetigen-Button zurück.
     */
    public JButton getBestaetigenButton()
    {
        return _bestaetigenButton;
    }
    
    /**
     * Gibt den Abbrechen-Button zurück.
     */
    public JButton getAbbrechenButton()
    {
        return _abbrechenButton;
    }
    
    /**
     * Gibt das Eingabefeld zurück.
     */
    public JTextField getEingabeFeld()
    {
        return _eingabeFeld;
    }
    
    public String getPreis()
    {
    	return _preisLabel.getText();
    }
    
}
