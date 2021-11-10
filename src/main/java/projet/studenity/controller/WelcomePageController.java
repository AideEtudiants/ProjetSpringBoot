package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.studenity.model.Product;
import projet.studenity.service.ProductService;
import projet.studenity.service.WelcomePageService;

import java.util.List;

@RestController
@RequestMapping(value="/acceuil")
public class WelcomePageController {
    @Autowired
    ProductService productService;
    @Autowired
    WelcomePageService welcomePageService;

    @GetMapping(value="/{name}")
    public List<Product> findProductByName(@PathVariable("name") String name){
        return productService.findProductByName(name);
    }

}
