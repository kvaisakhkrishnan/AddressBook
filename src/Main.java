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
	public static void addAddress(ArrayList<Address> addressBook) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Firstname: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Lastname: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter Address: ");
		String address = scanner.nextLine();
		System.out.println("Enter City: ");
		String city = scanner.nextLine();
		System.out.println("Enter State: ");
		String state = scanner.nextLine();
		System.out.println("Enter Zip: ");
		String zip = scanner.nextLine();
		System.out.println("Enter Phonenumber: ");
		String phoneNumber = scanner.nextLine();
		System.out.println("Enter Email: ");
		String email = scanner.nextLine();
		addressBook.add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		System.out.println("Address Added");
	}
	public static void main(String args[]) {
		ArrayList<Address> addressBook = new ArrayList<Address>();
		System.out.println("Welcome to Address Book");
		addAddress(addressBook);
	}

}
