package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VerkaufsFensterUI
{
    private JFrame _frame;
    
    public VerkaufsFensterUI()
    {
        _frame = new JFrame("VerkaufsFenster");
        _frame.setLayout(new FlowLayout());
        _frame.add(new JPanel());
        _frame.add(new TastaturPanel());
        _frame.setVisible(true);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
