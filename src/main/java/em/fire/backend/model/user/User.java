package em.fire.backend.model.user;

public class User {

	private int id;
	private String name;
	private String profesion;

	public User() {
		
	}
	
	public User(int id, String name, String profesion) {
		this.id = id;
		this.name = name;
		this.profesion = profesion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

}
