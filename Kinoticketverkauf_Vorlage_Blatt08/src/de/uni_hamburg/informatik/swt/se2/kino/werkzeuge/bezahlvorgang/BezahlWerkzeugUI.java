package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BezahlWerkzeugUI {
	
	public static final int MAX_EINGABELAENGE = 8;
	
	private JDialog _dialog;
	private JButton _bestaetigenButton;
	private JButton _abbrechenButton;
	private JTextField _eingabeFeld;
	private JLabel _preisLabel;
	private JLabel _rueckgeldLabel;
	
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
        _eingabeFeld.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (_eingabeFeld.getText().length() > MAX_EINGABELAENGE)
				{
					arg0.consume();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (_eingabeFeld.getText().length() > MAX_EINGABELAENGE)		
				{
					arg0.consume();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
        _rueckgeldLabel = new JLabel("nothing for you");
        
        linksObenPanel.add(_preisLabel, BorderLayout.NORTH);
        linksObenPanel.add(_eingabeFeld, BorderLayout.CENTER);
        linksObenPanel.add(_rueckgeldLabel, BorderLayout.SOUTH);
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
    
    /**
     * Zeigt das Bezahlfenster.
     */
    public void showDialog()
    {
    	_dialog.setSize(400, 200);
    	_dialog.setLocation(1200, 500);
    	_dialog.setVisible(true);
    }
    
    /**
     * Versteckt das Bezahlfenster.
     */
    public void hideDialog()
    {
    	_dialog.setVisible(false);
    }
    
    /**
     * Schließt das Bezahlfenster.
     */
    public void closeDialog(){
    	_dialog.dispose();
    }
    
    private JPanel erstelleTastatur()
    {
    	return new NumPad();	
    }
    
    /**
     * Gibt den aktuellen String im Eingabefeld zurück.
     */
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
    
    /**
     * Gibt das Eingabefeld zurück.
     */
    public JTextField getEingabeFeld()
    {
        return _eingabeFeld;
    }
    
    /**
	 * Gibt den Preis-String im Label zurück.
     */
    public String getPreis()
    {
    	return _preisLabel.getText();
    }
    
    /**
     * Schreibt den gegebenen Text ins Eingabefeld.
     */
    public void setEingabefeld(String text)
    {
    	_eingabeFeld.setText(text);
    }
    /**
     * Setzt das Preislabel neu mit gegebenem Text.
     * @param text der zu setzende Text
     */
    public void setPreisLabel(String text)
    {
    	_preisLabel.setText(text);
    }
    
    /**
     * Setzt das Rückgeldlabel neu mit gegebenem Text.
     * @param text der zu setzende Text
     */
    public void setRueckgeldLabel(String rueckgeld)
    {
    	_rueckgeldLabel.setText(rueckgeld);
    }
    
}
