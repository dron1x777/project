package Service.Impl;

import Model.Animal;
import Model.Enum.GENDER;
import Model.Person;
import Service.GenericServise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericServise<Animal> {
    List<Animal> animals = new ArrayList<>();
    @Override
    public String add(List<Animal> t) {
        animals.addAll(t);
        return "Animal added successfully!";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal a : animals) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public List<Animal> sortByName(int choice) {
        if (choice == 1) {
            animals.sort(Comparator.comparing(Animal::getName));
        } else {
            animals.sort(Comparator.comparing(Animal::getName).reversed());
        }
        return animals;
    }

    @Override
    public List<Animal> filterByGender(int choice) {
        List<Animal> result = new ArrayList<>();

        for (Animal p : animals) {
            if (choice == 1 && p.getGender() == GENDER.FEMALE) {
                result.add(p);
            } else if (choice == 2 && p.getGender() == GENDER.MALE) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Animal> clear() {
        animals.clear();
        return animals;
    }
}
