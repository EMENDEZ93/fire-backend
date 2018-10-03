package em.fire.backend.service.friend;

import java.util.List;

import em.fire.backend.domain.friend.Friend;
import em.fire.backend.entity.friend.FriendEntity;

public interface FriendService {

	public FriendEntity postFriend(Friend friend);
	
	public List<FriendEntity> getFindFriendRequestsAll();
	
	public List<FriendEntity> getFindFriendRequestsByRequester(String requester);
	
	public List<FriendEntity> getFindFriendRequestsByRequested(String requested);
	
	public FriendEntity getFindFriendRequestById(Long id);
	
	public FriendEntity getChangeFriendRequestStatusById(Long id);
	
	public void deleteFriendRequestById(Long id);

}
