package em.fire.backend.model.friend;

import java.io.Serializable;

public class Friend implements Serializable {

	private static final long serialVersionUID = 8340834329300429537L;

	private Long id;

	private String requester;

	private String requested;

	private boolean requestStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getRequested() {
		return requested;
	}

	public void setRequested(String requested) {
		this.requested = requested;
	}

	public boolean isRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}

}
