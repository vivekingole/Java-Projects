import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class sfb extends JFrame implements ActionListener {
        
    static sfb f;
    static JButton hod,stfb,exit,tefb,back,next,reg,help,admin;
    static JLabel hodnm,pass,title,title11,title12;
    static JTextField nm;
    static JPasswordField pas;
    static JDialog d;
    static FileInputStream fis;
    static FileOutputStream fos,fos1;     
    Container c;
    static int cnt=0;
    static String adnm,adpas;
    String name[]=new String[100];
    String pas1[]=new String[100];
    int id=0;
    sfb(String s1)
    {
        super(s1);
        this.setLayout(null);
        c=this.getContentPane();
        c.setBackground(new Color(0,220,33));
        hod=new JButton("HOD Login");
        stfb=new JButton("Student Feedback");
        exit=new JButton("Exit");
        admin=new JButton("Admin Login");
        tefb=new JButton("Teacher Feedback");
        back=new JButton("<< back");
        next=new JButton("next >>");
        help=new JButton("help");
        hodnm=new JLabel("HOD Name :-");
        pass=new JLabel("pasword :-");
        title11=new JLabel("Student Feedback");
        title11.setFont(new Font("Arial Rounded MT Bold", 3,50));
        title11.setBounds(45,10,600,200);        
        title12=new JLabel("System");
        title12.setFont(new Font("Arial Rounded MT Bold", 3,50));
        title12.setBounds(200,100,200,200);        
        admin.setBounds(200,250,200,30);
        hod.setBounds(200,330,200,30);
        stfb.setBounds(200,410,200,30);
        tefb.setBounds(200,490,200,30);
        exit.setBounds(200,570,200,30);
        help.setBounds(10,10,100,50);
        
        exit.setBackground(new Color(255,72,90));
        exit.addActionListener(this);
        admin.addActionListener(this);     
        hod.addActionListener(this);
        stfb.addActionListener(this);
        tefb.addActionListener(this);    
        help.addActionListener(this);     
        	
        this.add(title11);
        this.add(title12);
        this.add(admin);
        this.add(hod);
        this.add(stfb);
        this.add(exit);
        this.add(tefb);
        add(help);
    }
     public void getData(String file)
    {
    	Scanner sc=null;
        String t="";
        try{            
            fis=new FileInputStream(file);
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
           	    pas1[id]=sc.next();        
                id++;
           	 	}
           	 }catch(Exception ex){break loop; }
           
           }
           
        }catch(Exception e){  JOptionPane.showMessageDialog(this,e);}
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
       Object o=e.getSource();
       if(o==exit)
           System.exit(0);
       else if(o==help)
	{
	  JOptionPane.showMessageDialog(this,"sdkjgsd\nsdgjd\ndfgh");
	}
       else if(o==hod)
       {
           d=new JDialog(this);
           d.setBounds(300, 10, 600, 680);
           d.getContentPane().setBackground(new Color(0,220,33));
           d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           d.setVisible(true);
           d.setLayout(null);
            JLabel t1= new JLabel("HOD Login");
            t1.setFont(new Font("Arial Rounded MT Bold", 3, 52));
            t1.setBounds(160,10,320,200);
            d.add(t1);
           hodnm.setBounds(150, 300, 100, 30);
           pass.setBounds(150, 400, 100, 30);
           nm=new JTextField(20);
           pas=new JPasswordField(8);
           nm.setBounds(250, 300, 200, 30);
           pas.setBounds(250, 400, 200, 30);
           back.setBounds(80,550,100,30);
           next.setBounds(400,550,100,30);
           back.addActionListener(new hodbt());
           next.addActionListener(new hodbt());
           d.add(hodnm);
           d.add(pass);
           d.add(nm);
           d.add(pas);
           d.add(back);
           d.add(next);
           f.add(d);                        
       }   
       	else if(o==admin)
       	{
       		 try {
                  fis=new FileInputStream("admin.txt");
              } catch (FileNotFoundException ex) {                 
              }
                 Scanner sc=new Scanner(fis);
                 String s1=sc.next();
                 String s2=sc.next();
                 String s3=JOptionPane.showInputDialog(null,"enter Administrator Name");
                 String s4=JOptionPane.showInputDialog(null,"enter Administrator pasword");
                 if(!(s1.equals(s3))||!(s2.equals(s4)))
                         {                      
                           JOptionPane.showMessageDialog(d, "incorrect user id or pasword", "error", 2);
													 cnt--;
                         }
                 else
                 {   
                     JOptionPane.showMessageDialog(d, "Welcome  Mr. "+s1+"  sir", "Welcome",1);    
                     new admin("Admin");                  
                 }         
       		
       	}
       else if(o==stfb)
       {   
       	 int elligible=0;
       	 String s1="",s2="";
       	  getData("stud_rec.txt");
       	   	s1=JOptionPane.showInputDialog(null,"enter Student Name");
            s2=JOptionPane.showInputDialog(null,"enter Student pasword");
       	    for(int i=0;i<id;i++)
       	    {
       	    	if(s1.equals(name[i]) && s2.equals(pas1[i]) )
       	    		elligible=1;
       	    }
       	    
                 if(elligible==1)      	    
       	         {   
                     JOptionPane.showMessageDialog(d, "Welcome "+s1, "Welcome",1);    
                     new feedback("Feedback form");
                 }         
                 else	
                    JOptionPane.showMessageDialog(d, "Student not found", "not found",1);    
       }
       else if(o==tefb)
       {
       	  int elligible=0;
       	 String s1="",s2="";
       	  getData("teac_rec.txt");
       	   	s1=JOptionPane.showInputDialog(null,"enter Teacher Name");
            s2=JOptionPane.showInputDialog(null,"enter Teacher pasword");
       	    for(int i=0;i<id;i++)
       	    {
       	    	if(s1.equals(name[i]) && s2.equals(pas1[i]) )
       	    		elligible=1;
       	    }
       	    
                 if(elligible==1)      	    
       	         {   
                     JOptionPane.showMessageDialog(d, "Welcome "+s1+" sir", "Welcome",1);    
                     new feedback("Feedback form");
                 }         
                 else	
                    JOptionPane.showMessageDialog(d, "Teacher not found", "not found",1);    
       	 
    }
    }
    class hodbt implements ActionListener
    {
        FileInputStream fis;
        Scanner s;
        int n,i;
        @Override
        public void actionPerformed(ActionEvent e) {
          Object o=e.getSource();
             if(o==back)
                d.dispose();
             else if(o==next)
             {                  
              try {
                  fis=new FileInputStream("LoginDetails.txt");
              } catch (FileNotFoundException ex) {                 
              }
                 Scanner sc=new Scanner(fis);
                 String s1=sc.next();
                 String s2=sc.next();
                 if(!(s1.equals(nm.getText()))||!(s2.equals(pas.getText())))
                         {                      
                           JOptionPane.showMessageDialog(d, "incorrect user id or pasword", "error", 2);
													 cnt--;
                         }
                 else
                 {   
                     JOptionPane.showMessageDialog(d, "Welcome  Mr. "+s1+"  sir", "Welcome",1);    
                     d.setVisible(false);
                     d.dispose();
                     new feedbacks("feedbacks");   
                  
                 }             
           }        
        }        
    }
    
    public static class register {
        DataOutputStream dos,dos1;
        JFrame d;
     register()
    {
         reg=new JButton("Register");
           reg.setBounds(400,550,100,30);
           d=new JFrame("Registration form");           
           d.setBounds(295, 10, 610, 680);          
           d.setVisible(true);
           d.setLayout(null);
           d.getContentPane().setBackground(new Color(255,79,78));
           d.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            d.add(sfb.reg);
            JLabel t1= new JLabel("Registration Form");
            t1.setFont(new Font("Arial Rounded MT Bold", 3, 50));
            t1.setBounds(60,10,500,200);
            d.add(t1);
           sfb.hodnm.setBounds(150, 300, 100, 30);
           d.add(sfb.hodnm);
           sfb.pass.setBounds(150, 400, 100, 30);
           d.add(sfb.pass);
           sfb.nm=new JTextField(20);
           d.add(sfb.nm);
           sfb.pas=new JPasswordField(8);
           d.add(sfb.pas);
           sfb.nm.setBounds(250, 300, 200, 30);
           sfb.pas.setBounds(250, 400, 200, 30);
           reg.addActionListener(new regbt());
           f.add(d);
               }
 
    class regbt implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {                                       
                  try {
                  	   fos=new FileOutputStream("teac_rec.txt");
                  	   fos=new FileOutputStream("stud_rec.txt");
                      fos=new FileOutputStream("LoginDetails.txt");
                      fos1=new FileOutputStream("admin.txt");
                  } catch (FileNotFoundException ex) {
                  }
                 String s1=nm.getText();
                 String s2=pas.getText();
                 if(s1.equals("")||s2.equals(""))
                         {
                             JOptionPane.showMessageDialog(d, "please fill all fields", "error",JOptionPane.ERROR_MESSAGE);
                         }
                 else
                 {   
                      try {
                          dos=new DataOutputStream(fos);
                          dos1=new DataOutputStream(fos1);
                          dos.writeBytes(s1+" "+s2);
                          dos.close();         
                          dos1.writeBytes(adnm+" "+adpas);
                          dos1.close();         
                          JOptionPane.showMessageDialog(d, "Registration Succesful !", "Report",1);
                          d.dispose();
                          cnt=0;
                      } catch (IOException ex) {                          
                      }
                 }
                 
        }
    }
    
}
    public static void main(String[] args) throws Exception {
        f=new sfb("Student Feedback Syatem");
        f.setBounds(300,10,600,680);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false); 
                  try {
                      fis=new FileInputStream("LoginDetails.txt");
                  } catch (FileNotFoundException ex) {                  	
                  	adnm=JOptionPane.showInputDialog(null,"enter Administrator Name");
                  	adpas=JOptionPane.showInputDialog(null,"enter Administrator pasword");
                     new register();           
                  }
               
               //new register();
    }    
}
