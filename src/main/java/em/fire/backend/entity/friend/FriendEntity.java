package em.fire.backend.entity.friend;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import em.fire.backend.entity.user.User;

@Entity
@Table(name = "friends_entity")
public class FriendEntity implements Serializable {

	private static final long serialVersionUID = -5596321336021120799L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull	
	private User requester;

	@NotNull
	private User requested;

	private boolean requestStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public User getRequested() {
		return requested;
	}

	public void setRequested(User requested) {
		this.requested = requested;
	}

	public boolean isRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}

}
