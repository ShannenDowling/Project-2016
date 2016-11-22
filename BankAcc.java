//BankAcc.java
/**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class BankAcc extends JFrame implements ActionListener{
	
	BankAcc acc1;
	JButton registerButton, loginButton, saveCustButton, cancelButton;
	JMenu fileMenu, accountsMenu, optionsMenu;
	JLabel response;
	JTextArea display;
	ArrayList<Customer> customers;
	
	public static void main(String args[]){
		
		BankAcc acc1 = new BankAcc();
		acc1.setVisible(true);
		
		BankAcc menu = new BankAcc();
		menu.setVisible(true);
		
		BankAcc registerButton = new BankAcc();
		BankAcc loginButton = new BankAcc();
		registerButton.setVisible(true);
		loginButton.setVisible(true);
		
		BankAcc saveCustButton = new BankAcc();
		saveCustButton.setVisible(true);
		
		BankAcc cancelButton = new BankAcc();
		cancelButton.setVisible(true);
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
		response = new JLabel();
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
		
		//customer
		display = new JTextArea();
		cPane.add(display);
		
		//saveCust
		saveCustButton = new JButton("Save Customer");
		saveCustButton.addActionListener(this);
		
		//cancel
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
	}
	
	//window
	private class WindowEventHandler extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to Exit?", 
			"Closing", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			
			if(confirm == 0)
			{
				System.exit(0);
			}
			
			else
			{
				acc1.setVisible(true);
			}
		}
	}
	
	//fileMenu
	private void createFileMenu(){
		
		JMenuItem item;
		
		fileMenu = new JMenu("File");
		
		item = new JMenuItem("Register");
		item.addActionListener(this);
		
		fileMenu.add(item);
		
		item = new JMenuItem("Login");
		item.addActionListener(this);
		
		fileMenu.add(item);
		
		item = new JMenuItem("Quit");
		item.addActionListener(this);
		
		fileMenu.add(item);
	}
	
	//accountsMenu
	private void createAccountsMenu(){
		
		JMenuItem item;
		
		accountsMenu = new JMenu("Customers");
		
		item = new JMenuItem("List Customers");
		item.addActionListener(this);
		
		accountsMenu.add(item);
		
		item = new JMenuItem("Add Customer");
		item.addActionListener(this);
		
		accountsMenu.add(item);
		
		item = new JMenuItem("Remove Customer");
		item.addActionListener(this);
		
		accountsMenu.add(item);
	}
	
	//optionsMenu
	private void createOptionsMenu(){
		
		JMenuItem item;
		
		optionsMenu = new JMenu("Banking Options");
		
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
	
	//register
	public void register()
	{
		Customer cust1 = new Customer();
			
			cust1.setName(JOptionPane.showInputDialog(null,"Enter Name"));
			cust1.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Age")));
			cust1.setAddress(JOptionPane.showInputDialog(null,"Enter Address"));
			cust1.setGender(JOptionPane.showInputDialog(null,"Enter Gender"));
			cust1.setAccountNo(JOptionPane.showInputDialog(null,"Enter Account Number"));
			cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
			cust1.setPin(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));
			cust1.setBalance(Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Current Balance")));
		
		customers = new ArrayList<Customer>();
		customers.add(cust1);
				
		display.append("Customer Info: " + cust1.toString());
			
		Container cPane = getContentPane();
		cPane.add(saveCustButton);
		cPane.add(cancelButton);
	}
	
	public void login()
	{
		Customer cust1 = new Customer();
		
			cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
			cust1.setPin(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));
	}
	
	public void actionPerformed(ActionEvent e){
		
		//buttons	
		if(e.getSource() == registerButton)	
		{
			register();
		}
			
		else if(e.getSource() == loginButton)
		{
			login();	
		}
		
		else if(e.getSource() == saveCustButton)
		{
			JOptionPane.showMessageDialog(null,"You selected save", "Save", JOptionPane.INFORMATION_MESSAGE);
		}
			
		else if(e.getSource() == cancelButton)
		{
			display.setText("No Customer Added");
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
		
			else if(menuName.equals("Register"))
			{
				register();
			}
			
			else if(menuName.equals("Login"))
			{
				login();	
			}
			
			/*else if(menuName.equals("List Customers"))
			{
				
			}*/
			
			else if(menuName.equals("Add Customer"))
			{
				register();
			}
			
			else if(menuName.equals("Remove Customer"))
			{
				String CustNum = JOptionPane.showInputDialog(null, "Please enter the name of the customer would you like to remove?");
				
				customers.remove(CustNum);
			}
			
			else 
			{
				response.setText("Menu Item '" + menuName + "' is selected");
			}	
		}
	}	
}