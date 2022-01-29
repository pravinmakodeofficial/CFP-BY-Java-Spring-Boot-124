package com.pravin.assignments;

import java.util.ArrayList;
import java.util.List;
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
        List<Contact> contactList = new ArrayList<Contact>();
        //Contact contact = new Contact();
        int option = 3;

        while (option != 5) {
            System.out.println("Select Menu Option \n" +
                    "1. Create a  Contact\n" +
                    "2. Update a Contact \n" +
                    "3. Delete a Contact \n" +
                    "4. Print All Contacts \n" +
                    "5. exit");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    option1(contactList);
                    break;
                case 2:
                    option2(contactList);
                    break;
                case 3:
                    option3(contactList);
                    break;
                case 4:
                    option4(contactList);
                    break;
                case 5:
                    exit(0);
            }
        }
    }

    private static void option4(List<Contact> contactList) {
        if(contactList.size()==0)
            System.out.println("No Contacts exist");
        for(Contact contact:contactList){
                System.out.println(contact);
        }

    }


    /**
     * @param contactList
     */
    private static void option3(List<Contact> contactList) {
        System.out.println("Delete a Contact");
        System.out.println("Enter Contact First Name to edit");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        for(Contact contact:contactList){
            if (firstName.equals(contact.getFirstName())) {
                contactList.remove(contact);
            } else {
                System.out.println("Contact Doesn't exist");
            }
        }


    }

    private static Contact deleteContact(Contact contact) {
        return null;
    }

    /**
     * @param contactList
     */
    private static void option2(List<Contact> contactList) {
        System.out.println("Update a Contact");
        System.out.println("Enter Contact First Name to edit");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        for (Contact contact:contactList){
            if (firstName.equals(contact.getFirstName())) {
                contactList.remove(contact);
                contactList.add(getContact());
            } else {
                System.out.println("Contact Doesn't exist");
            }
        }

    }

    /**
     * @param contactList
     */
    private static void option1(List<Contact> contactList) {
        System.out.println("Create a Contact");
        contactList.add(getContact());
    }

    /**
     * @param
     * @return
     */
    private static Contact getContact() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
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
