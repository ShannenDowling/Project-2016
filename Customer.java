//Customer.java
/**/

public class Customer{
	
	//attributes
	private Person customer;
	private String accountNo;
	private String email;
	private int pin; 
	private double balance;
	private double intRate;
	
	
	//constructors
	public Customer(){
		
		customer = new Person();
		
		accountNo = "Unknown";
		email = "No Email Specified";
		pin = 1234;
		balance = 0.0;
		intRate = 0.0; 
	}
	
	public Customer(String accountNo, String email, int pin, double balance, double intRate){
		
		this.accountNo = accountNo;
		this.email = email;
		this.pin = pin;
		this.balance = balance;
		this.intRate = intRate;
	}
	
	
	//mutators
	public void setCustomer(String name, int age, String address, char gender){
		
		customer.setName(name);
		customer.setAge(age);
		customer.setAddress(address);
		customer.setGender(gender);
	}
	
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

	public void setIntRate(double intRate){
		
		this.intRate = intRate;
	}
	
	//accessors
	public Person getCustomer(){
		
		return customer;
	}
	
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
	
	public double getIntRate(){
		
		return intRate;
	}
	
	
	public String toString(){
		
		return customer + "\nAccountNo: " + accountNo + "\nEmail: " + email + "\nPassword: " + pin + "\nBalance: " + balance + "\nInterest Rate: " + intRate + "%";
	}
}