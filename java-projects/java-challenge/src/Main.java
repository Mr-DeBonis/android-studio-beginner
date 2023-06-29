import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> contacts = new HashMap<>();
        ArrayList<String> messages = new ArrayList<>();

        Phone phone = Phone.getInstance(contacts, messages);

        boolean menuOpen = true;

        System.out.println("Hello!");
        Scanner scanner = new Scanner(System.in);

        while (menuOpen) {
            System.out.println("What would you like to do today?:\n\t1. Manage contacts\n\t2. Messages\n\t3. Quit");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    manageContacts(scanner, phone);
                    break;
                case 2:
                    manageMessages(scanner, phone);
                    break;
                default:
                    menuOpen = false;
                    break;
            }
        }
        scanner.close();
    }

    static void manageContacts(Scanner scanner, Phone phone) {
        String contactName, contactNumber;
        boolean contactMenu = true;

        while (contactMenu) {
            System.out.println("Would you like to:\n\t1. Show all contacts\n\t2. Add a new contact\n\t3. Search for a contact\n\t4. Delete a contact\n\t5. Go back to the previous menu");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    phone.showContacts();
                    break;
                case 2:
                    System.out.println("Add new contact name:");
                    contactName = scanner.nextLine();

                    System.out.println("Add phone number:");
                    contactNumber = scanner.nextLine();

                    phone.addContact(contactName, contactNumber);
                    break;
                case 3:
                    System.out.println("Enter contact name:");
                    contactName = scanner.nextLine();
                    phone.searchContact(contactName);
                    break;
                case 4:
                    System.out.println("Enter contact name:");
                    contactName = scanner.nextLine();
                    phone.deleteContact(contactName);
                    break;
                default:
                    contactMenu = false;
                    break;
            }
        }
    }

    static void manageMessages(Scanner scanner, Phone phone) {
        String message;
        boolean messageMenu = true;

        while (messageMenu) {
            System.out.println("Would you like to:\n\t1. See the list of all messages\n\t2. Send a new message\n\t3. Go back to the previous menu");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    phone.showMessages();
                    break;
                case 2:
                    System.out.println("Enter a new message");
                    message = scanner.nextLine();
                    phone.sendMessage(message);
                    break;
                default:
                    messageMenu = false;
                    break;
            }
        }
    }
}