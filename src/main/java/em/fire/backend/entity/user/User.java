package em.fire.backend.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 2102041986392002796L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private String name;

	@NotNull
	private Long phone;

	public User() {
	}

	public User(Long id, String name, Long phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String name) {
		this.name = name;
	}

}