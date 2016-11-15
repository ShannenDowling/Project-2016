//Person.java
/**/

public class Person{
	
	//attributes
	private String name;
	private int age;
	private String address;
	private char gender;
	
	
	//constructors
	public Person(){
		
		this("Unknown", 0, "No Address Specified", 'U');
	}
	
	public Person(String name, int age, String address, char gender){
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}
	
	
	//mutators
	public void setName(String name){
		
		this.name = name;
	} 
		
	public void setAge(int age){
		
		this.age = age;
	}
	
	public void setAddress(String address){
		
		this.address = address;
	}
	
	public void setGender(char gender){
		
		this.gender = gender;
	}
	
	
	//accessors
	public String getName(){
		
		return name;
	}
	
	public int getAge(){
		
		return age;
	}

	public String getAddress(){
		
		return address;
	}
	
	public char getGender(){
		
		return gender;
	}
	
	
	
	public String toString(){
		
		return name + "\t" + age + "\t " + address + "\t" + gender;
	}
}