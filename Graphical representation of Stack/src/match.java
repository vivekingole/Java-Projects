import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class match extends JFrame implements ActionListener
{
	JLabel title=new JLabel("matching parenthisis",JLabel.CENTER);
	JLabel in=new JLabel("infix expresstion :- ");
	JTextField intf=new JTextField(15);
	JButton con=new JButton("check");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel titlep=new JPanel();
	match()
	{
		setVisible(true);
		setBounds(100,100,500,400);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(1);
		setTitle("matching parenthisis");
		title.setFont(new Font("Arial Rounded BT Bold",3,40));
		in.setFont(new Font("Arial Rounded BT Bold",3,20));
		intf.setFont(new Font("Arial Rounded BT Bold",3,20));
		titlep.add(title);
		p1.add(in);
		p1.add(intf);
		p2.add(con);
		add(titlep);
		add(p1);
		add(p2);
		con.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)		
	{
		String check="";
		int n=0,i=0,j=0;char r='\0';
		char item[]=new char[16];
		stack1.t1=-1;
		stack1.t2=-1;
		
		if(check.equals(intf.getText()))
			JOptionPane.showMessageDialog(this,"enter infix expression ","error !",2);
		else
		{
		String infix=intf.getText();
		for(n=0;n<infix.length();n++)
			item[n]=infix.charAt(n);
			item[n]='\0';	  
				int f=0;
	    	 loop:for(i=0;item[i]!='\0';i++)
		     {			
					if(item[i]=='('||item[i]=='{'||item[i]=='[')
						stack1.pushf(item[i],1);
					else if(item[i]==')'||item[i]=='}'||item[i]==']')
					{
						r=stack1.popf(1);
						if((r=='(')!=(item[i]==')')  ||  (r=='[')!=(item[i]==']')  || (r=='{')!=(item[i]=='}'))
						{
							f=1;
							break loop;
						}		
					}									
		     }
		     if(f==1)//stack1.t1!=-1)
		     	JOptionPane.showMessageDialog(this,"Expression is invalid","invalid",0);
		     else
		     	JOptionPane.showMessageDialog(this,"Expression is valid","valid",1);	
     	}
	}	
	public static void main(String []as)
	{
		new match();
	}
}