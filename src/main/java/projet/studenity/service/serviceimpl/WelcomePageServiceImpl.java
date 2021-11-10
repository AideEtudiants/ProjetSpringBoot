package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.dao.ProductDao;
import projet.studenity.model.Product;
import projet.studenity.service.WelcomePageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomePageServiceImpl implements WelcomePageService {

    @Autowired
    ProductDao productDao;


}
