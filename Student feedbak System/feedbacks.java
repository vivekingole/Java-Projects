import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class feedbacks extends JFrame implements MouseListener {
   static feedbacks f;
   JPanel p,p1[]=new JPanel[100],t;
   static JLabel title,name[]=new JLabel[100];
   static FileInputStream fis;
   static Scanner s;
   static int n,set[]=new int[100];
   JButton logof,clear;
	 	File f1;
    feedbacks(String s1)
    {
        super(s1);
        setVisible(true);
        setBounds(1,1,1600,690);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        title=new JLabel("Feedbacks  ");        
        title.setFont(new Font("Arial Rounded MT Bold", 2,40));        
        title.setBounds(530,1,300,50);
        logof=new JButton("Log Out");
        logof.setBounds(1130,25,100,50);
        clear=new JButton("Clear");
        clear.setBounds(25,25,100,50);      
        p=new JPanel();
        p.setLayout(new GridLayout(10,1,5,5));
        this.getContentPane().setBackground(new Color(225,60,227));
        p.setBackground(new Color(225,60,227));        
        p.setBounds(1,100,1270,550);
        add(title);
         add(logof);
         add(clear);
         try{
             
            fis=new FileInputStream("fblist.txt");
               s =new Scanner(fis);
                try{
                for(n=0;s.next()!=null;n++);
                   }catch(Exception e1){ }
            fis.close();
             if(n==0)
                 JOptionPane.showMessageDialog(this, "No any Feedbacks","no feedback", 2);
            fis=new FileInputStream("fblist.txt");
             s =new Scanner(fis);
            try{
                for(int i=0;i<n;i++)
                {
                    p1[i]=new JPanel();
                    p1[i].setLayout(new BorderLayout());
                    name[i]=new JLabel(s.next(),JLabel.CENTER);
                    name[i].addMouseListener(this);
                    p1[i].add(name[i]);
                    p1[i].setBackground(new Color(104,222,118));
                    p.add(p1[i]);
                }
            }catch(Exception e){
            }
            fis.close();
        }catch(Exception e){ 
        JOptionPane.showMessageDialog(this, "File opening error");
        }
       
       logof.addMouseListener(this);
       clear.addMouseListener(this);
       add(p);
      
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==logof)
        {
            sfb.cnt=0;
           this.dispose(); 
        }
        else if(e.getSource()==clear)
        {
            try{
            FileOutputStream fos=new FileOutputStream("fblist.txt");
            DataOutputStream dos=new DataOutputStream(fos);
            for(int i=0;i<n;i++)
            {
                if(set[i]!=1)
                {
                    dos.writeBytes(name[i].getText()+" ");
                }
			           set[i]=0;
                   
            }
            dos.close();
            fos.close();
          }catch(Exception ex){}
            JOptionPane.showMessageDialog(this,"Clear viewed records","delete",2);
            this.dispose();
             sfb.cnt=0;
            new feedbacks("feedbacks");             
        }//else
        else
        {
            sfb.cnt=0;
        String s="";
        for(int i=0;i<n;i++)
        if(e.getSource()==name[i])
        { s=name[i].getText();
          p1[i].setBackground(Color.red);  
            try {
                set[i]=1;
                new fbdetails("Feedback details",s);
            } catch (Exception ex){            }
        }
      }
    }
 public void mousePressed(MouseEvent e) {}
 public void mouseReleased(MouseEvent e) {
     }
 public void mouseEntered(MouseEvent e) {
     for(int i=0;i<n;i++)
        if(e.getSource()==name[i])
          if(set[i]!=1)  
             p1[i].setBackground(Color.GREEN);            
 }
 public void mouseExited(MouseEvent e) {
  for(int i=0;i<n;i++)
        if(e.getSource()==name[i])
            if(set[i]==0)
              p1[i].setBackground(new Color(104,222,118));
            else
                p1[i].setBackground(Color.red);  
 }
  class fbdetails extends JFrame
  {
      JLabel l[]=new JLabel[13];
      JPanel p[]=new JPanel[26];
      String t1,t2;
      int g=27,k=0;
      fbdetails(String s1,String file)
      {
          super(s1);
          setLayout(new GridLayout(26,1));
          setVisible(true);
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setBounds(250,1,800,700);
          try{
          fis=new FileInputStream(file+".txt");}
          catch(Exception ex)
          { JOptionPane.showMessageDialog(this,"error");  }
          s=new Scanner(fis);
          t1=s.next();
					if(file.charAt(0)!='_')
					{
          l[0]=new JLabel(t1+" sir ");
          l[0].setFont(new Font("Arial Rounded MT Bold", 2,20));
          l[1]=new JLabel("Mr. "+t1+" sir is a Teacher of "+s.next()+" subject.");
          l[2]=new JLabel("He belong's to "+s.next()+" department in your college.");
          l[3]=new JLabel("He teaches to "+s.next()+" year , "+s.next()+" division.");
          l[4]=new JLabel("His performence in college in as follows :-");
          l[5]=new JLabel("1. "+s.next()+" Communication skill.");
          l[6]=new JLabel("2. "+s.next()+" to clear doubts.");
          l[7]=new JLabel("3. presentation is "+s.next()+".");
          l[8]=new JLabel("4. Teaching methodology used is "+s.next()+".");
          l[9]=new JLabel("5. He has "+s.next()+" intrest created in subject.");
          l[10]=new JLabel("6. "+s.next()+" Conducting class.");
          l[11]=new JLabel("7. "+s.next()+" Maintains decipline.");
          t2=s.nextLine();
          l[12]=new JLabel("Comments :- "+t2);
					}
					else
					{
						l[0]=new JLabel(t1+" (student)  ");
          l[0].setFont(new Font("Arial Rounded MT Bold", 2,20));
          l[1]=new JLabel(t1+" is a student of your college.");
          l[2]=new JLabel("He belong's to "+s.next()+" department.");
          l[3]=new JLabel("He studing in "+s.next()+" year , "+s.next()+" division.");
          l[4]=new JLabel("His performence in college in as follows :-");
          l[5]=new JLabel("1. "+s.next()+" Communication skill.");
          l[6]=new JLabel("2. Average marks is "+s.next());
          l[7]=new JLabel("3. total present day's is "+s.next()+".");
          l[8]=new JLabel("4. Behaviour in campus is "+s.next()+".");
          l[9]=new JLabel("5. He has "+s.next()+" intrest created in study.");
          l[10]=new JLabel("6. "+s.next()+" submit assignments.");
          l[11]=new JLabel("7. "+s.next()+" follows descipline.");
          t2=s.nextLine();
          l[12]=new JLabel("Comments :- "+t2);
					}
          for(int i=0,j=0;j<=25;j++,k+=5)
          {
              p[j]=new JPanel();
              p[j].setBackground(new Color(243,g+k,248));
              if(j%2==0)              
               p[j].add(l[i++]);
               add(p[j]);
          }
       }
  }
 
}
