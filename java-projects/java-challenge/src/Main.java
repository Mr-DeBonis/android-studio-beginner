import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Add variables here, so they can be accessed from multiple methods
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        /**
         * Simulate your phone's contacts and messages applications
         *
         * Greet the user
         * Show these 3 options: 1. Manage contacts  2. Messages  3. Quit
         * In case of selecting 1 --> Show these options:
         *      1. Show all contacts
         *      2. Add a new contact
         *      3. Search for a contact
         *      4. Delete a contact
         *      5. Go back to the previous menu
         * In case of 2 --> show these options:
         *      1. See the list of all messages
         *      2. Send a new message
         *      3. Go back to the previous menu
         * In case of 3 --> Quit the application
         */

        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();

    }

    private static void showInitialOptions() {
        System.out.println("Please select one:" +
                "\n\t1. Manage contacts" +
                "\n\t2. Manage messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one:" +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new message" +
                "\n\t3. Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a message?");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name of the contact");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }

            if (doesExist) {
                System.out.println("What are you going to say?");
                String text = scanner.next();
                if (text.equals("")) {
                    System.out.println("Please enter some message");
                    sendNewMessage();
                } else {
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact contact : contacts) {
                        if (contact.getName().equals(name)) {
                            ArrayList<Message> newMessages = contact.getMessages();
                            newMessages.add(newMessage);
                            contact.setMessages(newMessages);
                        }
                    }
                }
            } else {
                System.out.println("There is no such a contact");
            }
        }
        showAllMessages();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact contact : contacts) {
            allMessages.addAll(contact.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Message message : allMessages) {
                message.getDetails();
                System.out.println("****************");

            }
        } else {
            System.out.println("You don't have any messages");
        }

        showInitialOptions();
    }

    private static void manageContacts() {

        System.out.println("Please select one:" +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact's name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            deleteContact();
        } else {
            boolean doesExist = false;

            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(contact);
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact in your phone");
            }
        }

        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact's name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    doesExist = true;
                    contact.getDetails();
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact in your phone");
            }
        }

        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact name:");
        String name = scanner.next();
        System.out.println("Please enter contact's number:");
        String number = scanner.next();
        System.out.println("Please enter contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter all of the information");
            addNewContact();
        } else {

            boolean doesExist = false;
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }

            if (doesExist) {
                System.out.println("We have a contact named " + name + " on this device");
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
        }

        showInitialOptions();

    }

    private static void showAllContacts() {
        if (contacts.size()>0) {
            for (Contact contact : contacts) {
                contact.getDetails();
                System.out.println("****************");
            }
        } else{
            System.out.println("You do not have any contacts");
        }
        showInitialOptions();
    }


}