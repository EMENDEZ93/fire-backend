package em.fire.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.component.UserComponent;
import em.fire.backend.entity.User;
import em.fire.backend.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	@Qualifier("userComponent")
	private UserComponent userComponent;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@PostMapping("/user/save")
	public User createUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/users")
	public List<User> allUser() {
		return userService.findAll();
	}
}
