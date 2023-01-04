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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
//	FIELDS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
    @Size
	private String username;
    @Size
	private String password;
	@Transient
    private String confirm;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // RELATIONSHIPS
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @OneToMany(mappedBy="homeroomTeacher", fetch=FetchType.LAZY)
    private List<Student> homeroomStudents;
    
    @OneToMany(mappedBy="period1Teacher", fetch=FetchType.LAZY)
    private List<Student> period1Students;
    
    @OneToMany(mappedBy="period2Teacher", fetch=FetchType.LAZY)
    private List<Student> period2Students;
    
    @OneToMany(mappedBy="period3Teacher", fetch=FetchType.LAZY)
    private List<Student> period3Students;
    
    @OneToMany(mappedBy="period4Teacher", fetch=FetchType.LAZY)
    private List<Student> period4Students;
    
    @OneToMany(mappedBy="period5Teacher", fetch=FetchType.LAZY)
    private List<Student> period5Students;
    
    @OneToMany(mappedBy="period6Teacher", fetch=FetchType.LAZY)
    private List<Student> period6Students;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "support_notes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentNotes;
    
//	CONSTRUCTORS
    public User() {}
    
//	METHODS
    public boolean isAdmin() {
        for (Role role : this.getRoles()) {
        	if (role.getName().equals("ROLE_ADMIN")) {
        		return true;
        	}
        }
        return false;
    }
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Student> getHomeroomStudents() {
		return homeroomStudents;
	}

	public void setHomeroomStudents(List<Student> homeroomStudents) {
		this.homeroomStudents = homeroomStudents;
	}

	public List<Student> getPeriod1Students() {
		return period1Students;
	}

	public void setPeriod1Students(List<Student> period1Students) {
		this.period1Students = period1Students;
	}

	public List<Student> getPeriod2Students() {
		return period2Students;
	}

	public void setPeriod2Students(List<Student> period2Students) {
		this.period2Students = period2Students;
	}

	public List<Student> getPeriod3Students() {
		return period3Students;
	}

	public void setPeriod3Students(List<Student> period3Students) {
		this.period3Students = period3Students;
	}

	public List<Student> getPeriod4Students() {
		return period4Students;
	}

	public void setPeriod4Students(List<Student> period4Students) {
		this.period4Students = period4Students;
	}

	public List<Student> getPeriod5Students() {
		return period5Students;
	}

	public void setPeriod5Students(List<Student> period5Students) {
		this.period5Students = period5Students;
	}

	public List<Student> getPeriod6Students() {
		return period6Students;
	}

	public void setPeriod6Students(List<Student> period6Students) {
		this.period6Students = period6Students;
	}

	public List<Student> getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(List<Student> studentNotes) {
		this.studentNotes = studentNotes;
	}


}

