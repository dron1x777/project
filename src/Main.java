import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;
import service.Impl.ContactServiceImpl;
import service.Impl.PhoneServiceImpl;
import service.PhoneService;

import java.util.Scanner;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBase db = new DataBase();

        ContactService contactService = new ContactServiceImpl(db);
        PhoneService phoneService = new PhoneServiceImpl(db);
        String contactName = "";
        String phoneName = "";
        String brand = "";
        String phoneNumber = "";
        int ID = 0;
        String newName = "";

        while (true) {
            menu();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter your phone name: ");
                    phoneName = sc.nextLine();
                    System.out.println("Enter your brand: ");
                    brand = sc.nextLine();
                    System.out.println(phoneService.addPhone(new Phone(phoneName, brand)));
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    System.out.println(phoneService.getPhoneById(ID));
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your new name: ");
                    newName = sc.nextLine();
                    System.out.println(phoneService.updatePhoneNameById(ID, newName));
                    break;
                case 4:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 5:
                    System.out.println("Enter brand: ");
                    sc.nextLine();
                    brand = sc.nextLine();
                    System.out.println(phoneService.getAllPhonesByBrand(brand));
                    break;
                case 6:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    phoneService.deletePhoneById(ID);
                    break;
                case 7:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your contact name: ");
                    contactName = sc.nextLine();
                    System.out.println("Enter your contact number: ");
                    phoneNumber = sc.nextLine();
                    System.out.println(contactService.addContactToPhone(ID, new Contact(contactName, phoneNumber)));
                    break;
                case 8:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter contact name: ");
                    contactName = sc.nextLine();
                    System.out.println(contactService.findContactByName(ID, contactName));
                    break;
                case 9:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter contact number: ");
                    phoneNumber = sc.nextLine();
                    System.out.println(contactService.findContactByPhoneNumber(ID, phoneNumber));
                    break;
                case  10:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    System.out.println(contactService.sortContactsByName(ID));
                    break;
                case 11:
                    System.out.println("Enter ID: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter contact name: ");
                    contactName = sc.nextLine();
                    contactService.deleteContactByNameFromPhone(ID, contactName);
                    break;
                case 12:
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        }
    }
    public static void menu(){
        System.out.println("""
                menu:
                1. add phone
                2. get phone by id
                3. update phone name by id
                4. get all phones
                5. get all phones by brand
                6. delete phone by id
                7. add contact to phone
                8. find contact by name
                9. find contact by phone number
                10. sort contacts by name
                11. delete contact by name from phone
                12. exit""");
    }
}