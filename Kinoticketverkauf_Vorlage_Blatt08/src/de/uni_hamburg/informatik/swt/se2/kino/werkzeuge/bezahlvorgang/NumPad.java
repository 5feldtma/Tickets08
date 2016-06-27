package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumPad extends JPanel
{

    private ActionHandler actionHandler;
    private String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8",
            "9", ",", "0", "<--"};
    private JTextField _eingabefeld;

    /**
     * Initialisiert ein neues Numpad.
     */
    public NumPad(JTextField eingabefeld)
    {
        setLayout(new GridLayout(4, 3));
        actionHandler = new ActionHandler();
        //füllt das Grid mit Buttons
        for (int index = 0; index < 12; index++)
        {
            add(createButton(index));
        }
        _eingabefeld = eingabefeld;
    }

    /**
     * Erstellt die NumPad Buttons mit entsprechender Beschriftung.
     * @param index
     * @return ein unfokussierbarer, beschrifteter Button mit Actionlistener
     */
    protected JButton createButton(int index)
    {
        JButton btn = new JButton(buttonLabels[index]);
        //Buttons unfocusable damit man immer in der Preiseingabe bleibt
        btn.setFocusable(false);
        btn.addActionListener(actionHandler);
        btn.setSize(50, 50);
        return btn;
    }

    /**
     * Erzeugt Input im Textfeld durch die gedrückten Buttons.
     */
    public class ActionHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
            if (source instanceof JButton)
            {
                JButton btn = (JButton) source;
                //sucht sich das "einzige Textfeld", bzw. das "Standardtextfeld" des Fensters
                JTextField tf = _eingabefeld;

                String currentText = tf.getText()
                    .trim();
                String newText = "";
                String label = btn.getText()
                    .trim();

                if (label == "<--") //rücktaste
                {
                    newText = removeLastChar(currentText);
                    tf.setText(newText);
                    return;
                }

                if (currentText.length() < 8)
                {
                    if (label == ",") //komma gedrückt
                    {
                        newText = currentText + ',';
                    }
                    else //Zahl gedrückt
                    {
                        int value = Integer.parseInt(label);
                        newText = currentText + value;
                    }
                    tf.setText(newText);
                    return;
                }

            }
        }

    }

    /**
     * Entfernt den letzten Char eines Strings.
     * @param s der zu kürzende String
     * 
     * @return Ein String, dessen letzter Char entfernt wurde. Mindestens ein leerer String.
     */
    private String removeLastChar(String s)
    {
        if (s == null || s.length() == 0)
        {
            return "";
        }
        return s.substring(0, s.length() - 1);
    }
}
