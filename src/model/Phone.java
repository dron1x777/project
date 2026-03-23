package model;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private static long counter;
    private long ID;
    private String name;
    private String brand;
    private List<Contact> contacts = new ArrayList<Contact>();

    public Phone( String name, String brand) {
        this.ID = ++counter;
        this.name = name;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Phone.counter = counter;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
