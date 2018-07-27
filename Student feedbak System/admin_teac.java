import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class admin_teac extends JFrame implements ActionListener{
    static admin_teac h1;
    static FileInputStream fis;
    static Scanner sc;
    FileOutputStream fos;
    DataOutputStream dos;
    JLabel title=new JLabel("Administrator");
    JPanel p=new JPanel();
    JButton remove=new JButton("Remove");
    JButton add=new JButton("Add");
    JButton b[]=new JButton[100];
    int n=0,id=0;
    String select,new_teac;
    String name[]=new String[100];
    String pass[]=new String[100];
    admin_teac(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(3);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("MV Boli",3,50));
        p.setLayout(new GridLayout(15,15,5,5));
        p.setBackground(Color.red);
        remove.setFont(new Font("MV Boli",3,30));
        add.setFont(new Font("MV Boli",3,30));
        
        title.setBounds(250,30,700,50);
        add.setBounds(100,630,200,70);
        remove.setBounds(700,630,200,70);
        p.setBounds(1,100,1000,500);
        getData();        
        add(title); 
        add(p);
        add(remove);
        add(add);                
        remove.addActionListener(this);
        add.addActionListener(this);        
    }
    public void getData()
    {
        String t="";
        try{            
            fis=new FileInputStream("teac_rec.txt");
            sc=new Scanner(fis);
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(this,"File not Found"+ex);
        }
        try
        {        
       loop:  for(int i=0;true;i++)
           {
           	 try{
           	 	while((t=sc.next())!=null)
           	 	{
           	 			name[id]=t;
           	    pass[id]=sc.next();        
            	b[id]=new JButton(name[id]);
               b[id].addActionListener(this);
               p.add(b[id]);
               id++;
           	 	}
           	 }catch(Exception ex){break loop; }
           
           }
           
        }catch(Exception e){  JOptionPane.showMessageDialog(this,e);}
        
    }
    public void remove(String str)
    {
        try{            
            fos=new FileOutputStream("teac_rec.txt");
            dos=new DataOutputStream(fos);
            for(int i=0;i<id;i++)
            {
                if(b[i].getText()!=str)
                    dos.writeBytes(name[i]+" "+pass[i]+" ");
            }
               }catch(Exception e){}        
        this.dispose();
        h1=new admin_teac("Admin teacher");            
        JOptionPane.showMessageDialog(this, "Succesfully removed !");
    }
     public void add()
    {
        try{            
            fos=new FileOutputStream("teac_rec.txt",true);
            dos=new DataOutputStream(fos);
             dos.writeBytes(new_teac);
             dos.close();
             fos.close();
               }catch(Exception e){JOptionPane.showMessageDialog(this,e);}
        this.dispose();
        h1=new admin_teac("Admin teacher");            
        JOptionPane.showMessageDialog(this, "Updation succesful !");        
    }
  
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==add)
        {          
           new_teac="\n"+JOptionPane.showInputDialog("Enter Teacher name and password");
           add();
        }
        else if(o==remove)
        {
           remove(select);   
        }
        else
        {
           JButton b=(JButton)o;
           select=b.getText();
           b.setBackground(Color.GREEN);
        }
    }
    public static void main(String[] args) {
        h1=new admin_teac("Admin");            
    }
    
}
