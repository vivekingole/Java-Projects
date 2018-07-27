import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class home extends JFrame implements ActionListener{
    static home h1;
    static FileInputStream fis;
    static Scanner sc;
    static FileOutputStream fos;
    static DataOutputStream dos;
    JLabel title=new JLabel("Welcome in Lifestyle hotel");
    JButton admin=new JButton("Administrator");
    JButton customer=new JButton("Customer");    
     customerpage cp;
     static gallery g;
    home(String str1)
    {
        super(str1);               
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(3);
        setLayout(null);        
        setVisible(true);
        customerpage.g=new gallery("hotel management system");
         customerpage.g.setVisible(false);
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        admin.setFont(new Font("Arial Rounded BT Bold",3,30));
        customer.setFont(new Font("Arial Rounded BT Bold",3,30));
        
        title.setBounds(200,60, 700,50);
        admin.setBounds(350, 300, 300, 100);
        customer.setBounds(350, 500, 300, 100);
        
        add(title);
        add(admin);
        add(customer);
        
        admin.addActionListener(this);
        customer.addActionListener(this);        
        customerpage.g.start();
    }
    public void actionPerformed(ActionEvent e) {
         JButton bt=(JButton)e.getSource();
        if(bt==admin)
        {
            new login("login");
        }
        else if(bt==customer)
        { 
            cp=new customerpage("customer");                   
        }
            
    }
    public static void main(String[] args) {                       
        try{
           new FileInputStream("login.txt");                                    
        }catch(Exception ex){
           
            ///////////////////create login file///////////////////
            String id="",pass="";
            id=JOptionPane.showInputDialog("enter administrator user id");
            pass=JOptionPane.showInputDialog("enter administrator pssword");
            try{
                fos=new FileOutputStream("login.txt");
                dos=new DataOutputStream(fos);           
                dos.writeBytes(id+" ");
                dos.writeBytes(pass);
            }catch(Exception ex1){}                        
            //////////////////////// create editroom file///////////////////
            try{            
            fos=new FileOutputStream("editroom.txt");
            dos=new DataOutputStream(fos);
            dos.writeBytes("10 ");
            dos.writeBytes("1000 ");
            dos.writeBytes("10 ");
            dos.writeBytes("800");            
            }catch(Exception e){}
           //////////////////////create available room file/////////////////////            
           try{            
            fos=new FileOutputStream("availableroom.txt");
            dos=new DataOutputStream(fos);
            dos.writeBytes("10 10");
            }catch(Exception e){}
           //////////////////////create editdish file ////////////////////////////
           try{            
            fos=new FileOutputStream("editdish.txt");
            dos=new DataOutputStream(fos);
            dos.writeBytes("Pav-Bhaji (veg) 20 \n");
            }catch(Exception e){}
        }
      h1=new home("hotel management system");      
    }
}
