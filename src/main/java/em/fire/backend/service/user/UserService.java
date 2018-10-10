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
	
	public boolean existsByEmail(String email);
	
	public User getUserByPhone(long phone);

	public List<User> getUserByEmailOrName(String emailOrName, String requesterEmailExcept);
	
}
