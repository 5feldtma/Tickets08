package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class BezahlWerkzeug extends ObservableSubwerkzeug
{

    public static final String AKTION_VERKAUF = "Verkauf";
    public static final String AKTION_ABBRUCH = "Abbruch";

    private BezahlWerkzeugUI _ui;
    private int _centPreis;
    private String _lastInput = "";

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
        registriereUIAktionen();
        _ui.getBestaetigenButton()
            .setEnabled(false);
    }

    /**
     * Zeigt das Bezahlfenster an.
     */
    public void showDialog()
    {
        _ui.showDialog();
    }

    /**
     * Schließt das Bezahlfenster.
     */
    public void closeDialog()
    {
        _ui.closeDialog();
    }
    
    /**
     * Gibt das Panel dieses Subwerkzeugs zurück. Das Panel sollte von einem
     * Kontextwerkzeug eingebettet werden.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {

        _ui.getBestaetigenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.hideDialog();
                    _ui.setEingabefeld("");
                    informiereUeberAenderung(AKTION_VERKAUF);
                }
            });

        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.hideDialog();
                    _ui.setEingabefeld("");
                    informiereUeberAenderung(AKTION_ABBRUCH);
                }
            });

        _ui.getEingabeFeld()
            .getDocument()
            .addDocumentListener(new DocumentListener()
            {
                public void changedUpdate(DocumentEvent e)
                {
                    aktualisiere();
                }

                public void removeUpdate(DocumentEvent e)
                {
                    _lastInput = getInput();
                    aktualisiere();
                }

                public void insertUpdate(DocumentEvent e)
                {
                    if (e.getLength() + _lastInput
                        .length() <= BezahlWerkzeugUI.MAX_EINGABELAENGE)
                    {
                        _lastInput = getInput();
                        aktualisiere();
                    }
                }
            });
    }

    /**
     * Aktualisiert das Bezahlfenster mit gegebenem Preis.
     * 
     * @param preis
     *            Der neu gesetzte Preis.
     */
    public void aktualisierePreis(int preis)
    {
        _centPreis = preis;
        aktualisiere();
    }

    /**
     * Aktiviert den OK-Button, wenn Bezahlung vorgenommen werden kann.
     */
    private void aktualisiereBestätigenButton()
    {

        if (hatKorrektesFormat(getInput()) && _centPreis > 0
                && _centPreis <= inputZuCent())
        {
            _ui.getBestaetigenButton()
                .setEnabled(true);
        }
        else
        {
            _ui.getBestaetigenButton()
                .setEnabled(false);
        }

    }

    /**
     * Gibt den aktuellen Userinput im Eingabefeld zurück.
     * 
     * @return den aktuellen Userinput im Eingabefeld
     */
    private String getInput()
    {
        return _ui.getInput();
    }

    /**
     * Prüft, ob ein String im Geldbetragformat ist. z.B. "15,14", "13", "2.1"
     * return true, "15,", "a.3" return false
     * 
     * @param betrag
     *            der Inputstring, der geprüft wird
     * @return ist String im Geldformat
     */
    private boolean hatKorrektesFormat(String betrag)
    {

        if (betrag.matches("^\\d+([,.]\\d{1,2})?$"))
        {
            return true;
        }
        return false;
    }

    /**
     * Extrahiert Centbetrag aus dem Nutzerinput des Textfelds. z.B "15,77"
     * returns 1577
     * 
     * @return Der Centbetrag, der aus dem Input extrahiert wurde
     */
    private int inputZuCent()
    {
        String input = getInput();
        int euros = 0;
        int cents = 0;
        // Preis enthält kein , oder .
        if (hatKorrektesFormat(input))
        {
            if (!input.matches(".*[,.].*"))
            {
                euros = Integer.parseInt(input);
            }
            else
            {
                String[] preisArray = input.split("[,.]");
                euros = Integer.parseInt(preisArray[0]);
                cents = Integer.parseInt(preisArray[1]);
                if (preisArray[1].length() == 1)
                {
                    cents *= 10;
                }
            }
        }
        return euros * 100 + cents;
    }

    /**
     * Aktualisiert die Preisanzeige mit gegebenem Preis.
     * 
     * @param preis
     *            der anzuzeigende Preis.
     */
    private void aktualisierePreisAnzeige(int preis)
    {
        if (preis == 0)
        {
            _ui.setPreisLabel("Kann nicht verkaufen.");
            _ui.setRueckgeldLabel("");
        }
        else
        {
            _ui.setPreisLabel(displayFormat(preis));

        }
    }

    /**
     * Aktualisiert die Rückgeldanzeige.
     */
    private void aktualisiereRueckgeldAnzeige()
    {
        int differenz = _centPreis - inputZuCent();
        String anzeigeWert;
        if (!hatKorrektesFormat(getInput()))
        {
            anzeigeWert = "Kein korrekter Betrag.";
        }
        else if (differenz > 0 && inputZuCent() > 1000000)
        {
            anzeigeWert = "Es fehlen noch: " + displayFormat(differenz) + ".";
        }
        else if (differenz < 0)
        {
            if (inputZuCent() > 1000000) // zehntausend Euro
            {
                anzeigeWert = "Kauf dir dein eigenes Kino.";
                _ui.getBestaetigenButton()
                    .setEnabled(false);

            }
            else
            {
                anzeigeWert = "Rückgeld: " + displayFormat(-differenz) + ".";
            }
        }
        else
        {
            anzeigeWert = "Viel Spaß beim Film!";
        }
        _ui.setRueckgeldLabel(anzeigeWert);
    }

    /**
     * Aktualisiert Preisanzeige, OK-Button und Rückgeldanzeige
     */
    private void aktualisiere()
    {
        aktualisiereBestätigenButton();
        aktualisiereRueckgeldAnzeige();
        aktualisierePreisAnzeige(_centPreis);
    }

    /**
     * Formatiert einen Centbetrag zu Euro-String. Bsp: 1573 returns "15,73 €"
     * 
     * @param input
     *            der umzuwandelnde Betrag
     * @return der formatierte Euro-String
     */
    private String displayFormat(int input)
    {
        NumberFormat numb = NumberFormat.getCurrencyInstance();
        double centBetrag = input;
        double euroBetrag = centBetrag / 100;

        return numb.format(euroBetrag);
    }
}
