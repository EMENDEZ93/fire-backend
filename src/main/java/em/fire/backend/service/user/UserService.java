package em.fire.backend.service.user;


import java.util.List;

import em.fire.backend.entity.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> findAll();

	public boolean deleteUserById(Long id);
	
	public boolean existsById(Long id);
	
}
