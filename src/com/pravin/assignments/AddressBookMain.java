package com.pravin.assignments;

import java.util.Scanner;

import static java.lang.System.exit;

/** Class to Create and Save Address Book
 * for Contacts. This class displays a menu option in
 * console to Print an existing contact or Create/Update
 * a Contact.
 */
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contact contact = new Contact();
        int option = 3;

        while (option != 5) {
            System.out.println("Select Menu Option \n" +
                    "1. Create a  Contact\n" +
                    "2. Update a Contact \n" +
                    "3. Delete a Contact \n" +
                    "4. Print Contact \n" +
                    "5. exit");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    option1(contact);
                    break;
                case 2:
                    option2(contact);
                    break;
                case 3:
                    option3(contact);
                    break;
                case 4:
                    option4(contact);
                    break;
                case 5:
                    exit(0);
            }
        }
    }

    private static void option4(Contact contact) {
        if (null==contact.getFirstName()) {
            System.out.println("No Contact details exist");
        } else {
            System.out.println(contact);
        }
    }


    /**
     * @param contact
     */
    private static void option3(Contact contact) {
        System.out.println("Delete a Contact");
        System.out.println("Enter Contact First Name to edit");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        if (firstName.equals(contact.getFirstName())) {
            contact = deleteContact(contact);
        } else {
            System.out.println("Contact Doesn't exist");
        }

    }

    private static Contact deleteContact(Contact contact) {
        return null;
    }

    /**
     * @param contact
     */
    private static void option2(Contact contact) {
        System.out.println("Update a Contact");
        System.out.println("Enter Contact First Name to edit");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        if (firstName.equals(contact.getFirstName())) {
            contact = getContact(contact);
        } else {
            System.out.println("Contact Doesn't exist");
        }
    }

    /**
     * @param contact
     */
    private static void option1(Contact contact) {
        System.out.println("Create a Contact");
        contact = getContact(contact);
    }

    /**
     * @param contact
     * @return
     */
    private static Contact getContact(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name");
        contact.setFirstName(scanner.nextLine());
        System.out.println("Enter Last Name");
        contact.setLastName(scanner.nextLine());
        System.out.println("Enter Address");
        contact.setAddress(scanner.nextLine());
        System.out.println("Enter City");
        contact.setCity(scanner.nextLine());
        System.out.println("Enter State");
        contact.setState(scanner.nextLine());
        System.out.println("Enter Email ID");
        contact.setEmailId(scanner.nextLine());
        System.out.println("Enter Phone Number");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println("Enter Zip Code");
        contact.setZipCode(scanner.nextLine());
        return contact;
    }
}
