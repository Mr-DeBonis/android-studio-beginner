import java.util.ArrayList;
import java.util.Map;

public class Phone {
    private Map<String, String> contacts;
    private ArrayList<String> messages;

    private static Phone instance;

    public static Phone getInstance(Map<String, String> contacts, ArrayList<String> messages) {
        if (null == instance) {
            instance = new Phone(contacts, messages);
        }
        return instance;
    }

    private Phone(Map<String, String> contacts, ArrayList<String> messages) {
        this.messages = messages;
        this.contacts = contacts;
    }

    public void showContacts() {
        contacts = this.getContacts();
        if (contacts.size() != 0) {
            for (String contactName : contacts.keySet()) {
                String contactNumber = contacts.get(contactName);
                System.out.println("Name: " + contactName + "\tNumber: " + contactNumber);
            }
        } else {
            System.out.println("No contacts found");
        }
    }

    public void addContact(String contactName, String contactNumber) {
        contacts = this.getContacts();
        contacts.put(contactName, contactNumber);
        System.out.println("Added new contact");
    }

    public void searchContact(String contactName) {
        contacts = this.getContacts();
        if (contacts.containsKey(contactName)) {
            String contactNumber = contacts.get(contactName);
            System.out.println("Contact Name: " + contactName + "\nContact Number: " + contactNumber);
        } else {
            System.out.println("No contact with that contact name");
        }
    }

    public void deleteContact(String contactName) {
        contacts = this.getContacts();
        if (contacts.containsKey(contactName)) {
            contacts.remove(contactName);
            this.setContacts(contacts);
            System.out.println("Deleted contact");
        } else {
            System.out.println("There is no contact with that name");
        }
    }

    public void showMessages() {
        messages = this.getMessages();

        if (messages.isEmpty()) {
            System.out.println("There are no messages");
        } else {
            System.out.println("You have messages:");
            for (String message : messages) {
                System.out.println(message);
            }
        }
    }

    public void sendMessage(String message) {
        messages = this.getMessages();
        messages.add(message);
        this.setMessages(messages);
        System.out.println("Message sent");
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "messages=" + messages +
                ", contacts=" + contacts +
                '}';
    }
}
