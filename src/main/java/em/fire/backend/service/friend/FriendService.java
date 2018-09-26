package em.fire.backend.service.friend;

import java.util.List;

import em.fire.backend.entity.friend.Friend;

public interface FriendService {

	public Friend postFriend(Friend friend);
	
	public List<Friend> getFindFriendRequestsAll();
	
	public List<Friend> getFindFriendRequestsByRequester(String requester);
	
}
