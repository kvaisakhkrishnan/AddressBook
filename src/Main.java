import java.util.*;


public class Main {
	
	public static void main(String args[]) {
		Dictionary<String, AddressBook> library.get(addressBookName). = new Hashtable<>();
		Dictionary<String, ArrayList<Address>> searchByCity = new Hashtable<>();
		Dictionary<String, ArrayList<Address>> searchByState = new Hashtable<>();


		AddressBook addressBook = new AddressBook();
		System.out.println("Welcome to Address Book");
		while(true) {
			System.out.println("1. Add Address Book\n2. Add address\n3. Update Address\n4. Delete Address\n5. Search\n6. Search By City And State\n7. Count By City State\n8. Sort Person in Address Book\n9. Sort By City, State, Zip\n10. Exit");
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
					library.get(addressBookName).addAddress(searchByCity, searchByState);
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
			else if(count == 5) {
				int flag = 0;
				System.out.println("Enter First Name and Last Name: ");
				String firstName = scanner.next();
				String lastName = scanner.next();
				Enumeration<String> keys = library.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					for(int i = 0; i < library.get(key).getAddressList().size(); i++) {
						if(library.get(key).getAddressList().get(i).getFirstName().equals(firstName) &&
								library.get(key).getAddressList().get(i).getLastName().equals(lastName)
								) {
							System.out.println(library.get(key).getAddressList().get(i).getFirstName());
							System.out.println(library.get(key).getAddressList().get(i).getLastName());
							System.out.println(library.get(key).getAddressList().get(i).getPhoneNumber());
							System.out.println(library.get(key).getAddressList().get(i).getAddress());
							System.out.println(library.get(key).getAddressList().get(i).getEmail());
							System.out.println(library.get(key).getAddressList().get(i).getCity());
							System.out.println(library.get(key).getAddressList().get(i).getState());
							System.out.println(library.get(key).getAddressList().get(i).getZip());
							flag = 1;
							System.out.println("---------------------------");
						}
							
					}
				}
				if(flag == 0) {
					System.out.println("Person Not Found");
				}
			}
			else if(count == 6) {
				System.out.println("Details By City");
				Enumeration<String> keys = searchByCity.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					for(Address address : searchByCity.get(key)) {
						System.out.println(address.getFirstName());
						System.out.println(address.getLastName());
						System.out.println(address.getAddress());
						System.out.println("---------------------------");
					}
				}
				System.out.println("Details By State");
				keys = searchByState.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					for(Address address : searchByState.get(key)) {
						System.out.println(address.getFirstName());
						System.out.println(address.getLastName());
						System.out.println(address.getAddress());
						System.out.println("---------------------------");
					}
				}
			}
			else if(count == 7) {
				System.out.println("Count By City");
				Enumeration<String> keys = searchByCity.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					System.out.println(key + ", Count: " + searchByCity.get(key).size());
				}
				System.out.println("Count By State");
				keys = searchByState.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					System.out.println(key + ", Count: " + searchByState.get(key).size());
				}
				
			}
			else if(count == 8) {
				System.out.println("Enter Address Book Name: ");
				String addressBookName = scanner.next();
				if(library.get(addressBookName) != null) {
					Comparator<Address> comp = new Comparator<>(){

						@Override
						public int compare(Address o1, Address o2) {
							// TODO Auto-generated method stub
							return o1.getFirstName().compareTo(o2.getFirstName());
						}
						
					};
					Collections.sort(library.get(addressBookName).getAddressList(), comp);
					library.get(addressBookName).displayAddress();
					
				}
				else {
					System.out.println("Address Book Now Found");
				}
			}
			else if(count == 9) {
				System.out.println("Enter Address Book Name: ");
				String addressBookName = scanner.next();
				if(library.get(addressBookName) != null) {
					System.out.println("Sort By City");
					Comparator<Address> comp = new Comparator<>(){

						@Override
						public int compare(Address o1, Address o2) {
							// TODO Auto-generated method stub
							return o1.getCity().compareTo(o2.getCity());
						}
						
					};
					Collections.sort(library.get(addressBookName).getAddressList(), comp);
					library.get(addressBookName).displayAddress();
					
					System.out.println("Sort By State");
					Comparator<Address> comp2 = new Comparator<>(){

						@Override
						public int compare(Address o1, Address o2) {
							// TODO Auto-generated method stub
							return o1.getState().compareTo(o2.getState());
						}
						
					};
					Collections.sort(library.get(addressBookName).getAddressList(), comp2);
					library.get(addressBookName).displayAddress();
					
					System.out.println("Sort By Zip");
					Comparator<Address> comp3 = new Comparator<>(){

						@Override
						public int compare(Address o1, Address o2) {
							// TODO Auto-generated method stub
							return o1.getZip().compareTo(o2.getZip());
						}
						
					};
					Collections.sort(library.get(addressBookName).getAddressList(), comp3);
					library.get(addressBookName).displayAddress();
					
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
