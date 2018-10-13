package em.fire.backend.service.friend.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.domain.friend.Friend;
import em.fire.backend.entity.friend.FriendEntity;
import em.fire.backend.entity.user.User;
import em.fire.backend.repository.UserDSLRepository;
import em.fire.backend.repository.friend.FriendDSLRepository;
import em.fire.backend.repository.friend.FriendJpaRepository;
import em.fire.backend.service.friend.FriendService;

@Service("friendService")
public class FriendServiceImpl implements FriendService {

	@Autowired
	@Qualifier("friendJpaRepository")
	private FriendJpaRepository friendJpaRepository;

	@Autowired
	@Qualifier("friendDSLRepository")
	private FriendDSLRepository friendDSLRepository;

	@Autowired
	@Qualifier("userDSLRepository")
	private UserDSLRepository userDSLRepository;

	@Override
	public FriendEntity postFriend(Friend friend) {
		if (!friendDSLRepository.existFriendRecordRequesterAndRequested(friend.getRequested(), friend.getRequester())) {

			FriendEntity friendEntity = buildFriendEntity(friend);
			return friendJpaRepository.save(friendEntity);
		}
		return null;
	}

	@Override
	public List<FriendEntity> getFindFriendRequestsAll() {
		return friendJpaRepository.findAll();
	}

	@Override
	public List<FriendEntity> getFindFriendRequestsByRequester(String requester) {
		return friendDSLRepository.getFindFriendRequestsByRequester(requester);
	}

	@Override
	public List<FriendEntity> getFindFriendRequestsByRequested(String requested) {
		return friendDSLRepository.getFindFriendRequestsByrequested(requested);
	}

	@Override
	public FriendEntity getFindFriendRequestById(Long id) {
		return friendDSLRepository.getFindFriendRequestById(id);
	}

	@Override
	public FriendEntity getChangeFriendRequestStatusById(Long id) {
		FriendEntity friend = friendDSLRepository.getFindFriendRequestById(id);
		friend.setRequestStatus(!friend.isRequestStatus());
		return friendJpaRepository.save(friend);
	}

	@Override
	public void deleteFriendRequestById(Long id) {
		friendJpaRepository.deleteById(id);
	}

	private FriendEntity buildFriendEntity(Friend friend) {
		FriendEntity friendEntity = new FriendEntity();

		friendEntity.setRequested(friend.getRequested());
		friendEntity.setRequester(friend.getRequester());

		return friendEntity;
	}

	@Override
	public List<User> getAllFriendByRequesterEmail(String email) {
		List<User> users = getFindByUserEmail(email);
		return users;
	}

	private List<User> getFindByUserEmail(String email) {
		List<FriendEntity> friendEntities = friendDSLRepository.getFindFriendRequestsByRequester(email);
		List<User> users = new ArrayList<>();

		friendEntities.stream().forEach(friendEntity -> {
			if (userDSLRepository.existsByEmail(friendEntity.getRequested())) {
				users.add(userDSLRepository.getUserByEmail(friendEntity.getRequested()));
			}
		});
		return users;
	}
	
	@Override
	public boolean existFriendRecordRequesterAndRequested(String requested, String requester) {
		return friendDSLRepository.existFriendRecordRequesterAndRequested(requested, requester);
	}

	@Override
	public List<User> getAllFriendByRequesterEmailAndStatusIsTrue(String email) {
		List<User> users = getFindByUserRequesterEmailAndStatusIsTrue(email);
		return users;	
	}

	private List<User> getFindByUserRequesterEmailAndStatusIsTrue(String email) {
		List<FriendEntity> friendEntities = friendDSLRepository.getFindFriendRequestsByRequesterAndStatusIsTrue(email);
		List<User> users = new ArrayList<>();

		friendEntities.stream().forEach(friendEntity -> {
			if (userDSLRepository.existsByEmail(friendEntity.getRequested())) {
				users.add(userDSLRepository.getUserByEmail(friendEntity.getRequested()));
			}
		});
		
		return users;
	}

	@Override
	public List<User> getAllFriendByRequesterEmailAndStatusIsFalse(String email) {
		List<User> users = getFindByUserRequesterEmailAndStatusIsFalse(email);
		return users;	
	}	
	

	private List<User> getFindByUserRequesterEmailAndStatusIsFalse(String email) {
		List<FriendEntity> friendEntities = friendDSLRepository.getFindFriendRequestsByRequesterAndStatusIsFalse(email);
		List<User> users = new ArrayList<>();

		friendEntities.stream().forEach(friendEntity -> {
			if (userDSLRepository.existsByEmail(friendEntity.getRequested())) {
				users.add(userDSLRepository.getUserByEmail(friendEntity.getRequested()));
			}
		});
		
		return users;
	}


	
	@Override
	@Transactional
	public boolean deleteFriendRecordRequesterAndRequested(String requestedEmail, String requesterEmail) {
		if(friendDSLRepository.existFriendRecordRequesterAndRequested(requestedEmail, requesterEmail)) {
			friendDSLRepository.deleteFriendRecordRequesterAndRequested(requestedEmail, requesterEmail);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllFriendByRequestedEmailAndStatusIsFalse(String email) {
		List<User> users = getFindByUserRequestedEmailAndStatusIsFalse(email);
		return users;
	}

	private List<User> getFindByUserRequestedEmailAndStatusIsFalse(String email) {
		List<FriendEntity> friendEntities = friendDSLRepository.getFindFriendRequestsByRequestedAndStatusIsFalse(email);
		List<User> users = new ArrayList<>();

		friendEntities.stream().forEach(friendEntity -> {
			if (userDSLRepository.existsByEmail(friendEntity.getRequester())) {
				users.add(userDSLRepository.getUserByEmail(friendEntity.getRequester()));
			}
		});
		
		return users;
	}
	
}
