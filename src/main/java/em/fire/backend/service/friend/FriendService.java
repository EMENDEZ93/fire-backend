package em.fire.backend.service.friend;

import java.util.List;

import em.fire.backend.domain.friend.Friend;
import em.fire.backend.entity.friend.FriendEntity;
import em.fire.backend.entity.user.User;

public interface FriendService {

	public FriendEntity postFriend(Friend friend);
	
	public List<User> getAllFriendByRequesterEmail(String email);
	
	public List<User> getAllFriendByRequesterEmailAndStatusIsTrue(String email);
	
	public List<User> getAllFriendByRequesterEmailAndStatusIsFalse(String email);
	
	public List<User> getAllFriendByRequestedEmailAndStatusIsFalse(String email);
	
	public List<FriendEntity> getFindFriendRequestsAll();
	
	public List<FriendEntity> getFindFriendRequestsByRequester(String requester);
	
	public List<FriendEntity> getFindFriendRequestsByRequested(String requested);
	
	public FriendEntity getFindFriendRequestById(Long id);
	
	public FriendEntity getChangeFriendRequestStatusById(Long id);
	
	public void deleteFriendRequestById(Long id);
	
	public boolean deleteFriendRecordRequesterAndRequested(String requestedEmail, String requesterEmail);
	
	public boolean existFriendRecordRequesterAndRequested(String requestedEmail, String requesterEmail);

}
