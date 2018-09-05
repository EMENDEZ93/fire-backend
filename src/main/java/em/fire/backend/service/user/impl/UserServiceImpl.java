package em.fire.backend.service.user.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import em.fire.backend.entity.user.User;
import em.fire.backend.repository.UserDSLRepository;
import em.fire.backend.repository.user.UserJpaRepository;
import em.fire.backend.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;

	@Autowired
	@Qualifier("userDSLRepository")
	private UserDSLRepository userDSLRepository;

	@Override
	public User createUser(User user) {
		return userJpaRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	@Override
	public boolean existsById(Long id) {
		return userJpaRepository.existsById(id);
	}

	@Override
	public boolean deleteUser(Long id) {
		userJpaRepository.deleteById(id);
		return true;
	}

	@Override
	public User getUserByPhone(long phone) {
		return userDSLRepository.getUserByPhone(phone);
	}

	@Override
	public boolean existsUserPhone(Long phone) {
		return (userDSLRepository.getUserByPhone(phone) != null);
	}

	@Override
	public User getUser(long id) {
		return userJpaRepository.getOne(id);
	}

	@Override
	public User updateUser(User user) {
		return userJpaRepository.save(user);
	}

}
