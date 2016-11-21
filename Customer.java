//Customer.java
/**/

import javax.swing.*;

public class Customer extends Person{
	
	//attributes
	//private Person customer;
	private String accountNo;
	private String email;
	private int pin; 
	private double balance;
	
	
	//constructors
	public Customer(){
		
		super();
	
		accountNo = "Unknown";
		email = "No Email Specified";
		pin = 0000;
		balance = 0.0; 
	}
	
	public Customer(String accountNo, String email, int pin, double balance, 
					String name, int age, String address, String gender){
		
		super(name,age,address,gender);
		
		this.accountNo = accountNo;
		this.email = email;
		this.pin = pin;
		this.balance = balance;
	}
	
	
	//mutators
	/*public void setCustomer(String name, int age, String address, String gender){
		
		customer.setName(name);
		customer.setAge(age);
		customer.setAddress(address);
		customer.setGender(gender);
	}*/
	
	public void setAccountNo(String accountNo){
		
		this.accountNo = accountNo;
	}
	
	public void setEmail(String email){
		
		this.email = email;
	}
	
	public void setPin(int pin){
		
		this.pin = pin;
	}
	
	public void setBalance(double balance){
		
		this.balance = balance;
	}


	//accessors
	/*public Person getCustomer(){
		
		return customer;
	}*/
	
	public String getAccountNo(){
		
		return accountNo;
	}
	
	public String getEmail(){
		
		return email;
	}
	
	public int getPin(){
		
		return pin;
	}
	
	public double getBalance(){
		
		return balance;
	}
	
	
	
	public String toString(){
		
		return super.toString() + "\nAccountNo: " + accountNo + "\nEmail: " + email + "\nPassword: " + pin + "\nBalance: " + balance;
	}
}