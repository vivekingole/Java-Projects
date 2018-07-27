import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class customerpage extends JFrame implements ActionListener{
    JLabel title=new JLabel("Lifestyle hotel");
    JButton room=new JButton("Room");
    JButton dish=new JButton("Dish");
    JButton galleryb=new JButton("Gallery");
    JButton map=new JButton("Map");
    JButton back=new JButton("Back");
    JButton details=new JButton("Details");
    JPanel p1=new JPanel();
    FileOutputStream fos;
    DataOutputStream dos;    
    static gallery g;
    customerpage(String s1)
    {
        super(s1);
        setBounds(1, 1, 1000, 800);
        setDefaultCloseOperation(3);
        setLayout(null);        
        setVisible(true);
         //g=new gallery("hotel management system");
         //g.setVisible(false);
         
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        room.setFont(new Font("MV Boli",3,40));
        dish.setFont(new Font("MV Boli",3,40));
        galleryb.setFont(new Font("MV Boli",3,40));
        map.setFont(new Font("MV Boli",3,40));
        details.setFont(new Font("MV Boli",3,40));
        back.setFont(new Font("MV Boli",3,40));
        
        title.setBounds(300,60, 700,50);
        p1.setBounds(200,200,600,400);
        
        p1.setLayout(new GridLayout(3, 2, 10, 10));
        p1.add(room);
        p1.add(dish);
        p1.add(galleryb);
        p1.add(map);
        p1.add(details);
        p1.add(back);
        add(p1);        
        add(title);
        
        room.addActionListener(this);
        dish.addActionListener(this);
        galleryb.addActionListener(this);
        map.addActionListener(this);
        details.addActionListener(this);
        back.addActionListener(this);        
        //g.start();
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object o=ae.getSource();
        if(o==back)
           this.setVisible(false);//this.dispose();
        else if(o==room)
        {
            new rooms("room registration");          
        }
        else if(o==dish)
        {
            try {   
                new dishes("dish");
            } catch (Exception ex) {
            }
        }
        else if(o==galleryb)
        {         
         gallery.i=0;
         g.setVisible(true); 
        }
        else if(o==map)
        {
            JFrame mapf=new JFrame("map");
            mapf.setBounds(0,0,1000,700);
            mapf.setVisible(true);
            mapf.setDefaultCloseOperation(1);
            JLabel image=new JLabel(new ImageIcon(".\\img\\12.png"));
            mapf.add(image);
        }
        else if(o==details)
        {
            JOptionPane.showMessageDialog(this,"lifestyle hotel");
        }
        
    }
   public static void main(String args[])
   {
       new customerpage("customer");
     
   }   
}
