package projet.studenity.service;

import projet.studenity.model.Product;
import projet.studenity.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
    public User findUserById(long id);
    public List<User> findUserByFirstName(String firstName);
}
