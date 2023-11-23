import java.util.*;
class Address{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;
	
	Address(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}

public class Main {
	public static void main(String args[]) {
		ArrayList<Address> addressBook = new ArrayList<Address>();
		System.out.println("Welcome to Address Book");
	}
}
