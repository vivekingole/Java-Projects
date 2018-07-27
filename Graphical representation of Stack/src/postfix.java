import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class postfix extends JFrame implements ActionListener
{
	JLabel title=new JLabel("Infix to Postfix",JLabel.CENTER);
	JLabel in=new JLabel("infix expresstion :- ");
	JLabel out=new JLabel("postfix expresstion :- ");
	JTextField intf=new JTextField(15);
	JTextField outtf=new JTextField(15);
	JButton con=new JButton("convert");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel titlep=new JPanel();//for space
	postfix()
	{
		setVisible(true);
		setBounds(100,100,500,500);
		setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(1);
		setTitle("postfix");
                 getContentPane().setBackground(Color.pink); 
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
		
		String check="",post="";
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
	        /////////////////////////////////////////////////////////////////////////////////
	     for(i=0;item[i]!='\0';i++)
		{
			
			if(item[i]=='('||item[i]=='*'||item[i]=='+'||item[i]=='-'||item[i]=='/')
				stack1.pushf(item[i],1);
			else if(item[i]==')')
			{
				while(stack1.s1[stack1.t1]!=(int)'(')
				{
					r=stack1.popf(1);
					if(r!='(')
					{
					post=post+r;
          			outtf.setText("");
          			outtf.setText(post);
          			System.out.print("1"+post);
					}
				}
				stack1.popf(1);
			}
			else
			{
				post=post+item[i];
          			outtf.setText("");
          			outtf.setText(post);
          			System.out.print("1"+post);
			}
			
		}	//while
		while(stack1.t1!=-1)
		{
			r=stack1.popf(1);
			if(r!='(')
			{
			    post=post+r;
          			outtf.setText("");
          			outtf.setText(post);
          			System.out.print("1"+post);
			}
			
		}
        }//main else
	
	  }//action performed
	public static void main(String []as)
	{
		new postfix();
	}
}