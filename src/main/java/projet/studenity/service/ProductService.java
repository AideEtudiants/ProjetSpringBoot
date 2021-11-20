package projet.studenity.service;

import projet.studenity.model.Product;
import projet.studenity.model.User;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(Long id, Product product);
    public abstract void deleteProduct(Long id);
    public abstract Collection<Product> getProducts();
    public Product findProductById(long id);
    public List<Product> findProductByName(String firstName);
}