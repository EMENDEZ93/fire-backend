package em.fire.backend.entity.note;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import em.fire.backend.entity.user.User;

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

	@PrePersist
	public void prePersist() {
		startDate = new Date();
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "end_time")
	private Date endTime;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

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

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
