import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class feedback extends JFrame implements ActionListener
{
    static feedback f;
    Container c;
    String deptar[]={"Computer","electonics","Math","statistic"},
           yearar[]={"I","II","III"},
            divar[]={"A","B","C"};
    JLabel title,name,dept,year,sub,inst,com,div;
    JLabel q[]=new JLabel[7];
    JButton send;
    JTextField nametf,subtf,comtf;
    JComboBox yearcb,deptcb,divcb;
    JPanel p[]=new JPanel[16];
    JRadioButton b[][]=new JRadioButton[7][4],b1[]=new JRadioButton[4];//b1,b2,b3,b4,b5,b6,b7;
    ButtonGroup bg[]=new ButtonGroup[7],btg;
    int set=0,r=20,g=233;
    String s1,s2,s3,coms="not mention";
    String ans[]=new String[7];
    feedback(String s)
    {
        super(s);
        setVisible(true);
        setBounds(40,1,1200,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(16,1));
        c=this.getContentPane();
         c.setBackground(new Color(20,233,198));
        title=new JLabel("Feedback Form  ");
        title.setFont(new Font("Arial Rounded MT Bold", 2,40));
        name=new JLabel("Name of Teacher :-");
        dept=new JLabel("Department :-");
        year=new JLabel("Year :-");
        div=new JLabel("Div :-");
        sub=new JLabel("Subject :-");
        inst=new JLabel("* Indicate peformance of teacher by selecting perticular option");
        q[0]=new JLabel("A . Communication skill :-");
        q[1]=new JLabel("B . Ability to clear doubts :-");
        q[2]=new JLabel("C . Presentatio (viz. blackboard,power point) :-");
        q[3]=new JLabel("D . Teaching methodology (i.e. examples,teaching pace,illustration used) :-");
        q[4]=new JLabel("E . Overall intrest created in subject :-");
        q[5]=new JLabel("F . Regular to conducting class :-");
        q[6]=new JLabel("G . Maintains class discipline :-");
        com=new JLabel("comments :-");
        send=new JButton("Send...");
        nametf=new JTextField(20);
        subtf=new JTextField(10);
        comtf=new JTextField(30);
        deptcb=new JComboBox(deptar);
        yearcb=new JComboBox(yearar);
        divcb=new JComboBox(divar);
        set=0;
        l:for(int i=0,j=0;i<=14;i++,j=j+10)
        {
             if(i==1&&set==0)
            {
                set=1;
                i--;          
               p[15]=new JPanel();
               p[15].setBackground(new Color(r+j,g-j,198));
               continue l;
            } 
               p[i]=new JPanel();
               p[i].setBackground(new Color(r+j,g-j,198));
        } 
        set=0;
            title.setSize(300,50);
        p[0].add(title);        
        p[1].add(name);
        p[1].add(nametf);
        p[2].add(dept);
        p[2].add(deptcb);
        p[3].add(year);
        p[3].add(yearcb);
        p[3].add(div);
        p[3].add(divcb);
        p[4].add(sub);
        p[4].add(subtf);
        p[5].add(inst); 
               
      for(int i=0,j=70;i<=6;i++,j=j+10)
        {
            bg[i]=new ButtonGroup();
            if(i<=4)
            { 
                b[i][0]=new JRadioButton("Excellent");
                b[i][1]=new JRadioButton("very Good");
                b[i][2]=new JRadioButton("Good");
                b[i][3]=new JRadioButton("Poor");
                b[i][0].setBackground(new Color(r+j,g-j,198));
                b[i][1].setBackground(new Color(r+j,g-j,198));
                b[i][2].setBackground(new Color(r+j,g-j,198));
                b[i][3].setBackground(new Color(r+j,g-j,198));
                bg[i].add(b[i][0]);
                bg[i].add(b[i][1]);
                bg[i].add(b[i][2]);
                bg[i].add(b[i][3]);
                
                p[i+6].add(q[i]);              
                p[i+6].add(b[i][0]);
                p[i+6].add(b[i][1]);
                p[i+6].add(b[i][2]);
                p[i+6].add(b[i][3]);
            }
        else
            {
                b[i][0]=new JRadioButton("Always");
                b[i][1]=new JRadioButton("Mostly");
                b[i][2]=new JRadioButton("Sometimes");
                b[i][0].setBackground(new Color(r+j,g-j,198));
                b[i][1].setBackground(new Color(r+j,g-j,198));
                b[i][2].setBackground(new Color(r+j,g-j,198));
                bg[i].add(b[i][0]);
                bg[i].add(b[i][1]);
                bg[i].add(b[i][2]);
                p[i+6].add(q[i]);
                p[i+6].add(b[i][0]);
                p[i+6].add(b[i][1]);
                p[i+6].add(b[i][2]);
                
            }
           b[i][0].setSelected(true);
        }
               
        p[13].add(com);
        p[13].add(comtf);
        p[14].add(send);
        loop:for(int i=0;i<=14;i++)
        {
            if(i==1&&set==0)
            {
                set=1;
                add(p[15]);i--;
                continue loop;
            }
            add(p[i]);
        }
       send.addActionListener(this); 
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
           if(e.getSource()==send)
        {
            s1=nametf.getText();
            s2=subtf.getText();
            s3=comtf.getText();
            for(int i=0;i<=6;i++)
            {
                if(i<=4)
                {
                if(b[i][0].isSelected()){   ans[i]="Excellent";}
                else if(b[i][1].isSelected()){ ans[i]="very_good";}
                else if(b[i][2].isSelected()) {ans[i]="good";}
                else if(b[i][3].isSelected()) {ans[i]="poor";}
                }
                else{
                    if(b[i][0].isSelected()){   ans[i]="Always";}
                else if(b[i][1].isSelected()){ ans[i]="Mostly";}
                else if(b[i][2].isSelected()) {ans[i]="Sometimes";}
                }           
            }    
              if(!(s3.equals(""))) coms=s3;          
              else coms="not mention !";
              if(s1.equals(""))
              JOptionPane.showMessageDialog(this, "Please enter name !", "error", 2);
            else if(s2.equals(""))
              JOptionPane.showMessageDialog(this, "Please enter subject !", "error", 2);
            else
            {
                try { 
                    FileOutputStream fos=new FileOutputStream(s1+".txt");
                    DataOutputStream dos=new DataOutputStream(fos);
                    dos.writeBytes(s1+" "+s2+" "+deptcb.getSelectedItem()+" "+yearcb.getSelectedItem()+" "+divcb.getSelectedItem()
                    +" "+ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[3]+" "+ans[4]+" "+ans[5]+" "+ans[6]+" "+coms);
                    dos.close();
                    fos.close();
                    fos=new FileOutputStream("fblist.txt",true);
                     dos=new DataOutputStream(fos);
                     dos.writeBytes(s1+" ");
                     dos.close();
                     fos.close();
                     sfb.cnt=0;
                } catch (Exception ex) { JOptionPane.showMessageDialog(this, "FeedBack not send !", "error",0);}
              JOptionPane.showMessageDialog(this, "Feedback send !", "Succesful",1);                
              this.dispose();
            }
        }
    }
}