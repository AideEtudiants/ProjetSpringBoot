package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.studenity.dao.ProductDao;
import projet.studenity.model.Product;
import projet.studenity.repository.ProductRepository;
import projet.studenity.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepo;
  
	@GetMapping(value="product/all")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping(value="/searchNameProduct")
	public List<String> searchNameProduct(){
		return productService.searchNameProduct();
	}

	@GetMapping(value="/{id}")
	public String findProductById(@PathVariable("id") long id) {
		return productService.findProductById(id).toString();
	}

	@GetMapping(value="/product/{name}")
	public List<Product> findProductByName(@PathVariable("name") String name) {
		List<Product> listProduct = productService.findProductByName(name);
		return listProduct;
	}

	@GetMapping(value="/delete/{id}") //Attendre Product de FE
	public String deleteProductById(@PathVariable("id") long id){productService.deleteProduct(id); return "Success";}

	@GetMapping(value="/create/{name}")
	public String createProduct(@PathVariable("name") String name){
		Product product = new Product();
		product.setName(name);
		product.setUserCode(3L);
		product.setStatusCode(1L);
		product.setCategoryCode(1L);
		productService.createProduct(product);
		return "Success";
	}



	@GetMapping(value="/update/{id}/{name}/{image}/{description}/{statusCode}/{categoryCode}/{userId}") //Attendre Product de FE
	public String updateProduct(@PathVariable("id") long id,@PathVariable("name") String name,@PathVariable("image") String image
			,@PathVariable("description") String description,@PathVariable("statusCode") long statusCode
			,@PathVariable("categoryCode") long categoryCode,@PathVariable("userId") long userCode  ){
		Product product = new Product();
		product.setName(name);
		product.setImage(image);
		product.setDescription(description);
		product.setStatusCode(statusCode);
		product.setCategoryCode(categoryCode);
		product.setUserCode(userCode);
		productService.updateProduct(id,product);
		return "success";
	}
}