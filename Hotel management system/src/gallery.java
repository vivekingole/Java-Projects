import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class gallery extends JFrame{
    static gallery h1;
    static FileInputStream fis;
    static Scanner sc;
    static JLabel title=new JLabel("Lifestyle Gallery");
      JLabel image=new JLabel();
      JLabel image1=new JLabel();      
    static JButton s=new JButton("< Back");
    static int x1=300,x2=960,i=1;
    gallery(String str1)
    {        
        super(str1);
        
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(3);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("MV Boli",3,50));//"Arial Rounded BT Bold",3,50));
        
        title.setBounds(250,30,700,50);
        image.setBounds(x1,100,650,700);
        image1.setBounds(x2,100,650,700);
        s.setBounds(10, 10, 100, 50);
        add(title);
        add(image);
        add(image1);
        add(s);
        s.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
            }
        });
        //start();
    }
    public void start()
    {
        try{
        for(i=1;;i++)
        {
            if(i==12) i=1;                        
            image.setIcon(new ImageIcon(".\\img\\"+i+".jpg"));
            image1.setIcon(new ImageIcon(".\\img\\"+(i+1)+".jpg"));               
            for(x1=300,x2=960;x2>=300;x1-=2,x2-=2)
            {
                image.setBounds(x1,100,650,700);
                image1.setBounds(x2,100,650,700);
               try{
                    Thread.sleep(10);
                    }catch(Exception ex){}               
            }
            
        }
        }catch(Exception ex){ }         
    }
    public static void main(String[] args) {
        h1=new gallery("hotel management system");            
    }

}
