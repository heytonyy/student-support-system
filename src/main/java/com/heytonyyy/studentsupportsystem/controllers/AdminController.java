package com.heytonyyy.studentsupportsystem.controllers;

import java.security.Principal;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.javafaker.Faker;
import com.heytonyyy.studentsupportsystem.models.Student;
import com.heytonyyy.studentsupportsystem.services.StudentService;
import com.heytonyyy.studentsupportsystem.services.UserService;
import com.heytonyyy.studentsupportsystem.validator.StudentValidator;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentValidator studentValidator;
	
//  ADMIN DASHBOARD
    @GetMapping("/admin")
    public String adminPage(
    	Principal principal,
    	Model model
    ) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        // to conditionally render active links
        model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 0);
        return "admin.jsp";
    }
	
//  VIEW NEW STUDENT
	@GetMapping("/admin/newstudent")
	public String newStudentView(
		@ModelAttribute("student") Student blankStudent,
		Principal principal,
		Model model
	) {
		String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("schedule", userService.studentScheduleList());
        model.addAttribute("allTeachers", userService.allTeacherList());
        
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		return "addStudent.jsp";
	}
	
//	PROCESS STUDENT ACCOUNT
	@PostMapping("/admin/newstudent")
	public String processNewStudent(
		@Valid @ModelAttribute("student") Student newStudent,
		BindingResult result,
		Principal principal,
		Model model
	) {
		studentValidator.validate(newStudent, result);
		if (result.hasErrors()) {
			String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        model.addAttribute("schedule", userService.studentScheduleList());
	        model.addAttribute("allTeachers", userService.allTeacherList());
	        
	        // to conditionally render active links
			model.addAttribute("sidebar", 1);
	        return "addStudent.jsp";
		}
		studentService.saveStudent(newStudent);
		return "redirect:/admin";
	}
	
//	ADD FAKE TEACHERS
	@GetMapping("/admin/newstudent/faker")
	public String addFakeTeacher(Principal principal, Model model) {
		Faker faker = new Faker();
		Random random = new Random();
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String grade = Integer.toString(9 + random.nextInt(3));
		String guardianFirstName = faker.name().firstName();
		String guardianLastName = faker.name().lastName();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String email = faker.internet().emailAddress();
		
		Student fakerStudent = new Student(
			firstName, lastName, grade,
			guardianFirstName, guardianLastName,
			phoneNumber, email);
		
		String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("schedule", userService.studentScheduleList());
        model.addAttribute("allTeachers", userService.allTeacherList());
        
        // to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("student", fakerStudent);
		
		return "addStudent.jsp";
	}
	
//	ADD FAKE STUDENTS
	
}
