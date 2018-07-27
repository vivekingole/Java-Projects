import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class help extends JFrame implements ActionListener
{
	JLabel title=new JLabel("help",JLabel.CENTER);
        JButton stack=new JButton("Stack");
        JButton oper=new JButton("operations");
        JButton app=new JButton("Applications");
        
	help()
	{
		setVisible(true);
		setBounds(100,100,600,600);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(1);
                setLayout(null);
		setTitle("help");
                getContentPane().setBackground(Color.cyan); 
		title.setFont(new Font("Arial Rounded BT Bold",3,40));
                
                title.setBounds(200, 10, 200, 50);
                stack.setBounds(150, 150, 300, 50);
                oper.setBounds(150, 250, 300, 50);
                app.setBounds(150, 350, 300, 50);
                
	        add(title);
                add(stack);
                add(oper);
                add(app);
                
                stack.addActionListener(this);
                oper.addActionListener(this);
                app.addActionListener(this);
                
        }
	public void actionPerformed(ActionEvent e)		
	{
		Object o=e.getSource();
                if(o==stack)
                {      
                    
                    JOptionPane.showMessageDialog(this, " STACK\n" +
"Definition: “Stack is the data structure which is an ordered collection of elements\n or items into which elements or items are inserted\n and removed from only one end that end is called top of Stack.”\n" +
"	The Stack operates in LIFO (Last In First Out) manner i.e. the element which is \nlastly inserted is the first to come out.\n" +
"e.g.- 1) Stack of CD plates-\n" +
"			In Stack of CD plate only topmost CD can be taken \nout and any new CD has to be put at the top.\n" +
"");
                }
                else if(o==oper)
                {
                    //JOptionPane.showMessageDialog(this,"These are following operations of stack\n 1)Create\n2)push\n 3)pop\n4)peak\n5)count");
                    new operation();
                }
                else if(o== app)
                {
                  //JOptionPane.showMessageDialog(this,"1)infix to prefix\n 2)infix to pstfix\n3)matching of parentheisis\n4)Evaluation of expression");
                  new application();
                }
                 else if(o== app)
                {
                  //JOptionPane.showMessageDialog(this,"1)infix to prefix\n 2)infix to pstfix\n3)matching of parentheisis\n4)Evaluation of expression");
                  new application();
                }
	}	
	public static void main(String []as)
	{
		new help();
}

    private static class JoptionPane {

        public JoptionPane() {
        }
    }
}