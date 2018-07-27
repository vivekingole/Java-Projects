import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class adminpage extends JFrame implements ActionListener{
       JLabel title=new JLabel("Lifestyle hotel");
    JButton room=new JButton("Room");
    JButton dish=new JButton("Dish");
    JButton roombill=new JButton("Room bills");
    JButton foodbill=new JButton("Food bills");
    JButton back=new JButton("Back");
    JPanel p1=new JPanel();
    
    adminpage(String s1)
    {
        super(s1);
        setBounds(1, 1, 1000, 800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        title.setBounds(300,60, 700,50);
        
        room.setFont(new Font("MV Boli",3,40));
        dish.setFont(new Font("MV Boli",3,40));
        roombill.setFont(new Font("MV Boli",3,40));
        foodbill.setFont(new Font("MV Boli",3,40));
        back.setFont(new Font("MV Boli",3,40));
        
        p1.setBounds(200,200,600,400);        
        p1.setLayout(new GridLayout(3, 2, 10, 10));
        p1.add(room);
        p1.add(dish);
        p1.add(roombill);
        p1.add(foodbill);
        p1.add(back);       
        add(title);
        add(p1);
        roombill.addActionListener(this);
        foodbill.addActionListener(this);
        back.addActionListener(this);
        room.addActionListener(this);
        dish.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object o=ae.getSource();
        if(o==roombill)
            new roombills("room bill");
        else if(o==foodbill)
            new foodbills("food bill");
        else if(o==back)
            this.dispose();
        else if(o==room)
             new editroom("edit room");
        else if(o==dish)
             new editfood("edit food");
    }
   public static void main(String args[])
   {
       new adminpage("admin");
   }
}
