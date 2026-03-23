package db;

import model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class DataBase {
    private List<Phone> phones = new ArrayList<>();

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
