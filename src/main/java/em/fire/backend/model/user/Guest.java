package em.fire.backend.model.user;

import java.io.Serializable;

import em.fire.backend.entity.user.User;

public class Guest implements Serializable {

	private static final long serialVersionUID = -7469052371119494691L;

	private Long id;

	private String name;

	private String email;

	private boolean status;

	public Guest(User user, boolean status) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
