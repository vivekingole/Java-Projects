import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class evaluate extends JFrame implements ActionListener
{
	JLabel title=new JLabel("Evaluate postfix",JLabel.CENTER);
	JLabel in=new JLabel("postfix expresstion :- ");
	JLabel out=new JLabel("Answer :- ");
	JTextField intf=new JTextField(15);
	JTextField outtf=new JTextField(15);
	JButton con=new JButton("calculate");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel titlep=new JPanel();//for space
	evaluate()
	{
		setVisible(true);
		setBounds(100,100,500,500);
		setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(1);
		setTitle("evaluate");
		title.setFont(new Font("Arial Rounded BT Bold",3,40));
		in.setFont(new Font("Arial Rounded BT Bold",3,20));
		out.setFont(new Font("Arial Rounded BT Bold",3,20));
		intf.setFont(new Font("Arial Rounded BT Bold",3,20));
		outtf.setFont(new Font("Arial Rounded BT Bold",3,20));
		titlep.add(title);
		p1.add(in);
		p1.add(intf);
		p2.add(con);
		p3.add(out);
		p3.add(outtf);
		add(titlep);
		add(p1);
		add(p2);
		add(p3);
		con.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)		
	{
		String check="";
		int n=0,i=0,j=0,o1=0,o2=0;
		char r='\0';
		char item[]=new char[16];
		stack1.t1=-1;
		stack1.t2=-1;
		
		if(check.equals(intf.getText()))
			JOptionPane.showMessageDialog(this,"enter postfix expression ","error !",2);
		else
		{
		String infix=intf.getText();
			for(n=0;n<infix.length();n++)
			item[n]=infix.charAt(n);
			item[n]='\0';	  
	       
	     for(i=0;item[i]!='\0';i++)
		{			
			if(item[i]=='*'||item[i]=='+'||item[i]=='-'||item[i]=='/')
			{
				o2=(int)stack1.popf(1);
				o1=(int)stack1.popf(1);
				switch(item[i])
				{
					case '+':
						stack1.pushf((char)(o1+o2),1);
					break;
					case '-':
						stack1.pushf((char)(o1-o2),1);
					break;	
					case '/':
						stack1.pushf((char)(o1/o2),1);
					break;	
					case '*':
						stack1.pushf((char)(o1*o2),1);
					break;	
				}
			} 
			else
				stack1.pushf((char)(((int)item[i])-48),1);	 
		}
		 outtf.setText("");
		 outtf.setText(""+(int)stack1.popf(1));
	   }
	}   
	public static void main(String []as)
	{
		new evaluate();
	}
}