package em.fire.backend.service.friend.impl;

import java.util.List;

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
		FriendEntity friendEntity = buildFriendEntity(friend);
		return friendJpaRepository.save(friendEntity);
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

		User requester = userDSLRepository.getUserByEmail(friend.getRequester());
		User requested = userDSLRepository.getUserByEmail(friend.getRequested());
		
		friendEntity.setRequester(requester);
		friendEntity.setRequested(requested);
		
		return friendEntity;
	}	
	
}
