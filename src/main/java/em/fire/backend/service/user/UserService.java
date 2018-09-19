package em.fire.backend.service.user;

import java.util.List;

import em.fire.backend.entity.user.User;

public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user);
		
	public User getUser(long id);
	
	public List<User> findAll();

	public boolean deleteUser(Long id);
	
	public boolean existsById(Long id);
	
	public User getUserByPhone(long phone);

	public boolean getUserByEmail(String email);
	
}
