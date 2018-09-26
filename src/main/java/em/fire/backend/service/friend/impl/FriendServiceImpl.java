package em.fire.backend.service.friend.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.friend.Friend;
import em.fire.backend.repository.friend.FriendJpaRepository;
import em.fire.backend.service.friend.FriendService;

@Service("friendService")
public class FriendServiceImpl implements FriendService {

	@Autowired
	@Qualifier("friendJpaRepository")
	private FriendJpaRepository friendJpaRepository;

	@Override
	public Friend postFriend(Friend friend) {
		return friendJpaRepository.save(friend);
	} 
		
}
