package com.pravin.assignments;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.exit;

/**
 * Class to Create and Save Address Book
 * for Contacts. This class displays a menu option in
 * console to Print an existing contact or Create/Update
 * a Contact.
 */
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Map<String, List<Contact>> addressBook = new HashMap<String, List<Contact>>();

        //Contact contact = new Contact();
        int option = 3;

        while (option != 5) {
            System.out.println("Select Menu Option \n" +
                    "1. Create a  Contact\n" +
                    "2. Update a Contact \n" +
                    "3. Delete a Contact \n" +
                    "4. Print All Contacts \n" +
                    "5. Search contact in State \n" +
                    "6. Search contact in City \n" +
                    "7. exit");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    option1(addressBook);
                    break;
                case 2:
                    option2(addressBook);
                    break;
                case 3:
                    option3(addressBook);
                    break;
                case 4:
                    option4(addressBook);
                    break;
                case 5:
                    option5(addressBook);
                    break;
                case 6:
                    option6(addressBook);
                    break;
                case 7:
                    exit(0);
            }
        }
    }

    private static void option6(Map<String, List<Contact>> addressBook) {
        System.out.println("Search Contact in City");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter City Name to Search");
        String cityName = scanner.nextLine();

        Collection<List<Contact>> contactList = addressBook.values();
        contactList.forEach(contacts -> contacts.forEach(contact -> {
            if (contact.getCity().equals(cityName)) {
                System.out.println(contact);
            }
        }));

    }

    private static void option5(Map<String, List<Contact>> addressBook) {
        System.out.println("Search Contact in State");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter State Name to Search");
        String stateName = scanner.nextLine();

        Collection<List<Contact>> contactList = addressBook.values();
        contactList.forEach(contacts -> contacts.forEach(contact -> {
            if (contact.getState().equals(stateName)) {
                System.out.println(contact);
            }
        }));
    }

    private static void option4(Map<String, List<Contact>> addressBook) {
        if (addressBook.size() == 0) {
            System.out.println("No Address Book exist");
        } else {
            for (Map.Entry<String, List<Contact>> entry : addressBook.entrySet()) {
                List<Contact> contactList = entry.getValue();
                if (contactList.size() == 0) {
                    System.out.println("No Contact List exist for Address Book " + entry.getKey());
                } else {

                    for (Contact contact : contactList) {
                        System.out.println(contact);

                    }
                }
            }
        }

    }


    /**
     * @param addressBook
     */
    private static void option3(Map<String, List<Contact>> addressBook) {
        System.out.println("Update a Contact");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter AddressBook to edit");
        String addressBookName = scanner.nextLine();
        System.out.println("Enter Contact First Name to edit");
        String firstName = scanner.nextLine();

        for (Map.Entry<String, List<Contact>> entry : addressBook.entrySet()) {
            if (entry.getKey().equals(addressBookName)) {
                List<Contact> contactList = entry.getValue();
                for (Contact contact : contactList) {
                    if (firstName.equals(contact.getFirstName())) {
                        contactList.remove(contact);
                    } else {
                        System.out.println("Contact Doesn't exist");
                    }
                }
            }
        }

    }

    private static Contact deleteContact(Contact contact) {
        return null;
    }

    /**
     * @param addressBook
     */
    private static void option2(Map<String, List<Contact>> addressBook) {
        System.out.println("Update a Contact");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter AddressBook to edit");
        String addressBookName = scanner.nextLine();
        System.out.println("Enter Contact First Name to edit");
        String firstName = scanner.nextLine();

        for (Map.Entry<String, List<Contact>> entry : addressBook.entrySet()) {
            if (entry.getKey().equals(addressBookName)) {
                List<Contact> contactList = entry.getValue();
                for (Contact contact : contactList) {
                    if (firstName.equals(contact.getFirstName())) {
                        contactList.remove(contact);
                        contactList.add(getContact());
                    } else {
                        System.out.println("Contact Doesn't exist");
                    }
                }
            }
        }


    }

    /**
     * @param addressBook
     */
    private static void option1(Map<String, List<Contact>> addressBook) {
        System.out.println("Create a Contact for Address Book");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Address Book Name");
        String addressBookName = scanner.nextLine();
        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        if (addressBook.containsKey(addressBookName)) {
            List<Contact> contactList = addressBook.get(addressBookName);
            if (!contactList.isEmpty()) {
                boolean contactExist = contactList.stream().anyMatch(contact -> contact.getFirstName().equals(firstName));
                if (!contactExist) {
                    contactList.add(getContact());
                    addressBook.put(addressBookName, contactList);
                } else {
                    System.out.println("Contact Already Exist");
                }
            } else {
                System.out.println("Contact Does not exist .. ");
                contactList.add(getContact());
                addressBook.put(addressBookName, contactList);
            }
        } else {
            List<Contact> contactList = new ArrayList<Contact>();

            System.out.println("Contact Does not exist .. ");
            contactList.add(getContact());
            addressBook.put(addressBookName, contactList);
        }


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
