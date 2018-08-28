package em.fire.backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQuery;
import em.fire.backend.entity.user.QUser;
import em.fire.backend.entity.user.User;

@Repository("userDSLRepository")
public class UserDSLRepository {

	private QUser qUser = QUser.user;
	
	@PersistenceContext
	private EntityManager entityManager; 

		
	public User getUserByPhone(long phone) {	
		JPAQuery<User> query = new JPAQuery<User>(entityManager);
		return query.select(qUser).from(qUser).where(qUser.phone.eq((long) phone)).fetchOne();
	}
	
	
}
