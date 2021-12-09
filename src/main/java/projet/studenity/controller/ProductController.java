package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.model.Cart;
import projet.studenity.model.Product;
import projet.studenity.service.CartService;
import projet.studenity.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
  
	@GetMapping(value="/all")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@PostMapping(value="/searchProduct")
	public List<Product> findProductByName(@RequestBody String name) {
		List<Product> listProduct = productService.findProductByName(name);
		return listProduct;
	}

	@PostMapping(value="/delete")
	public boolean deleteProductById(@RequestBody long id){
		return productService.deleteProduct(id);
	}

	@PostMapping(value="/create")
	public boolean createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}

	@PostMapping(value="/update")
	public boolean updateProduct(@RequestBody Product product){
		return productService.updateProduct(product);
	}

	@PostMapping(value="/reserve")
	public boolean reserveProduct(@RequestBody long id){
		return productService.reserveProduct(id);
	}

	@PostMapping(value="/searchByCategory")
	public List<Product> findProductByCategory(@RequestBody Long idCategory){
		return productService.findProductByCategory(idCategory);
	}

	@GetMapping(value="/test")
	public List<Product> test() {
		return findProductByCategory(2L);
	}
}