import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



class application extends JFrame implements ActionListener
{
   
    
	JLabel title=new JLabel("application",JLabel.CENTER);
        JButton prefix=new JButton("infix to prefix");
        JButton postfix=new JButton("infix to postfix");
        JButton evaluate=new JButton("evaluate");
        JButton matching=new JButton("matching");
	application()
	{
		setVisible(true);
		setBounds(100,100,600,600);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(1);
                setLayout(null);
		setTitle("application");
               getContentPane().setBackground(new Color(213,92,114));
                
		title.setFont(new Font("Arial Rounded BT Bold",3,40));
                
                title.setBounds(200, 10, 300, 50);
                prefix.setBounds(150, 150, 300, 50);
                postfix.setBounds(150, 250, 300, 50);
                evaluate.setBounds(150, 350, 300, 50);
                matching.setBounds(150, 450, 300, 50);
	        add(title);
                add(prefix);
                add(postfix);
                add(evaluate);
                add(matching);
                
                prefix.addActionListener(this);
                postfix.addActionListener(this);
                evaluate.addActionListener(this);
                matching.addActionListener(this);
        }
	public void actionPerformed(ActionEvent e)		
	{
		Object o=e.getSource();
                if(o==prefix)
                {                     
                    JOptionPane.showMessageDialog(this, "Step 1. Push “)” onto STACK, and add “(“ to end of the A\n" +
"Step 2. Scan A from right to left and repeat step 3 to 6 for each element of A until the STACK is empty\n" +
"Step 3. If an operand is encountered add it to B\n" +
"Step 4. If a right parenthesis is encountered push it onto STACK\n" +
"Step 5. If an operator is encountered then:\n" +
"	 a. Repeatedly pop from STACK and add to B each operator (on the top of STACK) which has same \n" +
"        or higher precedence than the operator.\n" +
"     b. Add operator to STACK\n" +
"Step 6. If left parenthesis is encontered then\n" +
"	 a. Repeatedly pop from the STACK and add to B (each operator on top of stack until a \n  left parenthesis is encounterd)\n" +
"	 b. Remove the left parenthesis\n" +
"Step 7. Exit");
                }
                else if(o==postfix)
                {
                    JOptionPane.showMessageDialog(this, "1. Scan the infix expression from left to right.\n" +
"2. If the scanned character is an operand, output it.\n" +
"3. Else,\n" +
"…..3.1 If the precedence of the scanned operator is greater than \n the precedence of the operator in the stack\n(or the stack is empty), push it.\n" +
"…..3.2 Else, Pop the operator from the stack \n  until the precedence of the scanned operator is less-equal \n to the precedence of the operator residing on the top of the stack. \n Push the scanned operator to the stack.\n" +
"4. If the scanned character is an ‘(‘, push it to the stack.\n" +
"5. If the scanned character is an ‘)’,\n pop and output from the stack until an ‘(‘ is encountered.\n" +
"6. Repeat steps 2-6 until infix expression is scanned.\n" +
"7. Pop and output from the stack until it is not empty. ");
                }
                else if(o== evaluate)
                {
                    JOptionPane.showMessageDialog(this, "**Evaluation (Calculating the value) of postfix expression:\n" +
"       For evaluation of postfix expression we require:\n" +
"1)	Any postfix expression string.\n" +
"2)	Stack\n" +
"**Algorithm:\n" +
"	Step 1) Start\n" +
"	Step 2) Input any postfix expression string.\n" +
"	Step 3) Read character by character of postfix expression string\n" +
"	Step 4) \n" +
"		* If reading character is operand then push it into stack.\n" +
"		* If reading character is operator then\n" +
"       I) Perform pop operation two times on to the stack.\n" +
"      II) Calculate the value by using popped operands and reading  \n" +
"          operator.\n" +
"     III) Push the calculated value into stack.\n" +
"	Step 5) Repeat the step 3 and step 4 until there is not end of postfix             \n" +
"                     expression.\n" +
"	Step 6) Perform pop operation one time onto stack and display popped  \n" +
"                     value which is value of postfix expression.");
                }
                else if(o==matching)
                {
                    JOptionPane.showMessageDialog(this, "Algorithm:\n" +
"1) Declare a character stack S.\n" +
"2) Now traverse the expression string exp.\n" +
"    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.\n" +
"    b) If the current character is a closing bracket \n (‘)’ or ‘}’ or ‘]’) then \n pop from stack and if the popped character is the matching \n starting bracket then fine else parenthesis are not balanced.\n" +
"3) After complete traversal, \n if there is some starting bracket left in stack then “not balanced”\n" +
"  ");
                }
	}	
	public static void main(String []as)
	{
		new application();
	}
}