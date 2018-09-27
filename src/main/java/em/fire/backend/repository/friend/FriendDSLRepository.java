package em.fire.backend.repository.friend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.friend.Friend;
import em.fire.backend.entity.friend.QFriend;

@Repository("friendDSLRepository")
public class FriendDSLRepository {

	private QFriend qFriend = QFriend.friend; 
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	public List<Friend> getFindFriendRequestsByRequester(String requester){
		JPAQuery<Friend> query = new JPAQuery<Friend>(entityManager);
		return query.from(qFriend).where(qFriend.requester.eq(requester)).fetch();
	}

	public List<Friend> getFindFriendRequestsByrequested(String requested){
		JPAQuery<Friend> query = new JPAQuery<Friend>(entityManager);
		return query.from(qFriend).where(qFriend.requested.eq(requested)).fetch();
	}	

	public Friend getFindFriendRequestById(Long id){
		JPAQuery<Friend> query = new JPAQuery<Friend>(entityManager);
		return query.from(qFriend).where(qFriend.id.eq(id)).fetchOne();
	}
	
}
