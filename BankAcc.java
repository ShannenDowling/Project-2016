//BankAcc.java
/**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class BankAcc extends JFrame implements ActionListener{
	
	BankAcc acc1;
	JLabel logoLabel;
	JButton saveCustButton, cancelButton;
	JMenu fileMenu, customersMenu, optionsMenu;
	JLabel response;
	JTextArea display, calcList, custList;
	ArrayList<Customer> customers;
	Customer cust1 = new Customer();
	double bal;
	
	//customer
	String name, add, gender, accNo, email;  
	int age, pin;
	double balance;
	
	public static void main(String args[]){
		
		BankAcc acc1 = new BankAcc();
		acc1.setVisible(true);
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
		createCustomersMenu();
		createOptionsMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.orange);
		menuBar.add(fileMenu);
		menuBar.add(customersMenu);
		menuBar.add(optionsMenu);
		
		//logo
		logoLabel = new JLabel(new ImageIcon("logo.png"));//image from google images
		cPane.add(logoLabel);
		
		//response
		response = new JLabel();
		cPane.add(response);
		
		//label
		JLabel welcomeMsg = new JLabel("Welcome to your Bank Account.");
		cPane.add(welcomeMsg);
	
		//customer
		display = new JTextArea();
		cPane.add(display);
		
		calcList = new JTextArea();
		cPane.add(calcList);
		
		custList = new JTextArea();
		cPane.add(custList);
		
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
	private void createCustomersMenu(){
		
		JMenuItem item;
		
		customersMenu = new JMenu("Customers");
		
		item = new JMenuItem("List Customers");
		item.addActionListener(this);
		
		customersMenu.add(item);
		
		item = new JMenuItem("Add Customer");
		item.addActionListener(this);
		
		customersMenu.add(item);
		
		item = new JMenuItem("Remove Customer");
		item.addActionListener(this);
		
		customersMenu.add(item);
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
		
		item = new JMenuItem("Calculate Interest");
		item.addActionListener(this);
		
		optionsMenu.add(item);
	}
	
	//register
	public void register()
	{	
		cust1.setName(JOptionPane.showInputDialog(null,"Enter Name"));
		name = cust1.getName();
		 
		cust1.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Age")));
		age = cust1.getAge();
			
		cust1.setAddress(JOptionPane.showInputDialog(null,"Enter Address"));
		add = cust1.getAddress();
			 
		cust1.setGender(JOptionPane.showInputDialog(null,"Enter Gender"));
		gender = cust1.getAddress();
			
		cust1.setAccountNo(JOptionPane.showInputDialog(null,"Enter Account Number"));
		accNo = cust1.getAccountNo();		

		cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
		email = cust1.getEmail();
					
		cust1.setPin(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));
		pin = cust1.getPin();
			
		cust1.setBalance(Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Current Balance")));
		balance = cust1.getBalance();
					
		display.append("Customer Info: " + cust1.toString());
			
		Container cPane = getContentPane();
		cPane.add(saveCustButton);
		cPane.add(cancelButton);
	}
	
	public void login()
	{
		String adminEmail = "admin";
		int adminPin = 1234;
		
		cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
		cust1.setPin(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin"))); 
			
		if(cust1.getEmail() == adminEmail && cust1.getPin() == adminPin)
		{
			JOptionPane.showMessageDialog(null,"Welcome to the System","Welcome!",
			JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Error! Your email or pin was incorrect","Warning!",
			JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		
		//buttons	
		if(e.getSource() == saveCustButton)
		{
			JOptionPane.showMessageDialog(null,"Customer Saved", "Save", JOptionPane.INFORMATION_MESSAGE);
			
			customers = new ArrayList<Customer>();
			customers.add(new Customer (name, age, add, gender, accNo, email, pin, balance));
		}
			
		else if(e.getSource() == cancelButton)
		{
			display.setText("You selected Cancel\nNo Customer Added");
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
		
			//fileMenu
			else if(menuName.equals("Register"))
			{
				display.setVisible(true);
				register();
			}
			
			else if(menuName.equals("Login"))
			{
				login();	
			}
			
			//customerMenu
			else if(menuName.equals("List Customers"))
			{
				if(customers.size()<1)
				{
					custList.setText("No Customers to display");
				}
				
				else
				{
					display.setVisible(false);
					custList.setVisible(true);
					
					for(int x=0; x<customers.size(); x++)
					{
						custList.append(customers.get(x).toString());
					}
				}	
			}
			
			else if(menuName.equals("Add Customer"))
			{
				display.setVisible(true);
				custList.setVisible(false);
				
				register();	
			}
			
			else if(menuName.equals("Remove Customer"))
			{
				String custName, cust;
					
				custName = JOptionPane.showInputDialog(null, "Please enter the name of the customer would you like to remove?");
				
				cust = cust1.getName();
				
				if(custName == cust)
				{
					customers.remove(cust);
				}
			}
			
			//optionsMenu
			else if(menuName.equals("Withdraw"))
			{
				display.setVisible(true);
				custList.setVisible(false);
				
				double amount;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is €" + String.format("%.2f",bal));
				
				amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the amount you would like to withdraw"));
				calcList.append("\nWithdrawal Amount: €" + String.format("%.2f",amount));
				
				bal -= amount;
				calcList.append("\nYour new balance is €" + String.format("%.2f",bal));
			}
			
			else if(menuName.equals("Lodge"))
			{
				display.setVisible(true);
				custList.setVisible(false);
				
				double amount;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is €" + String.format("%.2f",balance));
				
				amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the amount you would like to lodge to your account"));
				calcList.append("\nLodgement Amount: €" + String.format("%.2f",amount));
				
				bal += amount;
				calcList.append("\nYour new balance is €" + String.format("%.2f",bal));
			}
			
			else if(menuName.equals("Calculate Interest"))
			{
				display.setVisible(true);
				custList.setVisible(false);
				
				double intDue;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is €" + String.format("%.2f",bal));
				
				if(bal<0)
				{
					JOptionPane.showMessageDialog(null,"Error! Invalid Balance", "Error", JOptionPane.WARNING_MESSAGE);	
				}
				
				else if(bal<1000)
				{
					calcList.append("\nInterest Rate: 5%");

					intDue = balance * 0.05f;
					calcList.append("\nInterest Due this month is €" + String.format("%.2f", intDue));	
				}
				
				else
				{
					calcList.append("\nInterest Rate: 10%");

					intDue = balance * 0.10f;
					calcList.append("\nInterest Due this month is €" + String.format("%.2f", intDue));
				}
				
			}
			
			else 
			{
				response.setText("Menu Item '" + menuName + "' is selected");
			}	
		}
	}	
}