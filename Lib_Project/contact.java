// Home Page of the project.


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


class contact extends JFrame 
{
	JLabel l1;
	ImageIcon i;
	contact()
	{
		super("If any query,contact us");
                i = new ImageIcon("C:/Users/Lenovo/Desktop/library management system/Lib_Project/images/contact.jpeg");
                l1 = new JLabel(i);
                add(l1);		
                setLayout(null);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
                
	setSize(i.getIconWidth()+15,i.getIconHeight()+38);
        l1.setBounds(0,0,i.getIconWidth(),i.getIconHeight());
        
        setResizable(false);
        setLocation(
        (Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
        (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2
         );
		setVisible(true);                 
	}
            		
			
		
	public static void main(String args[])
	{
		new contact();
	}
}
