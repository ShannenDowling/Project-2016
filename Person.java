/**
 *@(#)Person.java
 *
 *
 *@Shannen Dowling
 *@version 1.00 10/11/2016
 */
 
public class Person{
	
	//attributes
	private String name;
	private int age;
	private String address;
	private String gender;
	
	
	//constructors
	public Person(){
		
		this("Unknown", 0, "No Address Specified", "U");
	}
	
	public Person(String name, int age, String address, String gender){
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}
	
	
	//mutators
	/**sets the name of the Person object
	 *@param name of Person object
	 **/
	public void setName(String name){
		
		this.name = name;
	} 
	
	/**sets the age of the Person object
	 *@param age of Person object
	 **/	
	public void setAge(int age){
		
		this.age = age;
	}
	
	/**sets the address of the Person object
	 *@param address of Person object
	 **/
	public void setAddress(String address){
		
		this.address = address;
	}
	
	/**sets the gender of the Person object
	 *@param gender of Person object
	 **/
	public void setGender(String gender){
		
		this.gender = gender;
	}
	
	
	//accessors
	/**returns the name of the Person object
	 *@return String representation of name of Person object
	 **/
	public String getName(){
		
		return name;
	}
	
	/**returns the age of the Person object
	 *@return integer representation of age of Person object
	 **/
	public int getAge(){
		
		return age;
	}

	/**returns the address of the Person object
	 *@return String representation of address of Person object
	 **/
	public String getAddress(){
		
		return address;
	}
	
	/**returns the gender of the Person object
	 *@return String representation of gender of Person object
	 **/
	public String getGender(){
		
		return gender;
	}
	
	
	
	public String toString(){
		
		return name + ", " + age + ", " + address + ", " + gender;
	}
}