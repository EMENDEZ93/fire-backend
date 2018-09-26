package em.fire.backend.service.friend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.friend.Friend;
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
	
	@Override
	public Friend postFriend(Friend friend) {
		return friendJpaRepository.save(friend);
	}

	@Override
	public List<Friend> getFindFriendRequestsAll() {
		return friendJpaRepository.findAll();
	}

	@Override
	public List<Friend> getFindFriendRequestsByRequester(String requester) {
		return friendDSLRepository.getFindFriendRequestsByRequester(requester);
	} 
		
}
