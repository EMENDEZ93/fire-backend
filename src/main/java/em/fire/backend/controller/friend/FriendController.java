package em.fire.backend.controller.friend;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.entity.friend.Friend;
import em.fire.backend.service.friend.FriendService;

@RestController
public class FriendController {

	@Autowired
	@Qualifier("friendService")
	private FriendService friendService; 
	
	@CrossOrigin(origins = "*")
	@PostMapping("post/friend")
	public Friend postFriend(@Valid @RequestBody Friend friend ) {
		return friendService.postFriend(friend);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests")
	public List<Friend> getFriendRequests() {
		return friendService.getFindFriendRequestsAll();
	}	

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests/requester/{requester}")
	public List<Friend> getFriendRequestsByRequester(@PathVariable(value="requester") String requester ) {
		return friendService.getFindFriendRequestsByRequester(requester);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/requests/requested/{requested}")
	public List<Friend> getFriendRequestsByRequested(@PathVariable(value="requested") String requested ) {
		return friendService.getFindFriendRequestsByRequested(requested);
	}	

	@CrossOrigin(origins = "*")
	@GetMapping("get/friends/request/{id}")
	public Friend getFriendRequestById(@PathVariable(value="id") Long id) {
		return friendService.getFindFriendRequestById(id);
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/change/friend/request/status/{id}")
	public Friend getChangeFriendRequestStatusById(@PathVariable(value="id") Long id) {
		return friendService.getChangeFriendRequestStatusById(id);
	}
	
}
