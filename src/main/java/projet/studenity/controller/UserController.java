package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import projet.studenity.dao.UserDao;
import projet.studenity.model.User;
import projet.studenity.repository.UserRepository;
import projet.studenity.service.UserService;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/profile")	//Pour afficher et Modifier dans la partie Profile
	public User getProfile(@RequestBody int idUser) {return userService.findUserById(idUser);}

	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/users")
	void addUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@GetMapping(value="/test/{id}")
	public String findNameUserById(@PathVariable("id") int id) {
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

	@GetMapping(value="/tests")
	public void test() {
		User user = new User();
		user.setLastName("test");
		user.setEmail("le@");
		user.setFirstName("dddd");
		user.setEstablishment("a");
		user.setCertificateRegist("a");
		user.setPassword("a");
		user.setStudyLevel("a");
		user.setPhoto("a");

		userRepository.save(user);
	}
}