package em.fire.backend.model;

public class UserModel {

	private long id;
	private String nombre;
	private String profesion;

	public UserModel() {

	}

	public UserModel(long id, String nombre, String profesion) {
		this.id = id;
		this.nombre = nombre;
		this.profesion = profesion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
