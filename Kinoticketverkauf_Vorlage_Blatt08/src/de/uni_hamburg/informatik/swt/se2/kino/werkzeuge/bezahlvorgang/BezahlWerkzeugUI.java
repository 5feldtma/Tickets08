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

        JPanel preisPanel = new JPanel(new BorderLayout());

        _eingabeFeld = new JTextField();

        preisPanel.add(_eingabeFeld, BorderLayout.NORTH);
        _bestaetigenButton = new JButton("OK");
        //Buttons unfocusable damit man immer in der Preiseingabe bleibt
        _bestaetigenButton.setFocusable(false);
        preisPanel.add(_bestaetigenButton, BorderLayout.WEST);    
        _abbrechenButton = new JButton("Abbrechen");
        //Buttons unfocusable damit man immer in der Preiseingabe bleibt
        _abbrechenButton.setFocusable(false);
        preisPanel.add(_abbrechenButton, BorderLayout.EAST);
        
        
        JPanel tastaturPanel = erstelleTastatur();   
        
        dialog.add(preisPanel, BorderLayout.WEST);
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
}
