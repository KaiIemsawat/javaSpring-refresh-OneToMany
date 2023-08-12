package com.postclass.week5OneToManyDemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="halls")
public class Hall {
	
	/* ===== MODELS ===== */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Hall name can't be blank")
	@Size(min=3, max=255, message = "Hall name must be 3-255 characters")
	private String hallName;
	
	@NotNull(message = "Floor number is needed")
	@Min(value = 1, message = "Must have at least 1 floor")
	private Integer floors;
	
	@NotNull(message = "must select weather this hall has housing")
	private Boolean isResidential;
	
	@NotNull(message = "Must specific if this hall has lecture room")
	private Boolean hasLectureRoom;
	
	/* ===== TIMESTAMPS ===== */
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	/* ============ RELATIONSHIP ============ */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="university_id")
	private University university; // "thisValue" <-- needs to match mappedBy = "thisValue"
	
	
	/* ===== CONSTRUCTORS ===== */
	public Hall() {} // empty constructor is needed

	public Hall(
			@NotBlank(message = "Hall name can't be blank") @Size(min = 3, max = 255, message = "Hall name must be 3-255 characters") String hallName,
			@NotNull(message = "Floor number is needed") @Min(value = 1, message = "Must have at least 1 floor") Integer floors,
			@NotNull(message = "must select weather this hall has housing") Boolean isResidential,
			@NotNull(message = "Must specific if this hall has lecture room") Boolean hasLectureRoom,
			University university) {
		super();
		this.hallName = hallName;
		this.floors = floors;
		this.isResidential = isResidential;
		this.hasLectureRoom = hasLectureRoom;
		this.university = university;
	}
	
	/* ============ GETTER and SETTER ============ */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public Integer getFloors() {
		return floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Boolean getIsResidential() {
		return isResidential;
	}

	public void setIsResidential(Boolean isResidential) {
		this.isResidential = isResidential;
	}

	public Boolean getHasLectureRoom() {
		return hasLectureRoom;
	}

	public void setHasLectureRoom(Boolean hasLectureRoom) {
		this.hasLectureRoom = hasLectureRoom;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	
}
