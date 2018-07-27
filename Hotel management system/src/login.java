import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class login extends JFrame implements ActionListener{
    static login login1;
    static FileInputStream fis;
    static Scanner sc;
    JLabel title=new JLabel("Administrator login");
    JButton submit=new JButton("log in");
    JButton back=new JButton("back");    
    JLabel id=new  JLabel("user name :-");
    JLabel pass=new  JLabel("password :-");
    JTextField idtf=new JTextField(20);
    JPasswordField passtf=new JPasswordField(8);
    static String userid,password;
    login(String str1)
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(3);
        setLayout(null);        
        setVisible(true);
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        submit.setFont(new Font("Arial Rounded BT Bold",2,20));
        back.setFont(new Font("Arial Rounded BT Bold",2,20));
        id.setFont(new Font("Arial Rounded BT Bold",2,20));
        pass.setFont(new Font("Arial Rounded BT Bold",2,20));
        idtf.setFont(new Font("Arial Rounded BT Bold",3,20));
        passtf.setFont(new Font("Arial Rounded BT Bold",3,20));
        
        title.setBounds(250,60, 600,60);
        submit.setBounds(800, 600, 100, 50);
        back.setBounds(100, 600, 100, 50);
        id.setBounds(300, 200, 200, 30);
        idtf.setBounds(500, 200, 200, 30);
        pass.setBounds(300, 400, 200, 30);
        passtf.setBounds(500, 400, 200, 30);
        add(title);
        add(submit);
        add(back);
        add(id);
        add(idtf);
        add(pass);
        add(passtf);
        submit.addActionListener(this);
        back.addActionListener(this);
        getData();
    }
    public void actionPerformed(ActionEvent e) {
         JButton bt=(JButton)e.getSource();
        if(bt==submit)
        {
            if(userid.equals(idtf.getText()) && password.equals(passtf.getText()))
            {
              JOptionPane.showMessageDialog(this, "welcome "+userid,"correct",1);
              this.dispose();
              new adminpage("adminpage");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "incorrect user id or password","incorrect",0);
            }
        }
        else if(bt==back)
        {
            this.dispose();
        }
            
    }
    public void getData()
    {
        try{
            fis=new FileInputStream("login.txt"); 
            sc=new Scanner(fis);
            userid=sc.next();
            password=sc.next();
        }catch(FileNotFoundException ex){}
    }
    public static void main(String[] args) {
        login1=new login("hotel management system");            
        
    }
}
