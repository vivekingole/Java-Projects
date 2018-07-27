import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
 
class operation extends JFrame implements ActionListener
{
	JLabel title=new JLabel("operation",JLabel.CENTER);
        JButton create=new JButton("Create");
        JButton push=new JButton("push");
        JButton pop=new JButton("pop");
        JButton peak=new JButton("Peak");
	operation()
	{
		setVisible(true);
		setBounds(100,100,600,600);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(1);
                setLayout(null);
		setTitle("operation");
		title.setFont(new Font("Arial Rounded BT Bold",3,40));
                getContentPane().setBackground(Color.pink); 
                  //create.setBackground(Color.blue);
    title.setForeground(Color.GRAY);
                
                title.setBounds(200, 10, 200, 50);
                create.setBounds(150, 150, 300, 50);
                push.setBounds(150, 250, 300, 50);
                pop.setBounds(150, 350, 300, 50);
                peak.setBounds(150, 450, 300, 50);
                title.setBackground(Color.red);
	        add(title);
                add(create);
                add(push);
                add(pop);
                add(peak);
                
                create.addActionListener(this);
                push.addActionListener(this);
                pop.addActionListener(this);
                peak.addActionListener(this);
        }
	public void actionPerformed(ActionEvent e)		
	{
		Object o=e.getSource();
                if(o==create)
                {                     
                    JOptionPane.showMessageDialog(this, "This operation creates the new stack. We can say that stack is created if we assign stack ‘top’ to -1.\n" +
"      Operation:\n" +
"	void  create ( stack   *sp)\n" +
"	{\n" +
"		sp      top = -1;\n" +
"	}");
                }
                else if(o==push)
                {
                    JOptionPane.showMessageDialog(this, "push operation:\n" +
"	This operation is used to add the new element into stack. The new element is always pushed at the top of stack.\n" +
"	But there is precondition for push operation is that, we must have to check stack is Full or Not. \nIf stack is full and we are going to perform\n push operation then push operation failed such condition is called as “Stack Overflow” condition.\n" +
"         Operation:\n" +
"	void  push(stack  * sp, int  x)\n" +
"	{\n" +
"		if(sp      top = = MAX-1)\n" +
"		{\n" +
"			printf(“\\n Stack Overflows…..”);\n" +
"		}\n" +
"		else\n" +
"		{\n" +
"			+ + sp      top;\n" +
"			sp      item[sp     top] = x;\n" +
"		}\n" +
"	}");
                }
                else if(o== pop)
                {
                    JOptionPane.showMessageDialog(this,"Pop Operation\n" +
"Accessing the content while removing it from the stack, \n is known as a Pop Operation. In an array implementation of pop() operation, \n the data element is not actually removed, \n instead top is decremented to a lower position in the stack to point to the next value. \n But in linked-list implementation, pop() actually removes data element \n and deallocates memory space.\n" +
"\n" +
"A Pop operation may involve the following steps −\n" +
"\n" +
"Step 1 − Checks if the stack is empty.\n" +
"\n" +
"Step 2 − If the stack is empty, produces an error and exit.\n" +
"\n" +
"Step 3 − If the stack is not empty, accesses the data element at which top is pointing.\n" +
"\n" +
"Step 4 − Decreases the value of top by 1.\n" +
"\n" +
"Step 5 − Returns success.\n" +
"\n" +
"Stack Pop Operation\n" +
"Algorithm for Pop Operation\n" +
"A simple algorithm for Pop operation can be derived as follows −\n" +
"\n" +
"begin procedure pop: stack\n" +
"\n" +
"   if stack is empty\n" +
"      return null\n" +
"   endif\n" +
"   \n" +
"   data ← stack[top]\n" +
"   \n" +
"   top ← top - 1\n" +
"   \n" +
"   return data\n" +
"\n" +
"end procedure\n");
                }
                else if(o==peak)
                {
                    JOptionPane.showMessageDialog(this, " This is peak operation it returns \nthe top most element  from the  stack");
                }
	}	
	public static void main(String []as)
	{
		new operation();
	}
}