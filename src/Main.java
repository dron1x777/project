import Model.Animal;
import Model.Enum.GENDER;
import Model.Person;
import Service.GenericServise;
import Service.Impl.AnimalServiceImpl;
import Service.Impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericServise<Animal> genericServise = new AnimalServiceImpl();
        GenericServise<Person> genericServise2 = new PersonServiceImpl();
        List<Animal> animals = new ArrayList<>(List.of(new Animal("animal1", GENDER.MALE, 23),  new Animal("animal2", GENDER.FEMALE, 654),
        new Animal("animal3", GENDER.FEMALE, 34)));
        List<Person> persons = new ArrayList<>(List.of(
                new Person("person1", GENDER.MALE, 34),
                new Person("person2", GENDER.FEMALE, 34),
                new Person("person3", GENDER.MALE, 43),
                new Person("person4", GENDER.FEMALE, 37)

                ));
        int choice2 = 0;
        long id = 0;
        int choose = 0;

        while (true) {
            menu();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add animal" +
                            "\n2. Add person");
                    choice2 = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.add(animals));
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.add(persons));
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    id = sc.nextLong();
                    System.out.println("1. animal" +
                            "\n2. person");
                    choice2 = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.getById(id));
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.getById(id));
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("1. animal" +
                            "\n2. person");
                    choice2 = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.getAll());
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.getAll());
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 4:
                    System.out.println("1. animal" +
                            "\n2. person");
                    choice2 = sc.nextInt();
                    choose = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.sortByName(choose));
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.sortByName(choose));
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 5:
                    System.out.println("1. animal" +
                            "\n2. person");
                    choice2 = sc.nextInt();
                    System.out.println("1. female" + "\n2. male");
                    choose = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.filterByGender(choose));
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.filterByGender(choose));
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 6:
                    System.out.println("1. animal" +
                            "\n2. person");
                    choice2 = sc.nextInt();
                    if (choice2 == 1) {
                        System.out.println(genericServise.clear());
                    } else if (choice2 == 2) {
                        System.out.println(genericServise2.clear());
                    }  else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        }
    }
    public static void menu () {
        System.out.println("""
                1. add list
                2. get byld by id
                3. get all
                4. sort by name
                5. sort by gender
                6. clear
                7. exist
                """);
    }
}