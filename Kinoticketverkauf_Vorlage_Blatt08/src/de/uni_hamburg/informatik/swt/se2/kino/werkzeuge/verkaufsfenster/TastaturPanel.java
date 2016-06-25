package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TastaturPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private String[] txt = {"7", "8", "9", "4", "5", "6", "1", "2", "3",
            "Reset", "0", "Löschen"};
    private JButton[] _buttonArray = new JButton[12];

    public TastaturPanel()
    {
        setSize(1520, 1350);

        setLayout(new GridLayout(4,3));

        for(int i = 0; i < _buttonArray.length; i++ ) {
            _buttonArray[i] = new JButton(txt[i]);
            add(_buttonArray[i]);
          }
        
        setVisible(true);
    }

    public JButton getButton(int index)
    {
        return _buttonArray[index];
    }
}