package com.bridgelbaz.addressbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.logging.LogManager;
import org.apache.log4j.Logger;

public class AddressBook {
//	Logger logger = org.apache.log4j.LogManager.getLogger(AddressBook.class);
	
	Map<Long, Contact> contactBook = new HashMap<>();
	Scanner sc = ScannerUtil.sc;

	public void add(Long phoneNumber) {
		Contact contact = new StudentContact();

		if (contactBook.get(contact.getPhoneNumber()) == null) {
			contactBook.put(contact.getPhoneNumber(), contact);
			System.out.println("Successfully contact added.");
		} else {
			if (contactBook.get(contact.getPhoneNumber()) != contactBook.get(phoneNumber)) {
				contactBook.put(contact.getPhoneNumber(), contact);
				System.out.println("Successfully contact added.");
			}
			System.out.println("Already Existed");
		}
	}

	public void get(Long phoneNumber) {
		if (contactBook.get(phoneNumber) == null) {
			System.out.println("Contact you are trying is not existed.");
		} else {
			System.out.println(contactBook.get(phoneNumber));
		}
	}

	public void search(int number) {
		Set<Entry<Long, Contact>> entry = contactBook.entrySet();
		switch (number) {
		case 1:
			System.out.println("Enter the firstname: ");
			String firstName = sc.next();
			for (Entry<Long, Contact> entry2 : entry) {
				String x = entry2.getValue().getFirstName();
				if (x.equals(firstName)) {
					System.out.println(entry2.getValue().getCity());
				}
			}
			break;

		case 2:
			System.out.println("Enter the city: ");
			String city = sc.next();
			for (Entry<Long, Contact> entry2 : entry) {
				String x = entry2.getValue().getCity();
				if (x.equals(city)) {
					System.out.println(entry2.getValue().getFirstName());
				}
			}
			break;

		case 3:
			System.out.println("Enter the state: ");
			String state = sc.next();
			for (Entry<Long, Contact> entry2 : entry) {
				String y = entry2.getValue().getState();
				if (y.equals(state)) {
					System.out.println(entry2.getValue().getFirstName());
				}
			}
			break;

		default:
			System.out.println("Enter a valid option.");
		}

	}

	public void update(Long phoneNumber) {
		System.out.println(contactBook.get(phoneNumber));
		System.out.println("Please enter the updated values: ");
		Contact contact = new StudentContact();
		contactBook.put(phoneNumber, contact);
	}

	public void delete(Long phoneNumber) {
		if (contactBook.get(phoneNumber) == null) {
			System.out.println("Contact you are trying is not existed.");
		} else {
			contactBook.remove(phoneNumber);
			System.out.println("Successfully deleted.");
		}
	}

	public void print(int number) {
		System.out.println("Before Sorting");
		contactBook.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("After sorting based on values: ");

		Set<Entry<Long, Contact>> entrySet = contactBook.entrySet();
		List<Entry<Long, Contact>> list = new ArrayList<>(entrySet);

		switch(number) {
		case 1:
			Collections.sort(list, new Comparator<Entry<Long, Contact>>() {

				public int compare(Entry<Long, Contact> o1, Entry<Long, Contact> o2) {
					return o1.getValue().firstName.compareTo(o2.getValue().firstName);
				}

			});
			break;
			
		case 2:
			Collections.sort(list, new Comparator<Entry<Long, Contact>>() {

				public int compare(Entry<Long, Contact> o1, Entry<Long, Contact> o2) {
					return o1.getValue().city.compareTo(o2.getValue().city);
				}

			});
			break;
			
		case 3:
			Collections.sort(list, new Comparator<Entry<Long, Contact>>() {

				public int compare(Entry<Long, Contact> o1, Entry<Long, Contact> o2) {
					return o1.getValue().state.compareTo(o2.getValue().state);
				}

			});
			break;
			
		}
		list.forEach(s -> System.out.println(s.getKey() + "\t" + s.getValue()));
	}
}
