package com.heytonyyy.studentsupportsystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
//	FIELDS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size
	private String firstName;
	@Size
	private String lastName;
	@NotEmpty
	private String grade;
	@Size
	private String guardianFirstName;
	@Size
	private String guardianLastName;
	
	@NotNull
	// @ValidPhoneNumber(message="Please enter a valid phone number.")
	private String phoneNumber;
	
	@Email(message = "Please enter a valid email.", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String email;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
	// RELATIONSHIPS
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="homeroomTeacher_id")
    private User homeroomTeacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period1Teacher_id")
    private User period1Teacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period2Teacher_id")
    private User period2Teacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period3Teacher_id")
    private User period3Teacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period4Teacher_id")
    private User period4Teacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period5Teacher_id")
    private User period5Teacher;
    
    // @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="period6Teacher_id")
    private User period6Teacher;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "support_notes", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> teacherNotes;
	
	
//	CONSTRUCTORS
	public Student() {}
	
	public Student(String firstName, String lastName, String grade, 
			String guardianFirstName, String guardianLastName, 
			String phoneNumber, String email
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.guardianFirstName = guardianFirstName;
		this.guardianLastName = guardianLastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


//	METHODS

//  GETTERS AND SETTERS
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGuardianFirstName() {
		return guardianFirstName;
	}

	public void setGuardianFirstName(String guardianFirstName) {
		this.guardianFirstName = guardianFirstName;
	}

	public String getGuardianLastName() {
		return guardianLastName;
	}

	public void setGuardianLastName(String guardianLastName) {
		this.guardianLastName = guardianLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getHomeroomTeacher() {
		return homeroomTeacher;
	}

	public void setHomeroomTeacher(User homeroomTeacher) {
		this.homeroomTeacher = homeroomTeacher;
	}

	public User getPeriod1Teacher() {
		return period1Teacher;
	}

	public void setPeriod1Teacher(User period1Teacher) {
		this.period1Teacher = period1Teacher;
	}

	public User getPeriod2Teacher() {
		return period2Teacher;
	}

	public void setPeriod2Teacher(User period2Teacher) {
		this.period2Teacher = period2Teacher;
	}

	public User getPeriod3Teacher() {
		return period3Teacher;
	}

	public void setPeriod3Teacher(User period3Teacher) {
		this.period3Teacher = period3Teacher;
	}

	public User getPeriod4Teacher() {
		return period4Teacher;
	}

	public void setPeriod4Teacher(User period4Teacher) {
		this.period4Teacher = period4Teacher;
	}

	public User getPeriod5Teacher() {
		return period5Teacher;
	}

	public void setPeriod5Teacher(User period5Teacher) {
		this.period5Teacher = period5Teacher;
	}

	public User getPeriod6Teacher() {
		return period6Teacher;
	}

	public void setPeriod6Teacher(User period6Teacher) {
		this.period6Teacher = period6Teacher;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getTeacherNotes() {
		return teacherNotes;
	}

	public void setTeacherNotes(List<User> teacherNotes) {
		this.teacherNotes = teacherNotes;
	}
	
	
}
