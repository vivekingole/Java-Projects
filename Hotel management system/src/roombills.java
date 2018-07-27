import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class roombills extends JFrame implements ActionListener{
    static roombills h1;
    static FileInputStream fis;
    static Scanner sc;
    FileOutputStream fos;
    DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JButton b[]=new JButton[100];
    String list[]=new String[100];
    String name[]=new String[100];
    String phone[]=new String[100];
    String date[]=new String[100];
    String type[]=new String[100];
    String days[]=new String[100];
    String member[]=new String[100];
    int listi=0,idx=0,aac,anac,acr,nacr;
    JPanel p=new JPanel();
    File f;
    roombills(String str1)
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
        int i=0;
        String t="";
        /////////////////////get available rooms//////////////
         try{            
            fis=new FileInputStream("availableroom.txt");
            sc=new Scanner(fis);
            aac=Integer.parseInt(sc.next());
            anac=Integer.parseInt(sc.next());           
        }catch(Exception e){}
         ////////////////////get room rates////////////////
          try{            
            fis=new FileInputStream("editroom.txt");
            sc=new Scanner(fis);
            sc.next();
            acr=Integer.parseInt(sc.next());
            sc.next();
            nacr=Integer.parseInt(sc.next());           
        }catch(Exception e){}
       
         ////////////////////get room record//////////////
        try{            
            fis=new FileInputStream(".\\records\\room\\roomrec.txt");
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
         try{                         
            fis=new FileInputStream(".\\records\\room\\"+list[i]+".txt");
            sc=new Scanner(fis);
            while((t=sc.next())!=null)
            {
                t+=" "+sc.next();
                name[i]=t;
                phone[i]=sc.next();
                date[i]=sc.next();
                type[i]=sc.next();
                days[i]=sc.next();
                member[i]=sc.next();
            }            
        }catch(Exception e){System.out.println(e);}
      }//for loop        
    }
      public void setData()
    {
        try{            
            fos=new FileOutputStream("availableroom.txt");
            dos=new DataOutputStream(fos);
            dos.writeBytes(aac+" ");
            dos.writeBytes(anac+"");           
        }catch(Exception e){}
    }
  
    public void actionPerformed(ActionEvent e) {
        int i=0,yn=0,j=0;
        l:for(i=0;i<listi;i++)
        {
            if(e.getSource()==b[i]) 
                break l;
        }
        yn=JOptionPane.showConfirmDialog(this,"Name :- "+name[i]+"\n\nPhone :- "+phone[i]
                +"\n\nDate :- "+date[i]+"\n\nRoom type :- "+type[i]
                +"\n\nTotal days :- "+days[i]+"\n\nTotal members :- "+member[i]
                +"\n\nDo you want to pay bill ?\n\n");
        if(yn==0)
        {
            new File("vivek ingole1.txt").delete();
            if(type[i].equals("AC"))
            {
                JOptionPane.showMessageDialog(this,"Your total bill is "+(acr*Integer.parseInt(days[i])*Integer.parseInt(member[i]))+" /-");
                aac++;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Your total bill is "+(nacr*Integer.parseInt(days[i])*Integer.parseInt(member[i]))+" /-");
                anac++;            
            } 
             setData();
            try{
              fos=new FileOutputStream(".\\records\\room\\roomrec.txt");            
              dos=new DataOutputStream(fos);           
               for(j=0;j<listi;j++)
               {
                   if(j!=i)
                       dos.writeBytes(name[j]+" ");
               }
               dos.close();
               fos.close();
              }catch(Exception ex){}               
              this.dispose();
              new roombills("hotel management system");     
        }
    }
    public static void main(String[] args) {
        h1=new roombills("hotel management system");            
    }    
}
