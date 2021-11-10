package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.studenity.dao.ProductDao;
import projet.studenity.dao.UserDao;
import projet.studenity.model.Product;
import projet.studenity.model.User;
import projet.studenity.service.ProductService;
import projet.studenity.service.UserService;

@RestController
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductService productService;


	@GetMapping(value="/test/{id}")
	public String findProductById(@PathVariable("id") long id) {
		return productService.findProductById(id).toString();
	}

	@GetMapping(value="/{name}")
	public String findProductByName(@PathVariable("name") String name) {
		List<Product> listProduct = productService.findProductByName(name);
		return listProduct.toString();
	}
}