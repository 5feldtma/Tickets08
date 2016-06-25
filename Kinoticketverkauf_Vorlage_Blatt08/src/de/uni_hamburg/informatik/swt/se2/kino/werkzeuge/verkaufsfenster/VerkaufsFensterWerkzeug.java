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

    public void aktiviere(int preis)
    {
        aktualisierePreis(preis);
        _ui.aktiviere();
    }
    
    public void aktualisierePreis(int preis)
    {
        _ui.aktualisierePreis(preis);
        _verkaufsFensterService.setPreis(preis);
        _ui.aktualisiereRueckgeld(_verkaufsFensterService.berechneRueckgeld());
    }
    
    private void aktualisiereErhaltenenBetrag()
    {
        _ui.aktualisiereRueckgeld(_verkaufsFensterService.berechneRueckgeld());
        _ui.aktualisiereErhaltenenBetrag(_verkaufsFensterService.getErhaltenerBetrag());
    }
    
    private void deaktiviere()
    {
        _ui.deaktiviere();
        _verkaufsFensterService.reset();
        aktualisiereErhaltenenBetrag();
    }
    
    private void beendeTransaktion()
    {
        if(_verkaufsFensterService.istBetragAkzeptabel())
        {
            informiereUeberAenderung();
            deaktiviere();
        }
        else
        {
            _ui.fehlermeldung();
        }
    }
    
    private void registriereUIAktionen()
    {
        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                beendeTransaktion();
            }
        });

        _ui.getAbbrechenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deaktiviere();
            }
        });
        
        _ui.getZahlenButton(0).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(7);
                aktualisiereErhaltenenBetrag();
                
            }
        });
        
        _ui.getZahlenButton(1).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(8);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(2).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(9);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(3).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(4);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(4).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(5);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(5).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(6);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(6).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(1);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(7).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(2);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(8).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(3);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(9).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.reset();
                aktualisiereErhaltenenBetrag();    //Reset
            }
        });

        _ui.getZahlenButton(10).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.add(0);
                aktualisiereErhaltenenBetrag();
            }
        });

        _ui.getZahlenButton(11).addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verkaufsFensterService.loeschen();
                aktualisiereErhaltenenBetrag();     //Löschen
            }
        });
        
    }
}
