import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class admin extends JFrame implements ActionListener
{
    static admin f;
    JLabel title=new JLabel("Administrator");
    JButton teac=new JButton("Teacher");
    JButton stud=new JButton("Student");
    admin(String s)
    {
        super(s);
        setVisible(true);
        setLayout(null);
        setBounds(300,10,600,680);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c=this.getContentPane();
        c.setBackground(new Color(0,220,33));
        title.setBounds(100,50,400,50);
        title.setFont(new Font("Arial Rounded MT Bold", 3,50));        
        teac.setBounds(150,250,300,50);
        teac.setFont(new Font("Arial Rounded MT Bold", 3,20));                
        stud.setBounds(150,400,300,50);        
        stud.setFont(new Font("Arial Rounded MT Bold", 3,20));	
        add(title);
        add(teac);
        add(stud);	
        	
        teac.addActionListener(this);
        stud.addActionListener(this);	
    }
    public void actionPerformed(ActionEvent e)
    {
    	Object o=e.getSource();
    	if(o==teac)
    	{
    		new admin_teac("Admin Teacher");
    	}
    	else if(o==stud)
    	{
    		new admin_stud("Admin Student");
    	}
    }
    public static void main(String []fg)
    {
      new admin("Admin");	
    }
}