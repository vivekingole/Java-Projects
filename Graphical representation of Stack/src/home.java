import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

class home extends JFrame
{
    JLabel img=new JLabel(new ImageIcon(".\\p.png"));
    JButton start=new JButton("start");
    home(String str)
    {
        super(str);
        setBounds(0, 0, 1000,700);
        setDefaultCloseOperation(3);
        setLayout(null);
        setVisible(true);
        img.setBounds(0, 0, 1000, 600);
        start.setBounds(450, 600, 200, 50);
        
        add(img);
        add(start);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               stack1.o=new stack1("stack"); 
               start.setFont(new Font("Arial Rounded BT Bold",3,70));
            }
        });
    }
    public static void main(String []sadf)
    {
        new home("home");
    }
}
