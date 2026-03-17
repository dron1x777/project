package Service;

import java.util.List;

public interface GenericServise<T> {
    String add(List<T>t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(int choice);
    List<T> filterByGender(int choice);
    List<T> clear();
}
