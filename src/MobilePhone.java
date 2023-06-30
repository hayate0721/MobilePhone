import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (name.equals(contact.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position != -1) {
            myContacts.remove(position);
            return true;
        }
        return false;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) == -1) {
            myContacts.add(contact);
            return true;
        }
        System.out.println("Contact already exists");
        return false;

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position != -1) {
            myContacts.set(position, newContact);
            return true;
        }
        System.out.println("Contact not found");
        return false;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position != -1) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        int count = 1;
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.printf("%d. %s -> %s%n", count, contact.getName(), contact.getPhoneNumber());
            count++;
        }
    }
}
