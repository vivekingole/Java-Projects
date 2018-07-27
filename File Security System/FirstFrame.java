// frist frame

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
class FirstFrame extends JFrame implements ActionListener
{

TextField username;
TextField password;
JLabel unamel,title;
JLabel pwordl;
JButton submit;
JButton cancel;
JPanel p;
JPanel p1;
JPanel p2;
JPanel p3;
JPanel titlep;
Container c;
//JLabel img=new JLabel(new ImageIcon("bg1.jpg"));
static FileInputStream fis;
static FileOutputStream fos;
static Scanner s;
static DataOutputStream dos;
static String user,pass;
FirstFrame(String s1)
{
    
    super(s1);
    p = new JPanel();
    titlep= new JPanel();    
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    c=getContentPane();
    setDefaultCloseOperation(2);
   setBounds(300,100,500,740);
    unamel = new JLabel("Username:", 0);
    pwordl = new JLabel("Password:", 0);
    title= new JLabel("File security system");
    title.setFont(new Font("Sans", 3, 40));
    unamel.setFont(new Font("Sans", 1, 15));
    pwordl.setFont(new Font("Sans", 1, 15));
    username = new TextField(10);
    password = new TextField(10);
    password.setEchoChar('*');
    submit = new JButton("Submit");
    cancel = new JButton("Cancel");
    submit.setBackground(new Color(130, 200, 220));
    cancel.setBackground(new Color(130, 200, 220));
  
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    titlep.setBackground(new Color(245,199,240));
    p1.setBackground(new Color(245,199,240));
    p2.setBackground(new Color(245,199,240));
    p3.setBackground(new Color(245,199,240)); 
    
    p.setLayout(new GridLayout(4, 1));
    titlep.add(title);
    p1.add(unamel);
    p1.add(username);
    p2.add(pwordl);
    p2.add(password);
    p3.add(submit);
    p3.add(cancel);
    p.add(titlep);
    p.add(p1);
    p.add(p2);
    p.add(p3);
    c.add(p);
    username.addActionListener(this);
    password.addActionListener(this);
    cancel.addActionListener(this);
    submit.addActionListener(this);
      
}

public void actionPerformed(ActionEvent actionevent)
{
    String s = actionevent.getActionCommand();
    String s1 = username.getText();
    String s2 = password.getText();
    if(s.equals("Submit"))
    {
        if(s1.equals(user) && s2.equals(pass))
        {
            setVisible(false);
           MainFrame mainframe = new MainFrame("File Security System");
         
        }
         else 
        {           
            JOptionPane.showMessageDialog(this, "Unauthorised User", "Message", 3);
        } 
      
    }
     else if(s.equals("Cancel"))
          setVisible(false);
}
 public static void main(String args[])
{
	// call to next frame main frame
    FirstFrame firstframe = new FirstFrame("File Security System");
    firstframe.setVisible(true);
   try{
         fis=new FileInputStream("login.txt");
         s=new Scanner(fis);
         user=s.next();
         pass=s.next();
     }catch(Exception e){
         user=JOptionPane.showInputDialog(firstframe, "Set user name :-", "set name",3);
         pass=JOptionPane.showInputDialog(firstframe, "Set password :-", "set password",3);
         try{
             fos=new FileOutputStream("login.txt");
             dos=new DataOutputStream(fos);
             dos.writeBytes(user+" ");
             dos.writeBytes(pass);
             dos.close();
             fos.close();
         }catch(Exception ex){}
      }
  
    
}

}