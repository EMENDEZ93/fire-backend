package em.fire.backend.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import em.fire.backend.entity.User;
import em.fire.backend.repository.UserDSLRepository;
import em.fire.backend.repository.UserJpaRepository;
import em.fire.backend.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;

	@Autowired
	@Qualifier("userDSLRepository")
	private UserDSLRepository userDSLRepository;	
	
	@Override
	public User save(User user) {
		return userJpaRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}
	
	
}