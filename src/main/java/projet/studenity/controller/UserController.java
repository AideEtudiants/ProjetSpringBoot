package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.studenity.dao.UserDao;
import projet.studenity.model.User;

@RestController
@RequestMapping(value="/user/find")
public class UserController {
	@Autowired
	private UserDao userDao = new UserDao();
	
	@GetMapping(value="/test/{id}")
	public String findNameUserById(@PathVariable("id") int id) {
		User user = userDao.getUserById(id);
		return user.toString();
	}
	
	@GetMapping(value="/count")
	public int countUser() {
		int count = userDao.getUserCount();
		return count;
	}
	
//	@GetMapping(value="/name/{name}")
//	public String findByFirstName(@PathVariable("name") String firstName) {
//		 User user = userDao.findByName(firstName);
//		return user.toString();
//	}
}