package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import javax.swing.JDialog;



public class BezahlWerkzeug {

	private BezahlWerkzeugUI _ui;

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();

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
}
