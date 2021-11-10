package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.studenity.dao.UserDao;
import projet.studenity.model.User;
import projet.studenity.service.ProductService;
import projet.studenity.service.UserService;


import java.util.List;

@RestController
@RequestMapping(value="/user/find")
public class UserController {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	
	@GetMapping(value="/test/{id}")
	public String findNameUserById(@PathVariable("id") long id) {
		return userService.findUserById(id).toString();
	}
	
	@GetMapping(value="/count")
	public int countUser() {
		int count = userDao.getUserCount();
		return count;
	}
	
	@GetMapping(value="/firstname/{name}")
	public String findByFirstName(@PathVariable("name") String firstName) {
		List<User> listUser = userService.findUserByFirstName(firstName);
		return listUser.toString();
	}
}