//BankAcc.java
/**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

@SuppressWarnings({"unchecked", "deprication"})

public class BankAcc extends JFrame implements ActionListener{
	
	BankAcc acc1;
	JLabel logoLabel;
	JButton registerButton, loginButton, saveCustButton, cancelButton;
	JMenu fileMenu, customersMenu, optionsMenu;
	JLabel buttonLabel, response;
	JTextArea display, calcList, custList;
	
	Customer cust1 = new Customer();
	ArrayList<Customer> customers;
	
	//calculations
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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
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
		
		buttonLabel = new JLabel("Please Register or Login: ");
		cPane.add(buttonLabel);
		
		//register
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		cPane.add(registerButton);
		
		//login
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		cPane.add(loginButton);
		
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
		}
	}
	
	//fileMenu
	private void createFileMenu(){
		
		JMenuItem item;
		
		fileMenu = new JMenu("File");
		
		item = new JMenuItem("Login");
		item.addActionListener(this);
		
		fileMenu.add(item);
		
		item = new JMenuItem("Open");
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
	public void add()
	{	
		cust1.setName(JOptionPane.showInputDialog(null,"Enter Name"));
		name = cust1.getName();
		 
		cust1.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Age")));
		age = cust1.getAge();
			
		cust1.setAddress(JOptionPane.showInputDialog(null,"Enter Address"));
		add = cust1.getAddress();
			 
		cust1.setGender(JOptionPane.showInputDialog(null,"Enter Gender"));
		gender = cust1.getGender();
			
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
			
		if(cust1.getEmail().equals(adminEmail) && cust1.getPin() == adminPin)
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
	
	public void save() throws IOException
	{
		File bankFile = new File("myCustomers.dat");
		FileOutputStream outputStream = new FileOutputStream(bankFile);
		ObjectOutputStream oob = new ObjectOutputStream(outputStream);					//code from examples on x drive
		oob.writeObject(customers);
		oob.close();
	}
	
	public void open()
	{
		try
		{
			ObjectInputStream input;
      		input = new ObjectInputStream(new FileInputStream ("myCustomers.dat"));
        	customers  = (ArrayList<Customer>) input.readObject();							//code from examples on x drive
      		input.close();
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();		
		}	
	}
	
	public void actionPerformed(ActionEvent e){
		
		//buttons
		if(e.getSource() == registerButton)
		{
			add();
			
			registerButton.setVisible(false);
			loginButton.setVisible(false);
			buttonLabel.setVisible(false);
		}	
			
		else if(e.getSource() == loginButton)
		{
			login();
			
			registerButton.setVisible(false);
			loginButton.setVisible(false);
			buttonLabel.setVisible(false);	
		}
			
		else if(e.getSource() == saveCustButton)
		{
			JOptionPane.showMessageDialog(null,"Customer Saved", "Save", JOptionPane.INFORMATION_MESSAGE);
			
			customers = new ArrayList<Customer>();
			customers.add(new Customer (name, age, add, gender, accNo, email, pin, balance));
			
			try{
      	 		save();
      	 		JOptionPane.showMessageDialog(null,"Data saved successfully");
      	 	}
      	 	catch (IOException f){
      	 		JOptionPane.showMessageDialog(null,
      	 		"Not able to save the file:\nCheck the console printout for clues to why ");
      	 		f.printStackTrace();
			}
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
			else if(menuName.equals("Open"))
			{
				open();
			}
			
			else if(menuName.equals("Login"))
			{
				login();	
			}
			
			//customerMenu
			else if(menuName.equals("List Customers"))
			{
				calcList.setVisible(false);
				saveCustButton.setVisible(false);
				cancelButton.setVisible(false);
				
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
				calcList.setVisible(false);
				display.setVisible(true);
				custList.setVisible(false);
				saveCustButton.setVisible(true);
				cancelButton.setVisible(true);
				
				add();	
			}
			
			else if(menuName.equals("Remove Customer"))
			{
				calcList.setVisible(false);
				custList.setVisible(true);
				
				int cust;
					
				cust = Integer.parseInt(JOptionPane.showInputDialog(null, "Which customer would you like to remove?"));
				
				customers.remove(cust);
			}
			
			//optionsMenu
			else if(menuName.equals("Withdraw"))
			{
				calcList.setVisible(true);
				display.setVisible(false);
				custList.setVisible(false);
					
				double amount;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is �" + String.format("%.2f",bal));
				
				amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the amount you would like to withdraw"));
				calcList.append("\nWithdrawal Amount: �" + String.format("%.2f",amount));
				
				bal -= amount;
				calcList.append("\nYour new balance is �" + String.format("%.2f",bal));
			}
			
			else if(menuName.equals("Lodge"))
			{
				calcList.setVisible(true);
				display.setVisible(false);
				custList.setVisible(false);
				
				double amount;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is �" + String.format("%.2f",balance));
				
				amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the amount you would like to lodge to your account"));
				calcList.append("\nLodgement Amount: �" + String.format("%.2f",amount));
				
				bal += amount;
				calcList.append("\nYour new balance is �" + String.format("%.2f",bal));
			}
			
			else if(menuName.equals("Calculate Interest"))
			{
				calcList.setVisible(true);
				display.setVisible(false);
				custList.setVisible(false);
				
				double intDue;
				
				bal = cust1.getBalance();
				calcList.setText("Your current balance is �" + String.format("%.2f",bal));
				
				if(bal<0)
				{
					JOptionPane.showMessageDialog(null,"Error! Invalid Balance", "Error", JOptionPane.WARNING_MESSAGE);	
				}
				
				else if(bal<1000)
				{
					calcList.append("\nInterest Rate: 5%");

					intDue = balance * 0.05f;
					calcList.append("\nInterest Due this month is �" + String.format("%.2f", intDue));	
				}
				
				else
				{
					calcList.append("\nInterest Rate: 10%");

					intDue = balance * 0.10f;
					calcList.append("\nInterest Due this month is �" + String.format("%.2f", intDue));
				}
				
			}
			
			else 
			{
				response.setText("Menu Item '" + menuName + "' is selected");
			}	
		}
	}	
}