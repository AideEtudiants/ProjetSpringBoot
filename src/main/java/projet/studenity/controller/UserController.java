package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.studenity.model.User;
import projet.studenity.repository.UserRepository;

@RestController
@RequestMapping(value="/user/find")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value="/test")
	public String findNameUser() {
		List<User> listUser = userRepo.findAll();
		for(User u: listUser) {
			if (u.getFirstName().equalsIgnoreCase("LE")) {
				return u.getEmail();
			}
		}
		return "fail";
	}
}