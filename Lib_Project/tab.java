import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class tab extends JFrame implements ActionListener
{  
	JTabbedPane tp;
	JFrame f;  
	JComboBox jc;
	JButton b,b1,b2;
	JTable t,t1;
	DefaultTableModel tm,tm1;
	ImageIcon i1,i2;
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	Connection con1,con2;
	PreparedStatement ps2;
	ResultSet rs1,rs2;	
	JPanel p1,p2;
	Statement st1;
	
	tab()
	{  
		i1=new ImageIcon("images//hp1.jpg");
		i2=new ImageIcon("images//signoutp.jpg");
   	 	p1=new JPanel();  
    		p2=new JPanel();  
     
   	 	tp=new JTabbedPane();  
   	 	tp.setBounds(50,50,530,500);  
    		tp.add("All",p1);  
    		tp.add("Search",p2);  
     	
		jc=new JComboBox();
		p2.add(jc);
		b=new JButton("Search Book");		
	  	p2.add(b);
		
		b1=new JButton(i1);
		b2=new JButton(i2);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		add(tp);  
    		
	
		p2.setLayout(null);
		jc.setBounds(100,70,130,20);
		b.setBounds(250,70,130,20);
		b.addActionListener(this);

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");

	
		ps=con.prepareStatement("select * from book");
		rs=ps.executeQuery();
		while(rs.next())
		{
			jc.addItem(rs.getString(2));
		}

		}
		catch(Exception e)
		{
		}
		

		// To add table in panel 1
		tm=new DefaultTableModel();
		t=new JTable(tm);
		t.setBounds(100,100,600,600);
   		
		tm.addColumn("Bid");
		tm.addColumn("Bname");
		tm.addColumn("Bauthor");
		tm.addColumn("Bprice");
		
		
		String query = "select * from book";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
			st1 = con1.createStatement();
			rs1 = st1.executeQuery(query);	

			tm.addRow(new Object[]{"Bid", "Bname", "Bauthor", "Bprice"});

			while(rs1.next()){
				String Bid= rs1.getString(1);
				String Bname = rs1.getString(2);
				String Bauthor = rs1.getString(3);
				String Bprice = rs1.getString(4);
				
				tm.addRow(new Object[]{Bid,Bname,Bauthor,Bprice});
			}
			st1.close();
			con1.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		p1.add(t);
		p1.add(b1);
		b1.setBounds(40,130,i1.getIconWidth(),i1.getIconHeight());
		b1.addActionListener(this);
		p2.add(b2);
			b2.setBounds(100,230,i2.getIconWidth(),i2.getIconHeight());
		      b2.addActionListener(this);
		

		setSize(600,400);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
		(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
		setVisible(true);

			
		// to add table in panel 2
	}
	
		public void actionPerformed(ActionEvent ae)
		{
			Object o =ae.getSource();
			if(o==b)
     			{    
				tm1=new DefaultTableModel();
				t1=new JTable(tm1);
				t1.setBounds(100,100,450,100);
   		
			tm1.addColumn("Bid");
			tm1.addColumn("Bname");
			tm1.addColumn("Bauthor");
			tm1.addColumn("Bprice");
			p2.add(t1);
			
		
		
			    try
                             {

			con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
			
			
			ps2=con2.prepareStatement("Select * from book where bname=?");
		System.out.println("===== "+(String)jc.getSelectedItem());
                 	ps2.setString(1,(String)jc.getSelectedItem());
			rs2=ps2.executeQuery();	

			tm1.addRow(new Object[]{"Bid", "Bname", "Bauthor", "Bprice"});

			while(rs2.next()){
				String Bid= rs2.getString(1);
				String Bname = rs2.getString(2);
				String Bauthor = rs2.getString(3);
				String Bprice = rs2.getString(4);
				
				tm1.addRow(new Object[]{Bid,Bname,Bauthor,Bprice});

				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}//if

			if(o==b1)
			{
				new Home_Page();
				this.dispose();
			}
			if(o==b2)
			{
				new Login_page();
				this.dispose();
			}

		
	}  
	public static void main(String[] args) 
	{  
   	 	new tab();  
	}
}  