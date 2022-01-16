public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Contact contact = new Contact();
        contact.setFirstName("Pravin");
        contact.setLastName("Makode");
        contact.setAddress("Address 123");
        contact.setCity("Bangalore");
        contact.setState("Karnataka");
        contact.setEmailId("pravin.kumar.makode@gmail.com");
        contact.setPhoneNumber("9999999999");
        contact.setZipCode("123456");

        System.out.println(contact);
    }
}
