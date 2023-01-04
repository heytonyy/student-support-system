package com.heytonyyy.studentsupportsystem.models;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="support_notes")
public class SupportNote {
//	FIELDS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="Choose a category.")
	private String category;
	@NotNull
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private String teacherSubmitDate;
	@NotEmpty(message="Description cannot be blank.")
	private String description;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //RELATIONSHIP
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User teacher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
	
//	CONSTRUCTOR
	public SupportNote() {}
	
//	METHODS
	
//	GETTERS & SETTERS
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTeacherSubmitDate() {
		return teacherSubmitDate;
	}

	public void setTeacherSubmitDate(String teacherSubmitDate) {
		this.teacherSubmitDate = teacherSubmitDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
