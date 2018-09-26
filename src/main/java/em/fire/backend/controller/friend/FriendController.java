package em.fire.backend.controller.friend;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@PostMapping("friend/post")
	public Friend postFriend(@Valid @RequestBody Friend friend ) {
		return friendService.postFriend(friend);
	}
	
}
