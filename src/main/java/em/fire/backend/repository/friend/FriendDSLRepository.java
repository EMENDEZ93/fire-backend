package em.fire.backend.repository.friend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.friend.FriendEntity;
import em.fire.backend.entity.friend.QFriendEntity;;

@Repository("friendDSLRepository")
public class FriendDSLRepository {

	private QFriendEntity qFriendEntity = QFriendEntity.friendEntity; 
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	public List<FriendEntity> getFindFriendRequestsByRequester(String requester){
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.requester.email.eq(requester)).fetch();
	}

	public List<FriendEntity> getFindFriendRequestsByrequested(String requested){
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.requested.email.eq(requested)).fetch();
	}	

	public FriendEntity getFindFriendRequestById(Long id){
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.id.eq(id)).fetchOne();
	}
	
}
