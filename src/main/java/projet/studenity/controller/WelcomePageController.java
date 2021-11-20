package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.dao.ProductDao;
import projet.studenity.model.Product;
import projet.studenity.repository.ProductRepository;
import projet.studenity.service.ProductService;
import projet.studenity.service.WelcomePageService;

import java.util.List;

@RestController
@RequestMapping(value="/acceuil")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomePageController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDao productDao;
    @Autowired
    WelcomePageService welcomePageService;

 /*   @GetMapping(value="/{name}")
    public List<Product> findProductByName(@PathVariable("name") String name){
        return productService.findProductByName(name);
    }*/

    @GetMapping(value="/acceuil")
    public List<Product> getProduct(){
        return productDao.getAll();
    }

}
