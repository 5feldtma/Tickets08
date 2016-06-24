package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;



public class BezahlWerkzeug {

	private BezahlWerkzeugUI _ui;

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
        registriereUIAktionen();
    }
    
    public JDialog getUIDialog() {
    	return _ui.getUIDialog();
    }
    
    public void showDialog() {
    	_ui.showDialog();
    }
    
    public void closeDialog(){
    	_ui.closeDialog();
    }
    
    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.getAbbrechenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });

        _ui.getBestaetigenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	hatKorrektesFormat(getInput());
            }
        });
    }
    
    private String getInput()
    {
    	return _ui.getInput();
    }
    
    public boolean hatKorrektesFormat(String betrag)
    {
    	if(betrag.matches("^\\d+([,.]\\d\\d)?$"))
    	{
    		System.out.println("Korrekt!");
    		return true;
    	}
    	return false;
    }
}
