// Create a login page of Book Record

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;

class Login_page extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3,b4;

	LineBorder lb;	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	ImageIcon i;
	
	Login_page()
	{
		super("Book Record Login Page");
                //For first label
		lb = new LineBorder(Color.red,3);
		i = new ImageIcon("images//login.jpg");
		l1 = new JLabel("Username : ");
		t1 = new JTextField(10);
                l3 = new JLabel(i);
		l3.setBorder(lb);  
                 //for second label
                 l2= new JLabel("Password : ");
                 t2= new JPasswordField(10);

		b1 = new JButton("Submit");
		b2 = new JButton("Exit");	
		b3 = new JButton("New User");
		b4 = new JButton("Contact us");
			
		add(l1);
		add(t1);
                add(l2);
                add(t2);
		add(b1);
		add(b2);	
		setLayout(null);
		add(b3);
		add(b4);
		add(l3);
		
		l1.setBounds(20,50,120,20);
		t1.setBounds(100,50,100,20);
                l2.setBounds(20,100,120,20);
                t2.setBounds(100,100,100,20);
		b1.setBounds(50,200,80,20);
		b2.setBounds(150,200,80,20);
		b3.setBounds(250,200,110,20);
		b4.setBounds(400,200,110,20);


	b1.addActionListener(this);
	b2.addActionListener(this);		
	b3.addActionListener(this);
	b4.addActionListener(this);
	        
	        
                l1.setForeground(Color.yellow);
                l2.setForeground(Color.yellow);
		t1.setBackground(Color.white);
		t1.setForeground(Color.blue);
                t2.setBackground(Color.white);
		t2.setForeground(Color.blue);
	
		setSize(i.getIconWidth()+15,i.getIconHeight()+38);	
		l3.setBounds(0,0,i.getIconWidth(),i.getIconHeight());

		setResizable(false);

		setLocation(
		(Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
		(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2
		);

		try		
		{
		Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
		}
		catch(Exception e)
		{
		}
		
		//setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		
		if(o==b1)
		{
			try
			{
			String un=t1.getText();
			String pw=t2.getText();

		ps=con.prepareStatement("select * from register where uname=? and pass=?");
		ps.setString(1,un);
		ps.setString(2,pw);		
	
		rs=ps.executeQuery();


			if(rs.next())
			{ 
JOptionPane.showMessageDialog(this,"Valid User","Done",JOptionPane.INFORMATION_MESSAGE);
			new Home_Page();
			this.dispose();


			}
			else
JOptionPane.showMessageDialog(this,"Invalid User","Sorry",JOptionPane.ERROR_MESSAGE);		
			}
			catch(Exception e)
			{
			}
		}
			if(o==b2)
				System.exit(0);
		if(o==b3)
		{
			new registration();
			this.dispose();
		}
		if(o==b4)
		{
			new contact();
			this.dispose();
		}
			
	}	
	public static void main(String args[])
	{
		new Login_page();
	}
}





