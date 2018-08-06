package em.fire.backend.converter;

import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {

	/*public UserModel entityConvertToModel(User user) {
		UserModel userModel = new UserModel();
		userModel.setId(user.getId());
		userModel.setNombre(user.getNombre());
		userModel.setProfesion(user.getProfesion());
		
		return userModel;
	}
	
	public User modelConvertToEntity(UserModel userModel) {
		User user = new User();
		user.setId(userModel.getId());
		user.setNombre(userModel.getNombre());
		user.setProfesion(userModel.getProfesion());
		
		return user;
	}*/	
}
