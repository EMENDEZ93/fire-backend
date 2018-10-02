package em.fire.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.entity.user.User;
import em.fire.backend.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/")
	public String fire() {
		return "Fire Backend!!";
	}	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/user/save")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);	
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/user/update")
	public User updateUser(@Valid @RequestBody User user) {
		return userService.updateUser(user);	
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/users")
	public List<User> allUser() {
		return userService.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/user/{id}/delete")
	public boolean deleteUser(@PathVariable(value="id") Long id){	
		return userService.deleteUser(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/user/{phone}")
	public User getUser(@PathVariable(value="phone") Long phone){	
		return userService.getUserByPhone(phone);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/get/find/friends/{emailOrName}")
	public List<User> getUserByEmailOrName(@PathVariable(value="emailOrName") String emailOrName) {
		return userService.getUserByEmailOrName(emailOrName);
	}	
	
}
