import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
class decrypt extends JFrame implements ActionListener
{
    JLabel title=new JLabel("<html><h1>Decryption</h1>");
    JLabel select=new JLabel("Select File :-  ");
    JButton open=new JButton("Open");
    JTextField tf=new JTextField(20);    
    JPanel p1=new JPanel();
    JButton dec=new JButton("Decrypt");
    JPanel p2=new JPanel();
    JTextArea content=new JTextArea(500,500);
    JScrollPane sp=new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JPanel p3=new JPanel();
    JPanel p5=new JPanel();
    JPanel p6=new JPanel();
    JButton save=new JButton("Save");
    FileDialog fd=new FileDialog(this,"open",0);
    FileDialog fd1;
    DataOutputStream dos;
    FileInputStream fis;
    FileOutputStream fos;
    String decstr="null";
    decrypt()
    {
       
        setTitle("Decrypt");
        setDefaultCloseOperation(1);
        setVisible(true);
        setBounds(300,100,500,740);
        setLayout(null);
        p1.setBounds(1, 1, 500, 100);
        p2.setBounds(1, 100, 500, 100);
        p3.setBounds(1, 200, 500, 100);
        p5.setBounds(1, 300, 500, 100);
        p6.setBounds(1, 660, 500,50);
        sp.setBounds(1, 400,480,260);////scrollpane
       p1.setBackground(new Color(245,199,240));
       p2.setBackground(new Color(245,199,240));
       p3.setBackground(new Color(245,199,240));
       p5.setBackground(new Color(245,199,240));
       p6.setBackground(new Color(245,199,240));
       p1.add(title);
       p2.add(select);
       p2.add(open);
       p2.add(tf);
       p3.add(dec);
       p5.add(new JLabel("<html><h1>File Content :-</h1>"));
       p6.add(save);
       add(p1);
       add(p2);
       add(p3);
       add(p5);//file content
       add(sp);//content
       add(p6);
       open.addActionListener(this);
       dec.addActionListener(this);
       save.addActionListener(this);
       
    }
    
    public void actionPerformed(ActionEvent e){
        String s="",t="",file="",pass="",savefile="";
      Object o=e.getSource();
      if(o==open)
      {
       fd.setVisible(true);
       tf.setText(fd.getDirectory()+fd.getFile());
       try{
        fis=new FileInputStream((file=tf.getText()));
        Scanner sc=new Scanner(fis);
        content.setText("");
        for(int i=0;(s=sc.nextLine())!=null;i++)
        {
            content.append(s+" ");
       
                content.append("\n");
        }   
       }catch(Exception eds){}
      }
      else if(o==dec)
      {
          if(t.equals(content.getText()))
              JOptionPane.showMessageDialog(this,"please select file","error",2);
          else
          {
             
              // file=JOptionPane.showInputDialog(this, "enter file name to save encrypted data :-","save file",1);
              try{
              decstr=decrypt();
              }catch(Exception das){}
          }          
      }
      else if(o==save)
      {
         fd1=new FileDialog(this,"save",1);
              fd1.setVisible(true);
              savefile=fd1.getDirectory()+fd1.getFile();
              try{
           fos=new FileOutputStream(savefile);
           dos=new DataOutputStream(fos);
           dos.writeBytes(decstr);
           dos.close();
          fos.close();
          JOptionPane.showMessageDialog(this, "File saved !","saved",1);
          this.dispose();
              }catch(Exception ex){ }
      }
    }//action
    public String decrypt()
   {
       String s="",pass="",pass1="";
       int t=0,i=0;
       try{
       FileInputStream fis=new FileInputStream(tf.getText());
       
       Scanner sc=new Scanner(fis);
       pass=sc.next();
        pass1=JOptionPane.showInputDialog(this, "enter password :-","confirm password",1);
        if(pass1.equals(pass))
        {    
            JOptionPane.showMessageDialog(this, "Correct password !","correct",1);
            content.setText("");
       int n=sc.nextInt();
       n=n/222;
       char a[]=new char[n+1];
       for(i=0;i<n;i++)
       {
          t=sc.nextInt();
          t=t/100000;
          a[i]=(char)(t-1);
          s=s+a[i];
       }    
       fis.close();
       
       content.setText(s);
       return s;
        }
        
        else 
        {
          JOptionPane.showMessageDialog(this, "Incorrect password !","incorrect",0);
            return "null";
        }
        }catch(Exception ex){JOptionPane.showMessageDialog(this, "file opening error !","correct",1);}
       return "nul";
   }  
   
 public static void main(String []as)
 {
 	new decrypt();
 }
}