import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class editroom extends JFrame implements ActionListener{
    static editroom h1;
    static FileInputStream fis;
    static Scanner sc;
    FileOutputStream fos;
    DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JLabel ac=new JLabel("AC Rooms :-");
    JLabel nac=new JLabel("Non AC Rooms :-");
    JLabel acr=new JLabel("AC Rate :-");
    JLabel nacr=new JLabel("Non AC Rate :-");
    JTextField actf=new JTextField(5);
    JTextField nactf=new JTextField(5);
    JTextField acrtf=new JTextField(5);
    JTextField nacrtf=new JTextField(5);
    JButton update=new JButton("update");
    
    editroom(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("MV Boli",3,50));
        ac.setFont(new Font("MV Boli",3,30));
        nac.setFont(new Font("MV Boli",3,30));
        acr.setFont(new Font("MV Boli",3,30));
        nacr.setFont(new Font("MV Boli",3,30));
        actf.setFont(new Font("MV Boli",3,30));
        nactf.setFont(new Font("MV Boli",3,30));
        acrtf.setFont(new Font("MV Boli",3,30));
        nacrtf.setFont(new Font("MV Boli",3,30));
        update.setFont(new Font("MV Boli",3,30));
        
        title.setBounds(250,30,700,50);
        ac.setBounds(100,200,300,50);
        nac.setBounds(100,350,300,50);
        actf.setBounds(350,200,100,50);
        nactf.setBounds(400,350,100,50);
        acr.setBounds(550,200,300,50);
        nacr.setBounds(550,350,300,50);
        acrtf.setBounds(800,200,100,50);
        nacrtf.setBounds(850,350,100,50);
        update.setBounds(400,500,200,70);
               
        add(title); 
        add(ac);
        add(nac);
        add(acr);
        add(nacr);
        add(actf);
        add(nactf);
        add(acrtf);
        add(nacrtf);
        add(update);        
        getData();
        update.addActionListener(this);
    }
    public void getData()
    {
        try{            
            fis=new FileInputStream("editroom.txt");
            sc=new Scanner(fis);
            actf.setText(sc.next());
            acrtf.setText(sc.next());
            nactf.setText(sc.next());
            nacrtf.setText(sc.next());
        }catch(Exception e){}
    }
    public void setData()
    {
        try{            
            fos=new FileOutputStream("editroom.txt");
            dos=new DataOutputStream(fos);
            dos.writeBytes(actf.getText()+" ");
            dos.writeBytes(acrtf.getText()+" ");
            dos.writeBytes(nactf.getText()+" ");
            dos.writeBytes(nacrtf.getText());            
        }catch(Exception e){}
        JOptionPane.showMessageDialog(this, "Updation succesful !");
        this.dispose();
    }
    public void actionPerformed(ActionEvent e) {
        setData();
    }
    public static void main(String[] args) {
        h1=new editroom("hotel management system");            
    }
    
}
