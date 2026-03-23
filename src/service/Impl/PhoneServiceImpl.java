package service.Impl;

import db.DataBase;
import model.Phone;
import service.PhoneService;

import java.util.ArrayList;
import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private DataBase  db;
    public PhoneServiceImpl(DataBase db) {
        this.db = db;
    }

    @Override
    public String addPhone(Phone phone) {
        if (phone == null) {
            System.out.println("phone is null");
        }
        db.getPhones().add(phone);
        return "Phone added successfully";
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        return db.getPhones().stream().filter(p -> p.getID() == phoneId).findFirst().orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        if (phoneId <= 0) {
            System.out.println("phone id is null");
            return null;
        }
        Phone phone = getPhoneById(phoneId);
        if (phone != null) {
            phone.setName(newName);
        }
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        return db.getPhones().stream().toList();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return db.getPhones().stream().filter(p -> p.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public void deletePhoneById(int phoneId) {
        db.getPhones().removeIf(p -> p.getID() == phoneId);
    }
}
