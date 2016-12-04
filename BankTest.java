//BankTest.java
/**/

import javax.swing.*;

public class BankTest{
	public static void main(String args[])
	{
		Customer cust1 = new Customer();
				
		cust1.setCustomer("Shannen", 20, "Ardfert", 'F');
		cust1.setAccountNo("12345678A");
		cust1.setEmail("shannendowling196@hotmail.com");
		cust1.setPin(1234);
		cust1.setBalance(100.0);
		cust1.setIntRate(5.5);
		
		JOptionPane.showMessageDialog(null, cust1.toString(), "Bank test", JOptionPane.PLAIN_MESSAGE);
	}
}