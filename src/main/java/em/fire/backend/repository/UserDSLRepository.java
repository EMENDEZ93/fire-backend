package em.fire.backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.QUser;
import em.fire.backend.entity.User;

@Repository("userDSLRepository")
public class UserDSLRepository {

	private QUser qUser = QUser.user;
	
	@PersistenceContext
	private EntityManager entityManager; 

	public User find() {
		
		JPAQuery<User> query = new JPAQuery<User>(entityManager);
		
		return query.select(qUser).from(qUser).where(qUser.id.eq((long) 1)).fetchOne();
		
	}
	
}
