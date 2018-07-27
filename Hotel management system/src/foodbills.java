import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class foodbills extends JFrame implements ActionListener{
    static foodbills h1;
    static FileInputStream fis;
    static Scanner sc;
    FileOutputStream fos;
    DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JButton b[]=new JButton[100];
    String list[]=new String[100];
    String name[]=new String[100];
    String phone[]=new String[100];
    String price[]=new String[100];
    String foods[]=new String[100];
    int listi=0,idx=0;
    JPanel p=new JPanel();
    foodbills(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("MV Boli",3,50));//"Arial Rounded BT Bold",3,50));        
        title.setBounds(250,30,700,50);
        p.setBounds(10,100,970,660);
        p.setBackground(Color.red);
        p.setLayout(new GridLayout(5,5,5,5));
        add(title);
        add(p);
        getData();
    }
    public void getData()
    {
        int i=0,f=0;
        String t="";
        try{            
            fis=new FileInputStream(".\\records\\food\\foodrec.txt");
            sc=new Scanner(fis);
            while((t=sc.next())!=null)
            {
                t+=" "+sc.next();
                list[listi++]=t;
                b[i]=new JButton(t);
                b[i].addActionListener(this);
                p.add(b[i++]);               
            }
        }catch(Exception e){}
        for(i=0;i<listi;i++)
        {
           f=0;            
         try{                         
            fis=new FileInputStream(".\\records\\food\\"+list[i]+".txt");
            sc=new Scanner(fis);
            while((t=sc.next())!=null)
            {
               if(f==0)
		{
		  f=1;
                t+=" "+sc.next();
                name[i]=t;
                phone[i]=sc.next();
                price[i]=sc.next();
                sc.nextLine();		
		}
		else
		    foods[i]+="\n"+(t+sc.nextLine());
            }            
        }catch(Exception e){System.out.println(e);}
      }//for loop
        
    }
    public void actionPerformed(ActionEvent e) {
        int i=0,yn=0,j=0;
        l:for(i=0;i<listi;i++)
        {
            if(e.getSource()==b[i]) 
                break l;
        }
        yn=JOptionPane.showConfirmDialog(this,"Name :- "+name[i]+"\n\nPhone :- "+phone[i]
                +"\n\ntotal bill :- "+price[i]+"\n\nFood :- "+foods[i]
                +"\n\nDo you want to pay bill ?\n\n");
        if(yn==0)
        {
              JOptionPane.showMessageDialog(this,"Bill paid");
              try{
              fos=new FileOutputStream(".\\records\\food\\foodrec.txt");            
              dos=new DataOutputStream(fos);           
               for(j=0;j<listi;j++)
               {
                   if(j!=i)
                       dos.writeBytes(name[j]+" ");
               }
              }catch(Exception ex){}     
              this.dispose();
              new foodbills("hotel management system");            
        }
    }
    public static void main(String[] args) {
        h1=new foodbills("hotel management system");            
    }
    
}
