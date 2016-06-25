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
    }
    
    private void deaktiviere()
    {
        _ui.deaktiviere();
    }
    
    private void registriereUIAktionen()
    {
        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                informiereUeberAenderung();
                deaktiviere();
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
    }
}
