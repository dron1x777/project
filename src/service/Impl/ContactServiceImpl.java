package service.Impl;

import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private DataBase db;
    public ContactServiceImpl(DataBase db) {
        this.db = db;
    }
    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        Phone phone = db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);
        if (phone != null) {
            phone.getContacts().add(contact);
            return "Phone added successfully";
        }
        return "Phone not added";
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        Phone phone = db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);
        if (phone != null) {
            phone.getContacts().stream().filter(c -> c.getName().equals(contactName)).findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        Phone phone = db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);
        if (phone != null) {
            phone.getContacts().stream().filter(c -> c.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        Phone phone = db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);
        if (phone != null) {
            phone.getContacts().sort(Comparator.comparing(Contact::getName));
            return phone.getContacts();
        }
        return List.of();
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Phone phone = db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);

        if (phone != null) {
            phone.getContacts().removeIf(c -> c.getName().equalsIgnoreCase(contactName));
            System.out.println("Contact deleted successfully");
        } else {
            System.out.println("Phone not found");
        }
    }
}
