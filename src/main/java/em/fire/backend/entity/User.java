package em.fire.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{


	private static final long serialVersionUID = 2102041986392002796L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String nombre;
	
	private String profesion;
	
	public User() {
	}

	public User(Long id, String nombre, String profesion) {
		this.id = id;
		this.nombre = nombre;
		this.profesion = profesion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

}
