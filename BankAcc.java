//BankAcc.java
/**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BankAcc extends JFrame implements ActionListener{
	
	JButton registerButton, loginButton;
	
	public static void main(String args[]){
		
		BankAcc acc1 = new BankAcc();
		acc1.setVisible(true);
		
		BankAcc registerButton = new BankAcc();
		BankAcc loginButton = new BankAcc();
		registerButton.setVisible(true);
		loginButton.setVisible(true);
	}
	
	public BankAcc(){
		//window
		super("Bank Account");
		
		setSize(400,500);
		setLocation(100,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowEventHandler());
		
		Container cPane = getContentPane();
		cPane.setLayout(new FlowLayout());
		cPane.setBackground(Color.lightGray);
		
		//label
		JLabel welcomeMsg = new JLabel("Welcome to your Bank Account.");
		cPane.add(welcomeMsg);
		
		//buttons
		registerButton = new JButton("Register");
		loginButton = new JButton("Login");
		
		cPane.add(registerButton);
		cPane.add(loginButton);
		
		registerButton.addActionListener(this);
		loginButton.addActionListener(this);
	}
	//window
	private class WindowEventHandler extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			JOptionPane.showMessageDialog(null,"Closing Window", "Closing",
			JOptionPane.WARNING_MESSAGE);
			
			System.exit(0);
		}
	}
	//buttons
	public void actionPerformed(ActionEvent e){
			
		if(e.getSource() == registerButton)	
		{
			JOptionPane.showInputDialog(null,"Please enter your name");
			
			JOptionPane.showInputDialog(null,"Please enter your email");
		}
			
		else
		{
			JOptionPane.showInputDialog(null,"Please enter your email");
			
			JOptionPane.showInputDialog(null,"Please enter your password");	
		}
	}
}