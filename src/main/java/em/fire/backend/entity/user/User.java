package em.fire.backend.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import em.fire.backend.entity.note.Note;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 2102041986392002796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;

	@NotNull
	private Long phone;

	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Note> notes;

	public User() {
		notes = new ArrayList<>();
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void addNote(Note note) {
		this.notes.add(note);
	}
	
}
