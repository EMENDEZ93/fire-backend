package em.fire.backend.service.user;

import java.util.List;

import em.fire.backend.entity.user.User;

public interface UserService {

	public boolean createUser(User user);
	
	public List<User> findAll();

	public boolean deleteUserById(Long id);
	
	public boolean existsById(Long id);
	
	public User getUserByPhone(long phone);

	public boolean existsUserPhone(Long id);
	
}
