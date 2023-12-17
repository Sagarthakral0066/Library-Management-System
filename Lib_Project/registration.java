// To create Registration page of Book Record

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class registration extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JPasswordField t6;
	JButton b1,b2;
	
	Connection con,con1;
	PreparedStatement ps,ps1;
	ResultSet rs1;
	


	ImageIcon i;
	
	registration()
	{
		super("Book Registration Page");
                
		i = new ImageIcon("images//reg.jpg");
		l1 = new JLabel("Name : ");
		t1 = new JTextField(10);
                l6 = new JLabel(i);  
                 //for second label
                 l2= new JLabel("Contact no : ");
                 t2= new JTextField(10);
                 l3= new JLabel("Email : ");
                 t3= new JTextField(10);
                 l4= new JLabel("Username : ");
                 t4= new JTextField(10);
                 l5= new JLabel("Password : ");
                 t5= new JPasswordField(10);
                 

		b1 = new JButton("Submit");
		b2 = new JButton("Exit");	

			
		add(l1);
		add(t1);
                add(l2);
                add(t2);
                add(l3);
                add(t3);
                add(l4);
                add(t4);
                add(l5);
                add(t5);
		add(b1);
		add(b2);	
		setLayout(null);
		add(l6);
		l1.setBounds(20,50,120,20);
		t1.setBounds(100,50,100,20);
                l2.setBounds(20,80,120,20);
                t2.setBounds(100,80,100,20);
                l3.setBounds(20,110,120,20);
                t3.setBounds(100,110,100,20);
                 l4.setBounds(20,140,120,20);
                t4.setBounds(100,140,100,20);
                l5.setBounds(20,170,120,20);
                t5.setBounds(100,170,100,20);
              

		b1.setBounds(50,210,80,20);
		b2.setBounds(150,210,80,20);

	b1.addActionListener(this);
	b2.addActionListener(this);		
	        
                l1.setForeground(Color.white);
                l2.setForeground(Color.white);
                l3.setForeground(Color.white);
                l4.setForeground(Color.white);
                l5.setForeground(Color.white);
		
		setSize(i.getIconWidth(),i.getIconHeight()-50);	
		l6.setBounds(0,0,i.getIconWidth(),i.getIconHeight());

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
			String name=t1.getText();
			String cno=t2.getText();
                        String email=t3.getText();
                        String uname=t4.getText();
                        String pass=t5.getText();

		ps1=con1.prepareStatement("select * from register where uname=?");
		ps1.setString(1,uname);
		rs1=ps1.executeQuery();

		
		if(!(rs1.next()))
		{
		ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,cno);		
	        ps.setString(3,email);
                ps.setString(4,uname);
                ps.setString(5,pass);
		ps.executeUpdate();


JOptionPane.showMessageDialog(this,"Data Inserted","Done",JOptionPane.INFORMATION_MESSAGE);
		}//inner if
		else
		{
		t4.setForeground(Color.red);
		
JOptionPane.showMessageDialog(this,"Username already exist","Sorry",JOptionPane.ERROR_MESSAGE);	
		t4.setForeground(Color.black);

		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");

		}	



		}
		catch(Exception e)
		{
		}
		



		}//outer if


			
		if(o==b2)
		  {
 			new Login_page();
			this.dispose();
		}

				
	}	
	public static void main(String args[])
	{
		new registration();
	}
}





