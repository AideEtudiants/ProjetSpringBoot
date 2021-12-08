package projet.studenity.service;

import projet.studenity.model.Cart;
import projet.studenity.model.Product;
import java.util.List;

public interface ProductService {
    public abstract boolean createProduct(Product product);
    public abstract boolean updateProduct(Product product);
    public abstract boolean deleteProduct(Long id);
    public abstract List<Product> getProducts();
    public Product findProductById(long id);
    public List<Product> findProductByName(String firstName);
    public boolean reserveProduct(Long id);
    public List<Product> findProductByCategory(Long idCategory);
}
