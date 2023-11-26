import java.util.*;


public class Main {
	
	public static void main(String args[]) {
		Dictionary<String, AddressBook> library = new Hashtable<>();
		AddressBook addressBook = new AddressBook();
		System.out.println("Welcome to Address Book");
		while(true) {
			System.out.println("1. Add Address Book\n2. Add address\n3. Update Address\n4. Delete Address\n5. Exit");
			int count;
			Scanner scanner = new Scanner(System.in);
			count = scanner.nextInt();
			if(count == 1) {
				System.out.println("Give Address Book Name: ");
				String addressBookName = scanner.next();
				library.put(addressBookName, new AddressBook());
				System.out.println("New Address Book Added");
			}
			else if(count == 2) {
				System.out.println("Enter Address Book Name: ");
				String addressBookName = scanner.next();
				if(library.get(addressBookName) != null) {
					library.get(addressBookName).addAddress();
				}
				else {
					System.out.println("Address Book Now Found");
				}
				
			}
			else if(count == 3) {
				System.out.println("Enter Address Book Name: ");
				String addressBookName = scanner.next();
				if(library.get(addressBookName) != null) {
					library.get(addressBookName).editAddress();
				}
				else {
					System.out.println("Address Book Now Found");
				}
				
			}
			else if(count == 4) {
				System.out.println("Enter Address Book Name: ");
				String addressBookName = scanner.next();
				if(library.get(addressBookName) != null) {
					library.get(addressBookName).deleteAddress();
				}
				else {
					System.out.println("Address Book Now Found");
				}
			}
			else {
				break;
			}
		}
		
	}

}
