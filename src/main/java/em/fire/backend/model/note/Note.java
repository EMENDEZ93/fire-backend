package em.fire.backend.model.note;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import em.fire.backend.entity.note.NoteEntity;

public class Note implements Serializable {

	private static final long serialVersionUID = 336517817423294031L;

	private Long Id;

	private Date startDate;

	private LocalTime startTime;

	private Date endDate;

	private LocalTime endTime;

	private String title;

	private String description;

	private String idFirebase;

	private boolean isInvited;

	public Note(NoteEntity noteEntity, boolean isInvited) {
		this.Id = noteEntity.getId();
		this.startDate = noteEntity.getStartDate();
		this.startTime = noteEntity.getStartTime();
		this.endDate = noteEntity.getEndDate();
		this.endTime = noteEntity.getEndTime();
		this.title = noteEntity.getTitle();
		this.description = noteEntity.getDescription();
		this.idFirebase = noteEntity.getIdFirebase();
		this.isInvited = isInvited;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdFirebase() {
		return idFirebase;
	}

	public void setIdFirebase(String idFirebase) {
		this.idFirebase = idFirebase;
	}

	public boolean isInvited() {
		return isInvited;
	}

	public void setInvited(boolean isInvited) {
		this.isInvited = isInvited;
	}

}
