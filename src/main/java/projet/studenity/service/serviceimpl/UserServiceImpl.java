package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.dao.UserDao;
import projet.studenity.model.Product;
import projet.studenity.model.User;
import projet.studenity.service.UserService;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(String id, Product product) {

    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public Collection<Product> getProducts() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public List<User> findUserByFirstName(String firstName) {
        List<User> listUser = userDao.findByFirstName(firstName);
        return listUser;
    }
}
