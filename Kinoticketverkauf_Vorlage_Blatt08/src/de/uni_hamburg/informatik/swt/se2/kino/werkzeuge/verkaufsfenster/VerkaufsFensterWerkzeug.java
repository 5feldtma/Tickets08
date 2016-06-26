package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class VerkaufsFensterWerkzeug extends ObservableSubwerkzeug
{
    private VerkaufsFensterUI _ui;
    private VerkaufsFensterService _verkaufsFensterService;

    public VerkaufsFensterWerkzeug()
    {
        _ui = new VerkaufsFensterUI();
        _verkaufsFensterService = new VerkaufsFensterService();
        registriereUIAktionen();
    }

    public void aktiviere()
    {
        _ui.aktiviere();
        _verkaufsFensterService.reset();
    }

    public void aktualisierePreis(int preis)
    {
        _ui.setPreis("Preis: " + preis + " Eurocent");
        _verkaufsFensterService.setPreis(preis);
        aktualisiereRueckgeld();
    }
    
    /**
     * Beendet die Anwendung.
     */
    public void reagiereAufBeendenButton()
    {
        _ui.schliesseFenster();
    }

    private void aktualisiereErhaltenenBetrag()
    {
        aktualisiereRueckgeld();
        _ui.setErhaltenenBetrag(
                _verkaufsFensterService.getErhaltenerBetrag() + " Eurocent");
    }
    
    private void blockOKButton()
    {
        _ui.getOKButton().setEnabled(_verkaufsFensterService.istBetragAkzeptabel());
    }
    
    private void aktualisiereRueckgeld()
    {
        if (_verkaufsFensterService.istBetragAkzeptabel())
        {
            _ui.setRueckgeld(
                    "Rueckgeld: " + _verkaufsFensterService.berechneRueckgeld()
                            + " Eurocent");
        }
        else
        {
            _ui.setRueckgeld("Restbetrag: "
                    + -1 * _verkaufsFensterService.berechneRueckgeld()
                    + " Eurocent");
        }
        blockOKButton();
    }

    private void deaktiviere()
    {
        _ui.deaktiviere();
        _verkaufsFensterService.reset();
        aktualisiereErhaltenenBetrag();
    }

    /*
    private void beendeTransaktion()
    {
        if (_verkaufsFensterService.istBetragAkzeptabel())
        {
            informiereUeberAenderung();
            deaktiviere();
        }
        else
        {
            _ui.fehlermeldung();
        }
    }
    **/
    
    private void registriereUIAktionen()
    {
        _ui.getOKButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    //beendeTransaktion();
                    informiereUeberAenderung();
                    deaktiviere();
                }
            });

        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    deaktiviere();
                }
            });

        _ui.getZiffernButton(0)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(7);
                    aktualisiereErhaltenenBetrag();

                }
            });

        _ui.getZiffernButton(1)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(8);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(2)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(9);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(3)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(4);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(4)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(5);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(5)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(6);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(6)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(1);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(7)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(2);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(8)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(3);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(9)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.reset();
                    aktualisiereErhaltenenBetrag(); //Reset
                }
            });

        _ui.getZiffernButton(10)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.add(0);
                    aktualisiereErhaltenenBetrag();
                }
            });

        _ui.getZiffernButton(11)
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _verkaufsFensterService.loeschen();
                    aktualisiereErhaltenenBetrag(); //Löschen
                }
            });

    }
}
