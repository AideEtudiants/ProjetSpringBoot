package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.studenity.model.Product;
import projet.studenity.model.User;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@GetMapping(value="/test1")
	public String findNameUser() {
		return "hello";
	}
}