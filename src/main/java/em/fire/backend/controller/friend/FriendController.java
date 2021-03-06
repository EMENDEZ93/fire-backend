package em.fire.backend.controller.friend;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.model.friend.Friend;
import em.fire.backend.entity.friend.FriendEntity;
import em.fire.backend.entity.user.User;
import em.fire.backend.domain.friend.FriendService;

@RestController
public class FriendController {

	@Autowired
	@Qualifier("friendService")
	private FriendService friendService;

	@CrossOrigin(origins = "*")
	@PostMapping("post/friend")
	public FriendEntity postFriend(@Valid @RequestBody Friend friend) {
		return friendService.postFriend(friend);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests")
	public List<FriendEntity> getFriendRequests() {
		return friendService.getFindFriendRequestsAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests/requester/{requester}")
	public List<FriendEntity> getFriendRequestsByRequester(@PathVariable(value = "requester") String requester) {
		return friendService.getFindFriendRequestsByRequester(requester);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests/requested/{requested}")
	public List<FriendEntity> getFriendRequestsByRequested(@PathVariable(value = "requested") String requested) {
		return friendService.getFindFriendRequestsByRequested(requested);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/request/{id}")
	public FriendEntity getFriendRequestById(@PathVariable(value = "id") Long id) {
		return friendService.getFindFriendRequestById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/change/friend/request/status/{id}")
	public FriendEntity getChangeFriendRequestStatusById(@PathVariable(value = "id") Long id) {
		return friendService.getChangeFriendRequestStatusById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/change/friend/request/status/for/requested/{requestedEmail}/requester/{requesterEmail}")
	public FriendEntity getChangeFriendRequestStatusByRequestedAndRequester(@PathVariable(value = "requestedEmail") String requestedEmail,
			@PathVariable(value = "requesterEmail") String requesterEmail ) {
		return friendService.getChangeFriendRequestStatusByRequestedAndRequester(requestedEmail, requesterEmail);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("delete/friend/request/{id}")
	public void deleteFriendRequestById(@PathVariable(value = "id") Long id) {
		friendService.deleteFriendRequestById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/all/friends/by/requester/email/{email}")
	public List<User> getAllFriendByRequesterEmail(@PathVariable(value = "email") String email) {
		return friendService.getAllFriendByRequesterEmail(email);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/all/friends/by/requester/email/{email}/status/is/true")
	public List<User> getAllFriendByRequesterEmailAndStatusIsTrue(@PathVariable(value = "email") String email) {
		return friendService.getAllFriendByRequesterEmailAndStatusIsTrue(email);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/all/friends/by/requester/email/{email}/status/is/false")
	public List<User> getAllFriendByRequesterEmailAndStatusIsFalse(@PathVariable(value = "email") String email) {
		return friendService.getAllFriendByRequesterEmailAndStatusIsFalse(email);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/all/friends/by/requested/email/{email}/status/is/false")
	public List<User> getAllFriendByRequestedEmailAndStatusIsFalse(@PathVariable(value = "email") String email) {
		return friendService.getAllFriendByRequestedEmailAndStatusIsFalse(email);
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/exist/friend/record/requester/{requesterEmail}/requested/{requestedEmail}")
	public boolean existFriendRecordRequesterAndRequested(@PathVariable(value = "requesterEmail") String requesterEmail,
			@PathVariable(value = "requestedEmail") String requestedEmail) {
		return friendService.existFriendRecordRequesterAndRequested(requestedEmail, requesterEmail);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("delete/friend/record/requester/{requesterEmail}/requested/{requestedEmail}")
	public boolean deleteFriendRecordRequesterAndRequested(@PathVariable(value = "requesterEmail") String requesterEmail,
			@PathVariable(value = "requestedEmail") String requestedEmail) {
		return friendService.deleteFriendRecordRequesterAndRequested(requestedEmail, requesterEmail);
	}	
	
}
