import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class dishes extends JFrame implements ActionListener{
    static rooms h1;
    static FileInputStream fis;
    static Scanner sc;
    static FileOutputStream fos;
    static DataOutputStream dos;
    JLabel title=new JLabel("Lifestyle hotel");
    JLabel name=new JLabel("Name :-");
    JLabel phone=new JLabel("Phone no :-");
    JLabel type=new JLabel("select Dish :-");
    JLabel total=new JLabel("Total bill :-");
    JButton order=new JButton("order");
    JButton cancle=new JButton("Cancle");    
    JTextField nametf=new JTextField(30);
    JTextField phonetf=new JTextField(10);
    JTextField totaltf=new JTextField(2);
    JComboBox typecb=new JComboBox();
    String items[]=new String[20];int itemi=0;
    int pri[]=new int[20],prii=0,totalp=0,cnt=0;
    String food;
    int c=0;
    dishes(String str1)throws Exception
    {
        super(str1);
        setBounds(1,1,1000,800);
        setDefaultCloseOperation(1);
        setLayout(null);        
        setVisible(true);
        itemi=0;
        prii=0;
        title.setFont(new Font("Arial Rounded BT Bold",3,50));
        order.setFont(new Font("MV Boli",3,20));
        cancle.setFont(new Font("MV Boli",3,20));
        name.setFont(new Font("MV Boli",3,30));
        nametf.setFont(new Font("MV Boli",3,30));
        type.setFont(new Font("MV Boli",3,30));
        typecb.setFont(new Font("MV Boli",3,30));
        phone.setFont(new Font("MV Boli",3,30));
        phonetf.setFont(new Font("MV Boli",3,30));
        total.setFont(new Font("MV Boli",3,30));
        totaltf.setFont(new Font("MV Boli",3,30));
              
        title.setBounds(250,30, 600,50);
        order.setBounds(700, 600, 200, 50);
        cancle.setBounds(100, 600, 200, 50);
        name.setBounds(200, 150, 200, 30);
        nametf.setBounds(400,140, 400, 40);
        phone.setBounds(200, 230, 200, 50);
        phonetf.setBounds(400,240, 200, 40);
        type.setBounds(200, 340, 300, 40);
        typecb.setBounds(450, 340, 500, 40);
        total.setBounds(200, 440, 400, 40);
        totaltf.setBounds(450, 440, 200, 40);
       
        add(title);
        add(order);
        add(cancle);
        add(name);
        add(nametf);
        add(phone);
        add(phonetf);
        add(type);
        add(typecb);
        add(total);
        add(totaltf);
        order.addActionListener(this);
        cancle.addActionListener(this);
        typecb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int p=0;
        JComboBox cb=(JComboBox)e.getSource();                         
        int i=cb.getSelectedIndex();
        if(i!=0)
        {
            p=Integer.parseInt(JOptionPane.showInputDialog("enter Quantity"));
            totaltf.setText(""+(totalp+=(p*pri[i]))+" /- ");
            food+="\n"+cb.getSelectedItem();
        }
            }
        });    
          getDishes();
    }
    public void getDishes() throws Exception
    {
        String t="";
        int p=0;
        fis=new FileInputStream("editdish.txt");
        sc=new Scanner(fis);
        typecb.addItem("Select dish");
        while((t=sc.next())!=null)
        {
            t+=" "+sc.next();
            p=sc.nextInt();
            t+=" "+p+" /-";
            typecb.addItem(t);
            pri[++prii]=p;
        }
        typecb.setSelectedIndex(0);
    }
    public void actionPerformed(ActionEvent e) {
         JButton bt=(JButton)e.getSource();         
        if(bt==order)
        {
            try{
                fos=new FileOutputStream(".\\records\\food\\"+nametf.getText()+".txt");                
                dos=new DataOutputStream(fos);           
                dos.writeBytes(nametf.getText()+" "+phonetf.getText()+" "+totaltf.getText()+food);////////////////////////
                dos.close();
                  fos=new FileOutputStream(".\\records\\food\\foodrec.txt",true);                
                dos=new DataOutputStream(fos);           
                dos.writeBytes(" "+nametf.getText());
                dos.close();
            }catch(Exception ex1){}        
            JOptionPane.showMessageDialog(this, "Order accepted !","succes",1);
            this.dispose();
        }
        else if(bt==cancle)
        {
            this.dispose();
        }
            
    }
    public static void main(String[] args) throws Exception {
        new dishes("hotel management system");            
    }
 
}
