package com.bridgelbaz.addressbook;

import java.util.Scanner;

public class StudentContact extends Contact {
	public StudentContact() {

		Scanner sc = ScannerUtil.sc;
		sc.nextLine();
		System.out.println("Enter your first name: ");
		super.firstName = sc.nextLine();

		System.out.println("Enter your last name: ");
		super.lastName = sc.nextLine();

		System.out.println("Enter your address name: ");
		super.address = sc.nextLine();

		System.out.println("Enter your city name: ");
		super.city = sc.nextLine();

		System.out.println("Enter your state name: ");
		super.state = sc.nextLine();

		System.out.println("Enter your zipcode: ");
		super.zipCode = sc.nextInt();

		System.out.println("Enter your phone number: ");
		super.phoneNumber = sc.nextLong();

		System.out.println("Enter your email");
		super.email = sc.next();
	}
}
