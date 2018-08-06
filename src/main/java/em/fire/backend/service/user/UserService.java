package em.fire.backend.service.user;


import java.util.List;

import em.fire.backend.entity.User;

public interface UserService {

	public User save(User user);
	
	public List<User> findAll();

	public void deleteUserById(Long id);
	
	public boolean existsById(Long id);
	
}
