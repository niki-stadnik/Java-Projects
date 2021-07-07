package EmailSMTP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Gui{
    JTextArea ta;
    JTextField sb,to;
    JLabel ls,lt;
    JButton send;
    Panel p= new Panel();
    Gui(JFrame f){
        ta = new JTextArea(10,20);
        send = new JButton("send");
        to = new JTextField("",20);
        lt= new JLabel("To:");
        sb = new JTextField("",20);
        ls = new JLabel("Subject:");
        send.addActionListener(new S());
        p.add(lt);
        p.add(to);
        p.add(ls);
        p.add(sb);
        f.add(p,BorderLayout.NORTH);
        f.add(ta, BorderLayout.CENTER);
        f.add(send, BorderLayout.SOUTH);
        MailSend.init();
    }
    class S implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String message[]= {to.getText(),sb.getText(),ta.getText()};
            MailSend.putData(message);
            MailSend.send();
        }
    }

    public static void main(String args[]){
        JFrame frame =new JFrame("Mail Sender");
        Gui gui = new Gui(frame);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
