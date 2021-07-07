package Exceptions;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class AppletException extends Applet {
    TextField textField1;
    TextField textField2;

    public void init(){
        textField1 = new TextField(5);
        textField2 = new TextField(5);
        textField1.addActionListener(new Enter());
        textField2.addActionListener(new Enter());
        add(textField1);
        add(textField2);
        textField1.setText("0");
        textField2.setText("0");
    }

    public void paint(Graphics g){
        int value1;
        int value2;
        int sum;
        String s;

        g.drawString("Type a number in each box.", 40, 50);
        g.drawString("The sum of the values is:", 40, 75);
        try {
            s = textField1.getText();
            value1 = Integer.parseInt(s);
            s = textField2.getText();
            value2 = Integer.parseInt(s);
            sum = value1 + value2;
            s = String.valueOf(sum);
        }catch(NumberFormatException e){
            s = "Error - must be integer !!!";
        }

        g.drawString(s, 80, 100);
    }

    class Enter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

}