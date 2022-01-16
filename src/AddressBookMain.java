import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contact contact = getContact();
        System.out.println(contact);
    }

    private static Contact getContact() {
        Contact contact = new Contact();
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
