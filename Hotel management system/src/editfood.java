import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class editfood extends JFrame implements ActionListener{
    static editfood h1;
    static FileInputStream fis;
    static Scanner sc;
    FileOutputStream fos;
    DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JPanel p=new JPanel();
    JButton remove=new JButton("Remove");
    JButton edit=new JButton("Edit");
    JButton add=new JButton("Add");
    JButton b[]=new JButton[100];
    int n=0,id=0;
    int price[]=new int[100];
    String addfood,select;
    editfood(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("MV Boli",3,50));
        p.setLayout(new GridLayout(10,10,5,5));
        p.setBackground(Color.red);
        remove.setFont(new Font("MV Boli",3,30));
        edit.setFont(new Font("MV Boli",3,30));
        add.setFont(new Font("MV Boli",3,30));
        
        title.setBounds(250,30,700,50);
        add.setBounds(400,630,200,70);
        edit.setBounds(100,630,200,70);
        remove.setBounds(700,630,200,70);
        p.setBounds(1,100,1000,500);
        
        getData();        
        add(title); 
        add(p);
        add(edit);
        add(remove);
        add(add);                
        remove.addActionListener(this);
        add.addActionListener(this);
        edit.addActionListener(this);
    }
    public void getData()
    {
        String t="";
        try{            
            fis=new FileInputStream("editdish.txt");
            sc=new Scanner(fis);
           while((t=sc.next())!=null)
           {
               t+=" "+sc.next();               
               price[id]=sc.nextInt();
               t+="   "+price[id];
               b[id]=new JButton(t);
               b[id].addActionListener(this);
               p.add(b[id++]);
           }
           
        }catch(Exception e){}
        
    }
    public void remove(String str)
    {
        try{            
            fos=new FileOutputStream("editdish.txt");
            dos=new DataOutputStream(fos);
            for(int i=0;i<id;i++)
            {
                if(b[i].getText()!=str)
                    dos.writeBytes(b[i].getText()+" \n");
            }
               }catch(Exception e){}        
        this.dispose();
        h1=new editfood("hotel management system");            
        JOptionPane.showMessageDialog(this, "Succesfully removed !");
    }
    public void edit(String str)
    {
        String t="";
        t=JOptionPane.showInputDialog(this,"edit dish " ,str);
        if(t!=null)
        {
        try{            
            fos=new FileOutputStream("editdish.txt");
            dos=new DataOutputStream(fos);
            for(int i=0;i<id;i++)
            {
                if(b[i].getText()!=str)
                    dos.writeBytes(b[i].getText()+" \n");
                else
                    dos.writeBytes(t+" \n");
            }
               }catch(Exception e){}        
        this.dispose();
        h1=new editfood("hotel management system");            
        JOptionPane.showMessageDialog(this, "Succesfully edited !");
        }        
    }
     public void add()
    {
        try{            
            fos=new FileOutputStream("editdish.txt",true);
            dos=new DataOutputStream(fos);
             dos.writeBytes(addfood);
               }catch(Exception e){}
        this.dispose();
        h1=new editfood("hotel management system");            
        JOptionPane.showMessageDialog(this, "Updation succesful !");        
    }
  
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==add)
        {          
            addfood="\n"+JOptionPane.showInputDialog("Enter Dish name and price");
            add();
        }
        else if(o==remove)
        {
           remove(select);   
        }
        else if(o==edit)
        {
            edit(select);
        }
        else
        {
           JButton b=(JButton)o;
           select=b.getText();
           b.setBackground(Color.GREEN);
        }
    }
    public static void main(String[] args) {
        h1=new editfood("hotel management system");            
    }
    
}
