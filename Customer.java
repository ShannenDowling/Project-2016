/**
 *@(#)Customer.java
 *
 *
 *@Shannen Dowling
 *@version 1.00 10/11/2016
 */
 
import javax.swing.*;

public class Customer extends Person{
	
	//declare attributes
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
	
	/**sets the account number of the Customer object
	 *@param account number of Bicycle object
	 **/
	public void setAccountNo(String accountNo){
		
		this.accountNo = accountNo;
	}
	
	/**sets the email of the Customer object
	 *@param email of Bicycle object
	 **/
	public void setEmail(String email){
		
		this.email = email;
	}
	
	/**sets the pin number of the Customer object
	 *@param pin number of Bicycle object
	 **/
	public void setPin(int pin){
		
		this.pin = pin;
	}
	
	/**sets the balance of the Customer object
	 *@param account  number of Bicycle object
	 **/
	public void setBalance(double balance){
		
		this.balance = balance;
	}


	//accessors
	/*public Person getCustomer(){
		
		return customer;
	}*/
	
	/**returns the account number of the Customer object
	 *@return String representation of account number of Customer object
	 **/
	public String getAccountNo(){
		
		return accountNo;
	}
	
	/**returns the emailof the Customer object
	 *@return String representation of email of Customer object
	 **/
	public String getEmail(){
		
		return email;
	}
	
	/**returns the pin number of the Customer object
	 *@return int representation of pin number of Customer object
	 **/
	public int getPin(){
		
		return pin;
	}
	
	/**returns the balance of the Customer object
	 *@return double representation of balance of Customer object
	 **/
	public double getBalance(){
		
		return balance;
	}
	
	
	
	public String toString(){
		
		return super.toString() + "\nAccountNo: " + accountNo + "\nEmail: " + email + "\nPassword: " + pin + "\nBalance: " + balance +"\n\n";
	}
}