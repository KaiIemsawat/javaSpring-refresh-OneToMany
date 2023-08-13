package com.postclass.week5OneToManyDemo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="universities")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "City can not be blank")
	@Size(min=2, max=255, message = "City mush be 2-255 characters long")
	private String city;
	
	@NotBlank(message = "University name can not be blank")
	@Size(min=2, max=255, message = "University name mush be 2-255 characters long")
	private String name;
	
	@NotNull(message = "Can not leave enrollment empty")
	@Min(value = 1, message = "Must have at least 1 student")
	private Integer enrollment;
	
	@NotNull(message = "Must specific if there is an online option")
	private Boolean isOnline;
	
	@NotNull(message = "Must specific if there is an in-person option")
	private Boolean isInPerson;
	
	@NotNull(message = "Year can not be empty")
	@Min(value=1000, message = "Year must be over 1000")
	private Integer yearFounded;
	
	/* ===== TIMESTAMPS ===== */
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
		this.updateAt = new Date();	
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}
	
	
	/* ============ RELATIONSHIP ============ */
//	mappedBy = "thisValue" <-- thisValue came from the one in one to many

	@OneToMany(
			mappedBy = "university"
			, fetch = FetchType.LAZY
//			, cascade = CascadeType.ALL //	cascade = CascadeType.ALL <-- if a university is delete, all halls that belong to the university will be gone
			)
	private List<Hall> halls;
	

	/* ============ CONSTRUCTORS ============ */
	public University() {} // Empty constructor is needed
	
	public University(
			@NotBlank(message = "City can not be blank") @Size(min = 2, max = 255, message = "City mush be 2-255 characters long") String city,
			@NotBlank(message = "University name can not be blank") @Size(min = 2, max = 255, message = "University name mush be 2-255 characters long") String name,
			@NotNull(message = "Can not leave enrollment empty") @Min(value = 1, message = "Must have at least 1 student") Integer enrollment,
			@NotNull(message = "Must specific if there is an online option") Boolean isOnline,
			@NotNull(message = "Must specific if there is an in-person option") Boolean isInPerson,
			@NotNull(message = "Year can not be empty") @Min(value = 1000, message = "Year must be over 1000") Integer yearFounded,
			List<Hall> halls) {
		super();
		this.city = city;
		this.name = name;
		this.enrollment = enrollment;
		this.isOnline = isOnline;
		this.isInPerson = isInPerson;
		this.yearFounded = yearFounded;
		this.halls = halls;
	}
	
	/* ============ GETTER and SETTER ============ */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Boolean getIsInPerson() {
		return isInPerson;
	}

	public void setIsInPerson(Boolean isInPerson) {
		this.isInPerson = isInPerson;
	}

	public Integer getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(Integer yearFounded) {
		this.yearFounded = yearFounded;
	}

	public Date getCreateAt() {
		return createAt;
	}

//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}

	public Date getUpdateAt() {
		return updateAt;
	}

//	public void setUpdateAt(Date updateAt) {
//		this.updateAt = updateAt;
//	}

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}


	
	
	
}
