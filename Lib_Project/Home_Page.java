
// Home Page of the project.


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


class Home_Page extends JFrame implements ActionListener
{ 
	JLabel l1;
	JButton b1,b2,b3;
	LineBorder lb;
	ImageIcon i;
	Home_Page()
	{
		super("Welcome to My Library.");
		lb=new LineBorder(Color.red,3);
                i = new ImageIcon("images//home.jpg");
                l1 = new JLabel(i);
                l1.setBorder(lb);
                b1 = new JButton("Show data");
		b2 = new JButton("Insert data");
                b3 = new JButton("Sign out");
                add(b1);
                add(b2);
		add(b3);
                add(l1);		
                setLayout(null);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b1.setBounds(100,50,120,20);
		b2.setBounds(100,100,120,20);
		b3.setBounds(100,150,120,20);
		
		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		b3.setBackground(Color.black);
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);

                b1.addActionListener(this);
	b2.addActionListener(this);		
	b3.addActionListener(this);
                
	setSize(i.getIconWidth()+15,i.getIconHeight()+38);
        l1.setBounds(0,0,i.getIconWidth(),i.getIconHeight());
        
        setResizable(false);
        setLocation(
        (Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
        (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2
         );
		setVisible(true);                 
	}
            public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		
		if(o==b1)
		{
			
			new tab();
                        this.dispose(); 

		}
		if(o==b2)
		{
                        //new insertdata();
			new book();
                        this.dispose();
                }
		if(o==b3)
		{
			new Login_page();
			this.dispose();
		}				
			
	}	
	public static void main(String args[])
	{
		new Home_Page();
	}
}
