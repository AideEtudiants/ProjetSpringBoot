package projet.studenity.service;

import projet.studenity.model.Product;
import projet.studenity.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public abstract void createUser(User user);
    public abstract void updateUser(String id, User user);
    public abstract void deleteUser(String id);
    public abstract Collection<Product> getUsers();
    public User findUserById(long id);
    public List<User> findUserByFirstName(String firstName);
}
