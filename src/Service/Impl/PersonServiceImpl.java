package Service.Impl;

import Model.Enum.GENDER;
import Model.Person;
import Service.GenericServise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenericServise<Person> {
    List<Person> persons = new ArrayList<>();

    @Override
    public String add(List<Person> t) {
        persons.addAll(t);
        return "person added successfully!";
    }

    @Override
    public Person getById(Long id) {
        for (Person p : persons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public List<Person> sortByName(int choice) {
        if (choice == 1) {
            persons.sort(Comparator.comparing(Person::getName));
        } else if (choice == 2) {
            persons.sort(Comparator.comparing(Person::getName).reversed());
        }
        return persons;
    }

    @Override
    public List<Person> filterByGender(int choice) {
        List<Person> persons = new ArrayList<>();
        for (Person p : persons) {
            if (choice == 1 && p.getGender() == GENDER.FEMALE) {
                persons.add(p);
            }
            if (choice == 2 && p.getGender() == GENDER.MALE) {
                persons.add(p);
            }
        }
        return persons;
    }

    @Override
    public List<Person> clear() {
        persons.clear();
        return persons;
    }
}
