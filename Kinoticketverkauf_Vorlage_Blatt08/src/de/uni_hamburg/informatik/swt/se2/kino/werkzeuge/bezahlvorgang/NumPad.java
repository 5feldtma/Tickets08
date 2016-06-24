package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlvorgang;

import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumPad extends JPanel {

		private ActionHandler actionHandler;
        private String[] buttonLabels = {"1","2","3","4","5","6","7","8","9",",","0","<--"};

        public NumPad() {
            setLayout(new GridLayout(4, 3));
            actionHandler = new ActionHandler();
            //füllt das Grid mit Buttons
            for (int index = 0; index < 12; index++) {
                add(createButton(index));
            }
        }

        //macht neue Buttons direkt inklusive Actionlistener
        protected JButton createButton(int index) {
            JButton btn = new JButton(buttonLabels[index]);
            //Buttons unfocusable damit man immer in der Preiseingabe bleibt
            btn.setFocusable(false);
            btn.addActionListener(actionHandler);
            return btn;
        }

        public class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
            	Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton btn = (JButton) source;
                    //sucht sich das "einzige Textfeld", bzw. das "Standardtextfeld" des Fensters
                    JTextField tf = (JTextField) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

                    	String label = btn.getText().trim();
                    	if (label == ",")
                    	{
                    		tf.setText(tf.getText() + ',');
                    	}
                    	else if (label == "<--") //rücktaste
                    	{
                    		{
                    			String currentText = tf.getText().trim();
                    			String shortenedText = currentText.substring(0, Math.max(0, currentText.length()-1));
                    			tf.setText(shortenedText);
                    		}
                    	}
                    	else
                    	{
                    		int value = Integer.parseInt(label);
                    		tf.setText(tf.getText() + value);
                    	}
                }  
            }

        }
}
