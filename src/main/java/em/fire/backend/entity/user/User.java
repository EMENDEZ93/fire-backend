package em.fire.backend.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 2102041986392002796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",updatable=false, nullable=false)
	private Long id;

	private String name;

	@NotNull
	private String email;

	@NotNull
	private String idFirebase;
	
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

	public String getIdFirebase() {
		return idFirebase;
	}

	public void setIdFirebase(String idFirebase) {
		this.idFirebase = idFirebase;
	}

}
