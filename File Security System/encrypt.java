import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
class encrypt extends JFrame implements ActionListener
{
    JLabel title=new JLabel("<html><h1>Encryption</h1>");
    JLabel select=new JLabel("Select File :-  ");
    JButton open=new JButton("Open");
    JTextField tf=new JTextField(20);    
    JPanel p1=new JPanel();
    JButton enc=new JButton("Encrypt");
    JPanel p2=new JPanel();
    JTextArea content=new JTextArea(500,500);
    JScrollPane sp=new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JPanel p3=new JPanel();
    JPanel p5=new JPanel();
    FileDialog fd=new FileDialog(this,"open",0);
    DataOutputStream dos;
    FileInputStream fis;
    FileOutputStream fos;
    Container c;
    encrypt()
    {   c=this.getContentPane();
        setTitle("encrypt");
        setDefaultCloseOperation(1);
        setVisible(true);
        setBounds(300,100,520,740);
        setLayout(null);
        p1.setBounds(1, 1, 500, 100);
        p2.setBounds(1, 100, 500, 100);
        p3.setBounds(1, 200, 500, 100);
        p5.setBounds(1, 300, 500, 100);
       
       p1.setBackground(new Color(245,199,240));
       p2.setBackground(new Color(245,199,240));
       p3.setBackground(new Color(245,199,240));
       p5.setBackground(new Color(245,199,240));
       sp.setBounds(1,400,500,300);       
       
       p1.add(title);
       p2.add(select);
       p2.add(open);
       p2.add(tf);
       p3.add(enc);
       p5.add(new JLabel("<html><h1>File Content :-</h1>"));
       add(p1);
       add(p2);
       add(p3);
       add(sp);
       add(p5);
       open.addActionListener(this);
       enc.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        String s="",t="",file="",pass="";
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
      else if(o==enc)
      {
          if(t.equals(content.getText()))
              JOptionPane.showMessageDialog(this,"please select file or enter data","error",2);
          else
          {
              pass=JOptionPane.showInputDialog(this, "enter password :-","set password",1);
              file=JOptionPane.showInputDialog(this, "enter file name to save encrypted data :-","save file",1);
              try{
              encrypt(content.getText(),pass,file+".txt");
              JOptionPane.showMessageDialog(this,"File saved","saved",1);
              this.dispose();
              }catch(Exception das){}
          }          
      }
    }//action
     public void encrypt(String s,String pass,String file)throws FileNotFoundException,IOException
   {
       String s1="";
       FileOutputStream fos=new FileOutputStream(file);
       DataOutputStream dos=new DataOutputStream(fos);
       dos.writeBytes(pass+" "+(s.length()*222)+" ");
       for(int i=0;i<s.length();i++)
    {
      s1=s1+("00000"+(s.codePointAt(i)+1)+"98745 ");
    }
     dos.writeBytes(s1);
     dos.close();
     fos.close();
   }
  public static void main(String []asa)
  {
      new encrypt();
  }
}