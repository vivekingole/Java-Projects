import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class rooms extends JFrame implements ActionListener{
    static rooms h1;
    static FileInputStream fis;
    static Scanner sc;
    static FileOutputStream fos;
    static DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JLabel name=new JLabel("Name :-");
    JLabel phone=new JLabel("Phone no :-");
    JLabel type=new JLabel("select room :-");
    JLabel days=new JLabel("How many day's :-");
    JLabel member=new JLabel("how many members :-");
    JLabel date=new JLabel("Date :-");
    JButton register=new JButton("Register");
    JButton cancle=new JButton("Cancle");    
    JTextField nametf=new JTextField(30);
    JTextField phonetf=new JTextField(10);
    JTextField daystf=new JTextField(2);
    JTextField membertf=new JTextField(2);
    JTextField datetf=new JTextField(10);
    String item[]={"AC","Non-AC"};
    JComboBox typecb=new JComboBox(item);
    int aac,anac,elligible=0;
    rooms(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        register.setFont(new Font("MV Boli",3,20));
        cancle.setFont(new Font("MV Boli",3,20));
        name.setFont(new Font("MV Boli",3,30));
        nametf.setFont(new Font("MV Boli",3,30));
        type.setFont(new Font("MV Boli",3,30));
        typecb.setFont(new Font("MV Boli",3,30));
        phone.setFont(new Font("MV Boli",3,30));
        phonetf.setFont(new Font("MV Boli",3,30));
        days.setFont(new Font("MV Boli",3,30));
        daystf.setFont(new Font("MV Boli",3,30));
        member.setFont(new Font("MV Boli",3,30));
        membertf.setFont(new Font("MV Boli",3,30));
        date.setFont(new Font("MV Boli",3,30));
        datetf.setFont(new Font("MV Boli",3,30));
        
        title.setBounds(250,30, 600,50);
        register.setBounds(700, 600, 200, 50);
        cancle.setBounds(100, 600, 200, 50);
        name.setBounds(200, 150, 200, 30);
        nametf.setBounds(400,140, 400, 40);
        phone.setBounds(200, 230, 200, 50);   date.setBounds(620, 230, 150, 50);
        phonetf.setBounds(400,240, 200, 40);  datetf.setBounds(760,240, 200, 40);
        type.setBounds(200, 340, 300, 40);
        typecb.setBounds(450, 340, 200, 40);
        days.setBounds(200, 440, 400, 40);
        daystf.setBounds(550, 440, 100, 40);
        member.setBounds(200, 540, 400, 40);
        membertf.setBounds(570, 540, 100, 40);
        add(title);
        add(register);
        add(cancle);
        add(name);
        add(nametf);
        add(phone);  add(date);
        add(phonetf); add(datetf);
        add(type);
        add(typecb);
        add(days);
        add(daystf);
        add(member);
        add(membertf);
        register.addActionListener(this);
        cancle.addActionListener(this);
        getData();
    }
    public void getData()
    {
        try{            
            fis=new FileInputStream("availableroom.txt");
            sc=new Scanner(fis);
            aac=Integer.parseInt(sc.next());
            anac=Integer.parseInt(sc.next());           
        }catch(Exception e){}
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
         JButton bt=(JButton)e.getSource();
         String nul="";
        if(bt==register)
        {            
            if(nul.equals(nametf.getText()) || nul.equals(phonetf.getText()) || nul.equals(datetf.getText())
                   || nul.equals(daystf.getText()) || nul.equals(membertf.getText()))
                elligible=0;
            else
            {
            if(typecb.getSelectedIndex()==0)
            {
                if(aac==0)
                {
                    elligible=0;
                    JOptionPane.showMessageDialog(this, "sorry ! no AC rooms available","not available",2);
                }
                else
                {
                    aac--;
                    elligible=1;
                }
            }
            else
            {
                if(anac==0)
                {
                    elligible=0;
                    JOptionPane.showMessageDialog(this, "sorry ! no Non-AC rooms available","not available",2);
                }
                else
                {
                    anac--;
                    elligible=1;   
                }                
            }
            }//else
            if(elligible==1)
            {
            try{
                fos=new FileOutputStream(".\\records\\room\\"+nametf.getText()+".txt");                
                dos=new DataOutputStream(fos);           
                dos.writeBytes(nametf.getText()+" "+phonetf.getText()+" "+datetf.getText()+" "+typecb.getSelectedItem()+" "+daystf.getText()+" "+membertf.getText());////////////////////////
                dos.close();
                  fos=new FileOutputStream(".\\records\\room\\roomrec.txt",true);                
                dos=new DataOutputStream(fos);           
                dos.writeBytes(" "+nametf.getText());
                dos.close();
            }catch(Exception ex1){}        
            setData();
            JOptionPane.showMessageDialog(this, "Registration succesful !","succes",1);
            this.dispose();
           }
            else
            {
                JOptionPane.showMessageDialog(this, "please fill all fields !"," not succes",2);
            }
         }
        else if(bt==cancle)
        {
            this.dispose();
        }
            
    }
    public static void main(String[] args) {
        h1=new rooms("hotel management system");            
    }
}
