// Source File Name:  frist frame

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MainFrame extends JFrame implements ActionListener
{
 JLabel l3;
JButton sender;
JButton receiver;
JButton exit;
Container c;
JPanel p;
JPanel p1;
JPanel p2;
JPanel p3;
JPanel p4;
JPanel p5;

MainFrame(String s)
{
    super(s);
    c = getContentPane();
    p = new JPanel();
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5=new JPanel();
    p1.setBackground(new Color(245,199,240));
    p2.setBackground(new Color(245,199,240));
    p3.setBackground(new Color(245,199,240));
    p4.setBackground(new Color(245,199,240));
    p5.setBackground(new Color(245,199,240)); 
    setDefaultCloseOperation(1);
 setBounds(300,100,500,740);
    sender = new JButton("Sender");
    receiver = new JButton("Receiver");
    exit = new JButton("Exit");
    sender.setBackground(new Color(130, 200, 220));
    receiver.setBackground(new Color(130, 200, 220));
    exit.setBackground(new Color(130, 200, 220));
    p1.setLayout(new FlowLayout(1));
    p2.setLayout(new FlowLayout(1));
    p3.setLayout(new FlowLayout(1));
    p4.setLayout(new FlowLayout(1));
   
    l3 = new JLabel("File security system");
    l3.setFont(new Font("Sans", 3, 40));
    p1.add(l3);
    p2.add(sender);
    p3.add(receiver);
    p4.add(exit);
    
    p.setLayout(new GridLayout(5, 1));
    p.add(p1);
    p.add(p2);
    p.add(p3);
    p.add(p4);
    p.add(p5);
     c.add(p);
    show();
    sender.addActionListener(this);
    receiver.addActionListener(this);
    exit.addActionListener(this);
}

public void actionPerformed(ActionEvent actionevent)
{
    String s = actionevent.getActionCommand();
    if(s.equals("Sender"))
    {	
     new encrypt();
   //  RsaFrame rsaframe = new RsaFrame("RSA algorithm","sender",30,false);
       }
      else if(s.equals("Receiver"))
      {
          new decrypt();
         // RsaFrame rsaframe = new RsaFrame("RSA algorithm","receiver",30,false);
      }      else if(s.equals("Exit"))
        setVisible(false);
}

}