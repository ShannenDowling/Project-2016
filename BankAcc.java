//BankAcc.java
/**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BankAcc extends JFrame implements ActionListener{
	
	JButton registerButton, loginButton;
	JMenu fileMenu, accountsMenu, optionsMenu;
	JLabel response;
	
	public static void main(String args[]){
		
		BankAcc acc1 = new BankAcc();
		acc1.setVisible(true);
		
		BankAcc menu = new BankAcc();
		menu.setVisible(true);
		
		BankAcc registerButton = new BankAcc();
		BankAcc loginButton = new BankAcc();
		registerButton.setVisible(true);
		loginButton.setVisible(true);
	}
	
	public BankAcc(){
		//window
		super("Bank Account");
		
		setSize(400,500);
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowEventHandler());
		
		Container cPane = getContentPane();
		cPane.setLayout(new FlowLayout());
		cPane.setBackground(Color.lightGray);
		
		//menu
		createFileMenu();
		createAccountsMenu();
		createOptionsMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.orange);
		menuBar.add(fileMenu);
		menuBar.add(accountsMenu);
		menuBar.add(optionsMenu);
		
		//response
		response = new JLabel("Menu tester");
		//respone.setSize(250,50);
		cPane.add(response);
		
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
	
	//fileMenu
	private void createFileMenu(){
		
		JMenuItem item;
		
		fileMenu = new JMenu("File");
		
		item = new JMenuItem("Login");
		item.addActionListener(this);
		
		fileMenu.add(item);
		
		item = new JMenuItem("Check Balance");
		item.addActionListener(this);
		
		fileMenu.add(item);
		
		item = new JMenuItem("Quit");
		item.addActionListener(this);
		
		fileMenu.add(item);
	}
	
	//accountsMenu
	private void createAccountsMenu(){
		
		JMenuItem item;
		
		accountsMenu = new JMenu("Accounts");
		
		item = new JMenuItem("Add");
		item.addActionListener(this);
		
		accountsMenu.add(item);
		
		item = new JMenuItem("Remove");
		item.addActionListener(this);
		
		accountsMenu.add(item);
		
		item = new JMenuItem("Update");
		item.addActionListener(this);
		
		accountsMenu.add(item);
	}
	
	//optionsMenu
	private void createOptionsMenu(){
		
		JMenuItem item;
		
		optionsMenu = new JMenu("Options");
		
		item = new JMenuItem("Withdraw");
		item.addActionListener(this);
		
		optionsMenu.add(item);
		
		item = new JMenuItem("Lodge");
		item.addActionListener(this);
		
		optionsMenu.add(item);
		
		item = new JMenuItem("Interest");
		item.addActionListener(this);
		
		optionsMenu.add(item);
	}
	
	
	public void actionPerformed(ActionEvent e){
		//buttons	
		if(e.getSource() == registerButton)	
		{
			JOptionPane.showInputDialog(null,"Please enter your name");
			
			JOptionPane.showInputDialog(null,"Please enter your email");
		}
			
		else if(e.getSource() == loginButton)
		{
			JOptionPane.showInputDialog(null,"Please enter your email");
			
			JOptionPane.showInputDialog(null,"Please enter your password");	
		}
		//menu
		else
		{
			String menuName;
		
			menuName = e.getActionCommand();
		
			if(menuName.equals("Quit"))
			{
				System.exit(0);
			}
		
			else 
			{
				response.setText("Menu Item '" + menuName + "' is selected");
			}	
		}
	}
}