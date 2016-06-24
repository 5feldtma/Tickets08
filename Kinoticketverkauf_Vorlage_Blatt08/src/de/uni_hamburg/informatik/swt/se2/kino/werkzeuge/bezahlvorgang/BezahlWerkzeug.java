package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class BezahlWerkzeug extends ObservableSubwerkzeug {

	private BezahlWerkzeugUI _ui;
	private int _preis;

	/**
	 * Initialisiert das PlatzVerkaufsWerkzeug.
	 */
	public BezahlWerkzeug() {
		_ui = new BezahlWerkzeugUI();
		registriereUIAktionen();
		_ui.getBestaetigenButton().setEnabled(false);
	}

	public JDialog getUIDialog() {
		return _ui.getUIDialog();
	}

	public void showDialog() {
		_ui.showDialog();
	}

	public void closeDialog() {
		_ui.closeDialog();
	}

	/**
	 * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
	 */
	private void registriereUIAktionen() {

		_ui.getBestaetigenButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_ui.hideDialog();
				_ui.getEingabeFeld().setText("");
				informiereUeberAenderung("Verkauf");
			}
		});

		_ui.getAbbrechenButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_ui.hideDialog();
				informiereUeberAenderung("Abbruch");
			}
		});

		_ui.getEingabeFeld().getDocument()
				.addDocumentListener(new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {
						aktualisiereBestätigenButton();
					}

					public void removeUpdate(DocumentEvent e) {
						aktualisiereBestätigenButton();
					}

					public void insertUpdate(DocumentEvent e) {
						aktualisiereBestätigenButton();
					}
				});
	}

	public void aktualisierePreis(int preis) {
		_preis = preis;
		String preisInCent = Integer.toString(preis);
		String preisInEuro;
		if(!preisInCent.equals("-1")) //ist tatsächlicher Preis 
		{
			preisInEuro = preisInCent.substring(0, preisInCent.length() - 2) + ",00";
		}
		else {
			preisInEuro = "-1";
		}
		_ui.aktualisierePreisAnzeige(preisInEuro);			
		aktualisiereBestätigenButton();
	}

	private void aktualisiereBestätigenButton() {

		if (hatKorrektesFormat(getInput()) && istPreis()
				&& (getPreis() <= gegebenerBetrag())) {
			_ui.getBestaetigenButton().setEnabled(true);
		} else {
			_ui.getBestaetigenButton().setEnabled(false);
		}

	}
	
	//TODO schnittstellenkommentare überall. Kommentare überall wo nötig
	//TODO Rückgeldanzeige

	private String getInput() {
		return _ui.getInput();
	}
	
	private boolean hatKorrektesFormat(String betrag) {
		if (betrag.matches("^\\d+([,.]\\d\\d)?$")) {
			return true;
		}
		return false;
	}

	private int gegebenerBetrag() {
			return preisZuCent(getInput());
	}

	private boolean istPreis() {
		return _preis != -1;
	}

	private int getPreis() {
		return _preis;
	}

	private int preisZuCent(String arg) {
		int euros = 0;
		int cents = 0;
		// Preis enthält kein , oder .
		if (hatKorrektesFormat(arg)) {
			if (arg.indexOf(',') == -1 && arg.indexOf('.') == -1) {
				euros = Integer.parseInt(arg);
			} else {
				String[] preisArray = arg.split("[,.]");
				euros = Integer.parseInt(preisArray[0]);
				cents = Integer.parseInt(preisArray[1]);
			}
		}
		return euros * 100 + cents;
	}

}
