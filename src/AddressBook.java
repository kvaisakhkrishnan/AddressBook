import java.util.*;

public class AddressBook {
	private ArrayList<Address> addressList;
	
	AddressBook(){
		addressList = new ArrayList<Address>();
	}
	
	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}
	
	public void displayAddress() {
		for(Address address : addressList) {
			System.out.println(address.getFirstName());
		}
	}

	public void addAddress(Dictionary<String, ArrayList<Address>> hashByCity, Dictionary<String, ArrayList<Address>> hashByState) {
		
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
		addressList.add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		if(hashByCity.get(city) != null) {
			hashByCity.get(city).add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}
		else {
			hashByCity.put(city, new ArrayList<Address>());
			hashByCity.get(city).add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}
		if(hashByState.get(state) != null) {
			hashByState.get(state).add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}
		else {
			hashByState.put(state, new ArrayList<Address>());
			hashByState.get(state).add(new Address(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}
	}
	
	public void editAddress() {
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
		for(int i = 0; i < addressList.size(); i++) {
			if(addressList.get(i).getFirstName().equals(firstName) && addressList.get(i).getLastName().equals(lastName)) {
				flag = 1;
				addressList.get(i).setAddress(address);
				addressList.get(i).setCity(city);
				addressList.get(i).setState(state);
				addressList.get(i).setZip(zip);
				addressList.get(i).setPhoneNumber(phoneNumber);
				addressList.get(i).setEmail(email);
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
	
	public void deleteAddress() {
		System.out.println("--------------DELETE--------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Firstname: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Lastname: ");
		String lastName = scanner.nextLine();
		System.out.println("Searching Address Book");
		int flag = 0;
		for(int i = 0; i < addressList.size(); i++) {
			if(addressList.get(i).getFirstName().equals(firstName) && addressList.get(i).getLastName().equals(lastName)) {
				flag = 1;
				addressList.remove(i);
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
}
