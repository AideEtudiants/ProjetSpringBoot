package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.dao.ProductDao;
import projet.studenity.model.Cart;
import projet.studenity.model.Product;
import projet.studenity.repository.CartRepository;
import projet.studenity.repository.ProductRepository;
import projet.studenity.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductRepository productRepo;

    public Product findProductById(int id) {

        Product product = productDao.findProductById(id);
        return product;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> listProduct = productRepo.findAll();
        List<Product> listProductWithName = new ArrayList<>();
        for(Product product:listProduct){
            if(product.getName().equalsIgnoreCase(name)){
                listProductWithName.add(product);
            }
        }
        if(listProductWithName.isEmpty()) return null;
        return listProductWithName;
    }

    @Override
    public boolean reserveProduct(int id) {
        Product product = findProductById(id);
        if(product.getAvailability()!= 3){
            product.setAvailability(3);
        }
        try {
            productDao.updateProduct(product);
        }catch(Exception e){return false;}
        return true;
    }

    @Override
    public List<Product> findProductByCategory(int idCategory) {
        List<Product> listProduct = productRepo.findAll();
        List<Product> listProductByCategory = new ArrayList<>();
        for(Product product:listProduct){
            if(product.getCategoryCode()==idCategory){
                listProductByCategory.add(product);
            }
        }
        if(listProductByCategory.isEmpty()) return null;
        return listProductByCategory;
    }

    @Override
    public boolean createProduct(Product product) {
        try {
            productRepo.save(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        productDao.updateProduct(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            productRepo.deleteById(id);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
