package projet.studenity.service;

import projet.studenity.model.Product;
import projet.studenity.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public abstract boolean createUser(User user);
    public abstract boolean updateUser(User user);
    public abstract boolean deleteUser(Long id);
    public abstract List<User> getUsers();
    public User findUserById(long id);
    public List<User> findUserByFirstName(String firstName);
}
