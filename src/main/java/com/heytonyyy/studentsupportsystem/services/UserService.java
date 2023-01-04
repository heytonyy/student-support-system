package com.heytonyyy.studentsupportsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.heytonyyy.studentsupportsystem.models.Role;
import com.heytonyyy.studentsupportsystem.models.User;
import com.heytonyyy.studentsupportsystem.repositories.RoleRepository;
import com.heytonyyy.studentsupportsystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	BCryptPasswordEncoder bcryptPWEncoder;
	
//	CREATES USER WITH "TEACHER" ROLE
    public void saveWithTeacherRole(User user) {
        user.setPassword(bcryptPWEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_TEACHER"));
        userRepo.save(user);
    }
     
//	CREATES USER WITH "ADMIN" ROLE
    public void saveWithAdminRole(User user) {
        user.setPassword(bcryptPWEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
//	FINDS USER BY USERNAME
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
//	FINDS TEACHER BY ID
    public User findUserByID(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
//  FINDS ALL USERS WITH TEACHER ROLE
    public List<User> allTeacherList(){
    	List<User> users = userRepo.findAll();
    	List<User> teacherList = new ArrayList<User>();
    	for (User account : users) {
    		boolean isTeacher = false;
    		for (Role role : account.getRoles()) {
    			if (role.getName().equals("ROLE_TEACHER")) {
    				isTeacher = true;
    				break;
    			}
    		}
    		if (isTeacher) {
    			teacherList.add(account);
    		}
    	}
    	return teacherList;
    }
    
//  RETURN SET OF CLASSES FOR STUDENT SCHEDULE
    public List<Long> studentScheduleList(){
    	ArrayList<Long> schedule = new ArrayList<Long>();
    	for (int i = 0; i < 7; i++) {
    		schedule.add((long) i);
    	}
    	return schedule;
    }
    
//  STRING FOR REDIRECTING AFTER SUBMITTING A FORM
    public String redirectString(Long sidebar) {
    	if (sidebar == 0) {
    		return "homeroom";
    	} else if (sidebar == 1) {
    		return "period1";
    	} else if (sidebar == 2) {
    		return "period2";
    	} else if (sidebar == 3) {
    		return "period3";
    	} else if (sidebar == 4) {
    		return "period4";
    	} else if (sidebar == 5) {
    		return "period5";
    	} else {
    		return "period6";
    	}
    }

}
