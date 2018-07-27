import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.*;

class stack1 extends JFrame
{
	static stack1 o;
	 JMenuBar menubar;
	 JMenu create,oper,app,help;           
	 JMenuItem pre,post,push,pop,peak,count,convert,eval,match;
      static Container c;
      static Graphics g;
        String ele;   
        int item[]=new int[11],top=-1,x=800,y=800,x1,y1;
        static int s1[]=new int[20],t1=-1;
		static int s2[]=new int[20],t2=-1;
		int sc=0;
	stack1(String str)	{//constructor
		super(str);
        	this.setLayout(null);
               setVisible(true);
             setBounds(4,5,1600,850);      
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menubar =new JMenuBar();
		menubar.setBounds(0,0,1600,30);
		oper=new JMenu("Operations");
		app=new JMenu("Applications");
		help=new JMenu("Help");
		        push=new JMenuItem("Push");
                pop=new JMenuItem("Pop");
                peak=new JMenuItem("peak");
                count=new JMenuItem("count");
                convert=new JMenu("Convert");
                eval=new JMenuItem("Evaluate");
                match=new JMenuItem("match");
                pre=new JMenuItem("prefix");
                		post=new JMenuItem("postfix");
				create=new JMenu("create");
				
				menubar.add(create);
                menubar.add(oper);
                menubar.add(app);
                menubar.add(help);
                oper.add(push);
                oper.add(pop);
                oper.add(peak);
                oper.add(count);
				convert.add(pre);
				convert.add(post);
                app.add(convert);               
				app.add(eval);
                app.add(match);  
                
                
                this.add(menubar); 
                	JLabel title=new JLabel("Graphical representation of stack");
                	title.setFont(new Font("Copperplate Gothic Bold",3,40));
                	title.setBounds(250,20,1000,50);	
                add(title);
                create.addMouseListener(new createe());
                push.addMouseListener(new pushe());
                pop.addMouseListener(new pope());
                peak.addMouseListener(new peake());
                count.addMouseListener(new peake());
                pre.addMouseListener(new converte());
                post.addMouseListener(new converte());
                eval.addMouseListener(new evale());
                match.addMouseListener(new matche());
                help.addMouseListener(new shelp());
                //application.addMouseListener(new application());
              
                
             }
	
        class createe extends MouseAdapter
        {            
	        public void mouseClicked(MouseEvent e){
				     Container c =o.getContentPane();
                  Graphics g=c.getGraphics();               
    			   c.setBackground(new Color(121,223,203));			
                 g.drawRect(799,250,101,500);
                 g.fillRect(799,750,101,50);
				g.setColor(new Color(121,223,203));			   
                g.drawLine(800,250,900,250);
                 g.drawString("-1",840,780);
                 create.setEnabled(false);
                 sc=1;
	        }
        }   		
        class pushe extends MouseAdapter
        {            
	        public void mouseReleased(MouseEvent e){
	        	if(sc==1)
	        	{	        	
				if(top!=9)
				{	
              try{
               Container c =o.getContentPane();
               Graphics g=c.getGraphics();               
               g.setFont(new Font("Arial Rounded BT bold",2,20));
               g.drawString("top",750,y-20);             
			  ele=JOptionPane.showInputDialog(o, "Enter element :-", "push",1);
              item[++top]=Integer.parseInt(ele);
			   g.setColor(new Color(245,194,240));			                  
              for(y1=100;y1!=(y-50);y1+=50)
              {
                      g.setColor(new Color(245,194,240));
                      g.fillRoundRect(800,y1, 100, 50, 20, 20);
                      g.setColor(Color.BLACK);
                      g.drawString(ele,840, y1+30);
                      try{
                          Thread.sleep(70);
                      }catch(Exception ex){}
                      g.setColor(new Color(121,223,203));
                      g.fillRoundRect(800,y1, 100, 50, 20, 20);
                      g.drawString(ele,800, y1);
              }
                      g.setColor(new Color(245,194,240));
                      g.fillRoundRect(800,y1-50, 100, 50, 20, 20);
                      g.setColor(Color.BLACK);
                      g.drawString(ele,840, y1-20);
                     	y-=50;
                     g.setColor(new Color(121,223,203));	
                     g.drawString("top",750,y+30);           
                     g.setColor(Color.BLACK);	
                     g.drawString("top",750,y-20);  
                     JOptionPane.showMessageDialog(o,"element "+ele+" pushed !","pushed",1); 
	                      
              }catch(Exception ex){}
			}//if
			else
				JOptionPane.showMessageDialog(o,"Stack overflows !","Stack full",2);
	        }
	        else
	        	JOptionPane.showMessageDialog(o,"Stack not create !","Stack not create",0);	
            
        }//clicked
        }//class
            class pope extends MouseAdapter
        {        
            public void mouseReleased(MouseEvent e){
            	if(sc==1)
            	{            	
				if(top!=-1)
				{
					try{
               Container c =o.getContentPane();
               Graphics g=c.getGraphics();               
			   c.setBackground(new Color(121,223,203));
			        g.setColor(new Color(121,223,203));
			        g.setFont(new Font("Arial Rounded BT bold",2,20));	
                     g.drawString("top",750,y-20);           					   				
              for(int x1=800,y1=y;x1!=0;)
              {
				    if(y1>=150)
						y1-=50;
					else
						x1-=50;
					    g.setColor(new Color(245,194,240));
                      g.fillRoundRect(x1,y1, 100, 50, 20, 20);
                      g.setColor(Color.BLACK);
                      g.drawString(""+item[top],x1+40, y1+30);                      					  
                      try{
                          Thread.sleep(70);
                      }catch(Exception ex){}
					  g.setColor(new Color(121,223,203));
                      g.fillRoundRect(x1,y1, 100, 50, 20, 20);
                      g.drawString(""+item[top],x1,y1);
					  
              }
                     y+=50;
					 top--;
					 g.setColor(Color.BLACK);	
                     g.drawString("top",750,y-20);  
                   JOptionPane.showMessageDialog(o,"element "+ele+" poped !","poped",1); 
              }catch(Exception ex){}
				}
				else
					JOptionPane.showMessageDialog(o,"Stack underflows !","Stack empty",2);
            	}
            	else
	        	JOptionPane.showMessageDialog(o,"Stack not create !","Stack not create",0);	
            } 
	}
        
        class peake extends MouseAdapter
        {                       
        	public void mouseReleased(MouseEvent e){
        		if(sc==1)
        		{        		
              if(e.getSource()==peak)
                 JOptionPane.showMessageDialog(o,""+item[top],"peaked value",1);
              else if(e.getSource()==count)
                JOptionPane.showMessageDialog(o,""+(top+1),"total elements",1);
        		}
        		else
	        	JOptionPane.showMessageDialog(o,"Stack not create !","Stack not create",0);	
            }
	    }
        class evale extends MouseAdapter
        {                    				
			public void mouseReleased(MouseEvent e){
               new evaluate();      
			}
        }
        class converte extends MouseAdapter
        {        
            public void mouseReleased(MouseEvent e){
            	if(e.getSource()==pre)
            		new prefix();
            	else if(e.getSource()==post)
            		new postfix();	
			
			}
        }
       
         class matche extends MouseAdapter
        { 
	       public void mouseReleased(MouseEvent e){
              new match();
           } 
         }
               class shelp extends MouseAdapter
               {
         public void mouseClicked(MouseEvent e){
             new help();    
           } 
        
        }
       
     public static void pushf(char c,int f)
	 {		 
	 	int n=(int)c;
		if(f==1 && t1<10)
           s1[++t1]=n;
		else if(f==2 && t2<10)	
			s2[++t2]=n; 
	 }
	 public static char popf(int f)
	 {
		if(f==1 && t1!=-1)
           return((char)s1[t1--]);
	    else if(f==2 && t2!=-1)
			return((char)s2[t2--]);		
		return '\0';
	 }                          
      public static void main(String []args)throws NullPointerException
	{
		o=new stack1("graphically representation of stack");
	
    }
}	