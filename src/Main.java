import java.util.*;
class Address{
	private String firstName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		System.out.println("--------------ADD--------------");
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
	public static void editAddress(ArrayList<Address> addressBook) {
		System.out.println("--------------UPDATE--------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Firstname: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Lastname: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter New Address: ");
		String address = scanner.nextLine();
		System.out.println("Enter New City: ");
		String city = scanner.nextLine();
		System.out.println("Enter New State: ");
		String state = scanner.nextLine();
		System.out.println("Enter New Zip: ");
		String zip = scanner.nextLine();
		System.out.println("Enter New Phonenumber: ");
		String phoneNumber = scanner.nextLine();
		System.out.println("Enter New Email: ");
		String email = scanner.nextLine();
		System.out.println("Searching Address Book");
		int flag = 0;
		for(int i = 0; i < addressBook.size(); i++) {
			if(addressBook.get(i).getFirstName().equals(firstName) && addressBook.get(i).getLastName().equals(lastName)) {
				flag = 1;
				addressBook.get(i).setAddress(address);
				addressBook.get(i).setCity(city);
				addressBook.get(i).setState(state);
				addressBook.get(i).setZip(zip);
				addressBook.get(i).setPhoneNumber(phoneNumber);
				addressBook.get(i).setEmail(email);
				break;
			}
		}
		if(flag == 1) {
			System.out.println("Updated Address");
		}
		else {
			System.out.println("Address Not Found");
		}
	}
	public static void deleteAddress(ArrayList<Address> addressBook) {
		System.out.println("--------------DELETE--------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Firstname: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Lastname: ");
		String lastName = scanner.nextLine();
		System.out.println("Searching Address Book");
		int flag = 0;
		for(int i = 0; i < addressBook.size(); i++) {
			if(addressBook.get(i).getFirstName().equals(firstName) && addressBook.get(i).getLastName().equals(lastName)) {
				flag = 1;
				addressBook.remove(i);
				break;
			}
		}
		if(flag == 1) {
			System.out.println("Deleted Address");
		}
		else {
			System.out.println("Address Not Found");
		}
	}
	public static void main(String args[]) {
		ArrayList<Address> addressBook = new ArrayList<Address>();
		System.out.println("Welcome to Address Book");
		while(true) {
			System.out.println("1. Add address\n2. Update Address\n3. Delete Address\4.Exit");
			int count;
			Scanner scanner = new Scanner(System.in);
			count = scanner.nextInt();
			
			if(count == 1) {
				addAddress(addressBook);
				
			}
			else if(count == 2) {
				editAddress(addressBook);
				
			}
			else if(count == 3) {
				deleteAddress(addressBook);
			}
			else {
				break;
			}
		}
		
	}

}
