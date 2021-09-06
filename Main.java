package com.bridgelbaz.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
//		Logger logger = org.apache.log4j.LogManager.getLogger(Main.class);

		System.out.println("Welcome to Address Book");

		AddressBook addressBook = new AddressBook();
		Scanner sc = ScannerUtil.sc;
		boolean in = true;
		while (in) {
			System.out.println("1.Add 2.Get 3.Search 4.Update 5.Delete 6.Print 7.Exit");

			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the mobile number: ");
				addressBook.add(sc.nextLong());
				break;
			case 2:
				System.out.println("Enter the mobile number to check the person's contact: ");
				long phoneNumber = sc.nextLong();
				addressBook.get(phoneNumber);
				break;
			case 3:
				System.out.println("Enter the number to search based: 1. FirstName 2. City 3. State");
				int number = sc.nextInt();
				addressBook.search(number);
				break;
			case 4:
				System.out.println("Enter the mobile number to update the person's contact: ");
				long Number = sc.nextLong();
				addressBook.update(Number);
				break;
			case 5:
				System.out.println("Enter the mobile number to delete the person's contact: ");
				long mobileNumber = sc.nextLong();
				addressBook.delete(mobileNumber);
				break;
			case 6:
				System.out.println("Enter the number to sort based: 1. FirstName 2. City 3. State");
				int number1 = sc.nextInt();
				addressBook.print(number1);
				break;
			case 7:
				in = false;
				System.out.println("Successfully exited.");
				break;
			default:
				System.out.println("Enter valid option: ");
			}
		}

		try {
			// Created directory named AddressBook
			Path p = Paths.get("C:\\Users\\Naresh\\Documents\\AddressBook");
			if (Files.exists(p)) {
				System.out.println("Directory already existed.");
			} else {
				Path donePath = Files.createDirectory(p);
				System.out.println("Directory Created at " + donePath.toString());
			}

			// Writing the string content into the file.

//			String content = "A love story is started and ended with a failure content";
			
//			String content = addressBook.contactBook.toString();
			
			Path file1 = Paths.get("C:\\Users\\Naresh\\Documents\\AddressBook\\AddressBook1.txt");
			if (! Files.exists(file1)) {
				Files.createFile(file1);
				
			}
			
			for (Entry<Long, Contact> entry : addressBook.contactBook.entrySet()) {
				Files.write(file1, entry.getValue().toString().getBytes(), StandardOpenOption.APPEND);
				Files.write(file1, "\r\n".getBytes(), StandardOpenOption.APPEND);
			}
			
			
			System.out.println();
			System.out.println("String content is added to the file.");

			
			
			List<String> data = Files.readAllLines(file1);
			for (String s : data) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
