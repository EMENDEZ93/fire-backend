package em.fire.backend.entity.note;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "notes")
public class Note implements Serializable {

	private static final long serialVersionUID = -3396141139995405876L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "start_time")
	private Date startTime;	
	
	@PrePersist
	public void prePersist() {
		startDate = new Date();
		try {
			startTime = new SimpleDateFormat("HH:mm").parse("15:30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "end_time")
	private Date endTime;

	@NotNull
	private String title;

	private String description;

	@NotNull
	private String idFirebase;
	
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
