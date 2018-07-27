import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class prefix extends JFrame implements ActionListener
{
	JLabel title=new JLabel("Infix to prefix",JLabel.CENTER);
	JLabel in=new JLabel("infix expresstion :- ");
	JLabel out=new JLabel("prefix expresstion :- ");
	JTextField intf=new JTextField(15);
	JTextField outtf=new JTextField(15);
	JButton con=new JButton("convert");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel titlep=new JPanel();//for space
	prefix()
	{
		setVisible(true);
		setBounds(100,100,500,500);
		setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(1);
		setTitle("prefix");
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
		String check="",pre="";
		int n=0,i=0,j=0;char r='\0';
		char item[]=new char[16];
		stack1.t1=-1;
		stack1.t2=-1;
		if(check.equals(intf.getText()))
			JOptionPane.showMessageDialog(this,"enter infix expression ","error !",2);
		else
		{
		String infix=intf.getText();
		  for(n=0;n<infix.length();n++);		  
		  	n--;
		  for(i=n,j=0;i>=0;i--,j++)		  
			 item[j]=infix.charAt(i);
          item[j]='\0';
          for(i=0;item[i]!='\0';i++)
          {
          	if(item[i]==')' || item[i]=='*' ||item[i]=='+' ||item[i]=='-' ||item[i]=='/')
          	    stack1.pushf(item[i],1);
          	else if(item[i]=='(')
          	{
          		while(stack1.t1!=-1)
          		{
          			r=stack1.popf(1);
          			if(r!=')')
          				stack1.pushf(r,2);
          		}
          	} 
          	else
          		stack1.pushf(item[i],2);          			             	
          }
          
          if(stack1.t1!=-1)
          {
          	while(stack1.t1!=-1)
          	{
          		r=stack1.popf(1);
          		if(r!=')')
          			stack1.pushf(r,2);
          	}
          }
          while(stack1.t2!=-1)
          {
          	pre=pre+stack1.popf(2);
          	outtf.setText("");
          	outtf.setText(pre);
          }
          for(i=0;item[i]!='\0';i++)
          {
          	System.out.print(stack1.popf(1));          	
          }
		}
	}
	public static void main(String []as)
	{
		new prefix();
	}
}