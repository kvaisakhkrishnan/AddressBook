import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
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
			System.out.println(address.toString());
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
		boolean result = checkDuplicateAddress(firstName, lastName);
		if(result == false) {
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
		else {
			System.out.println("User Already Exist");
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
	
	boolean checkDuplicateAddress(String fname, String lname) {
		for(Address address : addressList) {
			if(address.getFirstName().equals(fname) && 
					address.getLastName().equals(lname)
					) {
				return true;
			}
			
		}
		return false;
	}
	
	void readFromFile(String filePath) {
		Path path = Path.of(filePath);
		if(!Files.exists(path)) {
			try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
				String line;
				while((line = reader.readLine()) != null) {
					String data[] = line.split(",");
					addressList.add(new Address(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
 				}
			}
			catch(Exception err) {
				System.out.println("Error " + err.getMessage());
			}
		}
		else {
			System.out.println("Path Not Found");
		}
	}
	
	void writeToFile(String filePath) {
		Path path = Path.of(filePath);
		if(!Files.exists(path)) {
			try {
				Files.createFile(path);
			}
			catch(Exception err) {
				System.out.println("Error " + err.getMessage());
			}
		}
		
			for(Address address : this.addressList) {
				try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
					writer.write(address.getFirstName() + ", " + address.getLastName() + ", " + address.getEmail() + ", " + address.getPhoneNumber() + ", " + address.getAddress() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getZip());
					writer.newLine();
				}
				catch(Exception err) {
					System.out.println("Error " + err.getMessage());
				}
			}
		
		
	}
}
