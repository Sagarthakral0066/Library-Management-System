// To create Registration page of Book Record

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class book extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	
	JButton b1,b2,b3,b4;
	
	Connection con,con1;
	PreparedStatement ps,ps1;
	ResultSet rs1;
	


	ImageIcon i,i1,i2;
	
	book()
	{
		super("Book Details Page");
                
		i = new ImageIcon("images//h2.jpg");
                i1 = new ImageIcon("images//hp1.jpg");
		i2 = new ImageIcon("images//signoutp.jpg");
		l1 = new JLabel("Bid : ");
		t1 = new JTextField(10);
                l5 = new JLabel(i);  
                 //for second label
                 l2= new JLabel("Bname : ");
                 t2= new JTextField(10);
                 l3= new JLabel("Bauthor : ");
                 t3= new JTextField(10);
                 l4= new JLabel("Bprice : ");
                 t4= new JTextField(10);
                 
                 

		b1 = new JButton("Insert");
		b2 = new JButton("Exit");
                b3 = new JButton(i1);	
		b4 = new JButton(i2);
			
		add(l1);
		add(t1);
                add(l2);
                add(t2);
                add(l3);
                add(t3);
                add(l4);
                add(t4);
                add(b1);
                add(b2);
                add(b3);
		add(b4);
                	
		setLayout(null);
		add(l5);
		l1.setBounds(20,50,120,20);
		t1.setBounds(100,50,100,20);
                l2.setBounds(20,80,120,20);
                t2.setBounds(100,80,100,20);
                l3.setBounds(20,110,120,20);
                t3.setBounds(100,110,100,20);
                 l4.setBounds(20,140,120,20);
                t4.setBounds(100,140,100,20);
                

		b1.setBounds(50,180,80,20);
		b2.setBounds(150,180,80,20);
                b3.setBounds(80,240,i1.getIconWidth(),i1.getIconHeight());
		 b4.setBounds(180,240,i2.getIconWidth(),i2.getIconHeight());
	b1.addActionListener(this);
	b2.addActionListener(this);
        b3.addActionListener(this);
	b4.addActionListener(this);		
	        
                l1.setForeground(Color.black);
                l2.setForeground(Color.black);
                l3.setForeground(Color.black);
                l4.setForeground(Color.black);
               
		
		setSize(i.getIconWidth(),i.getIconHeight()-50);	
		l5.setBounds(0,0,i.getIconWidth(),i.getIconHeight());

		setResizable(false);

		setLocation(
		(Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
		(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2
		);

		try		
		{
		Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
	con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");	
		}
		catch(Exception e)
		{
		}

		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		
		if(o==b1)
		{
                
			try
			{
			String bid=t1.getText();
			String bname=t2.getText();
                        String bauthor=t3.getText();
                        String bprice=t4.getText();
                        

		ps=con.prepareStatement("insert into book values(?,?,?,?)");
		ps.setString(1,bid);
		ps.setString(2,bname);		
	        ps.setString(3,bauthor);
                ps.setString(4,bprice);
		ps.executeUpdate();


JOptionPane.showMessageDialog(this,"Data Inserted","Done",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e)
		{
		}

		
		}	



			if(o==b2)
			 {
      
			   new Home_Page();
			   this.dispose();

                         }
			;
                      
                        if(o==b3)
                         {
      
			   new Home_Page();
			   this.dispose();

                         }
			 if(o==b4)
                         {
      
			   new Login_page();
			   this.dispose();
                         }
	}	
	public static void main(String args[])
	{
		new book();
	}
}





