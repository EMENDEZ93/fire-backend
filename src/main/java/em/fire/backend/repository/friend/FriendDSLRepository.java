package em.fire.backend.repository.friend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.friend.FriendEntity;
import em.fire.backend.entity.friend.QFriendEntity;;

@Repository("friendDSLRepository")
public class FriendDSLRepository {

	private QFriendEntity qFriendEntity = QFriendEntity.friendEntity;

	@PersistenceContext
	private EntityManager entityManager;

	public List<FriendEntity> getFindFriendRequestsByRequester(String requester) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.requester.eq(requester)).fetch();
	}

	public List<FriendEntity> getFindFriendRequestsByRequesterAndStatusIsTrue(String requester) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity)
				.where(qFriendEntity.requester.eq(requester).and(qFriendEntity.requestStatus.isTrue())).fetch();
	}

	public List<FriendEntity> getFindFriendRequestsByRequesterAndStatusIsFalse(String requester) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity)
				.where(qFriendEntity.requester.eq(requester).and(qFriendEntity.requestStatus.isFalse())).fetch();
	}

	public List<FriendEntity> getFindFriendRequestsByRequestedAndStatusIsFalse(String requested) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity)
				.where(qFriendEntity.requested.eq(requested).and(qFriendEntity.requestStatus.isFalse())).fetch();
	}	
	
	public List<FriendEntity> getFindFriendRequestsByrequested(String requested) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.requested.eq(requested)).fetch();
	}

	public FriendEntity getFindFriendRequestById(Long id) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return query.from(qFriendEntity).where(qFriendEntity.id.eq(id)).fetchOne();
	}

	public boolean existFriendRecordRequesterAndRequested(String requestedEmail, String requesterEmail) {
		JPAQuery<FriendEntity> query = new JPAQuery<FriendEntity>(entityManager);
		return (query.from(qFriendEntity)
				.where(qFriendEntity.requested.eq(requestedEmail).and(qFriendEntity.requester.eq(requesterEmail))
						.or(qFriendEntity.requested.eq(requesterEmail).and(qFriendEntity.requester.eq(requestedEmail))))
				.fetchOne() != null);
	}

	public void deleteFriendRecordRequesterAndRequested(String requestedEmail, String requesterEmail) {
		new JPADeleteClause(entityManager, qFriendEntity)
				.where(qFriendEntity.requested.eq(requestedEmail)
						.and(qFriendEntity.requester.eq(requesterEmail))).execute();
	}

}
