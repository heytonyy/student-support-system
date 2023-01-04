package com.heytonyyy.studentsupportsystem.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.heytonyyy.studentsupportsystem.models.Student;
import com.heytonyyy.studentsupportsystem.models.SupportNote;
import com.heytonyyy.studentsupportsystem.models.User;
import com.heytonyyy.studentsupportsystem.services.StudentService;
import com.heytonyyy.studentsupportsystem.services.SupportNoteService;
import com.heytonyyy.studentsupportsystem.services.UserService;

@Controller
public class TeacherController {

	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	SupportNoteService supportNoteService;
	
// -------------------- ADD NOTES -------------------- //
	
	@PostMapping("/{sidebar}/{id}/addsupportnote")
	public String addSupportNote(
		@PathVariable("sidebar") Long sidebar,
		@PathVariable("id") Long id,
		@Valid @ModelAttribute("supportNote") SupportNote newSupportNote,
		BindingResult result,
		Model model,
		Principal principal
	) {
		if (result.hasErrors()) {
			String username = principal.getName();
			User currentUser = userService.findByUsername(username);
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
			
			Student displayStudent = studentService.findStudentByID(id);
			model.addAttribute("studentDisplay", displayStudent);
			
			model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
			
			// to conditionally render active links
			model.addAttribute("sidebar", 0);
			model.addAttribute("studentSchedule", 0);
			return "dashboard.jsp";
		}
		supportNoteService.createSupportNote(newSupportNote);
		String redirectRoute = userService.redirectString(sidebar);
		return String.format("redirect:/%s/%d/%s/", redirectRoute, id, redirectRoute);
	}
	
// -------------------- HOMEROOM -------------------- //
	
//	MAIN ROUTE
	@GetMapping("/homeroom")
	public String homeroom(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOMEROOM PAGNIATION
	@GetMapping("/homeroom/{id}/homeroom")
	public String homeroomHomeroom(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/homeroom/{id}/period1")
	public String homeroomPeriod1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}

//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/homeroom/{id}/period2")
	public String homeroomPeriod2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}

//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/homeroom/{id}/period3")
	public String homeroomPeriod3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/homeroom/{id}/period4")
	public String homeroomPeriod4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/homeroom/{id}/period5")
	public String homeroomPeriod5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/homeroom/{id}/period6")
	public String homeroomPeriod6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getHomeroomStudents());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 0);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 1 -------------------- //
	
//	MAIN ROUTE
	@GetMapping("/period1")
	public String period1(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period1/{id}/homeroom")
	public String period1Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period1/{id}/period1")
	public String period1period1(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period1/{id}/period2")
	public String period1period2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period1/{id}/period3")
	public String period1period3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period1/{id}/period4")
	public String period1period4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period1/{id}/period5")
	public String period1period5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period1/{id}/period6")
	public String period1period6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod1Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 1);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 2 -------------------- //
	
//	MAIN PERIOD 2 ROUTE
	@GetMapping("/period2")
	public String period2(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period2/{id}/homeroom")
	public String period2Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period2/{id}/period1")
	public String period2period1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period2/{id}/period2")
	public String period2period2(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period2/{id}/period3")
	public String period2period3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period2/{id}/period4")
	public String period2period4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period2/{id}/period5")
	public String period2period5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period2/{id}/period6")
	public String period2period6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod2Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 2);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 3 -------------------- //
	
//	MAIN ROUTE
	@GetMapping("/period3")
	public String period3(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period3/{id}/homeroom")
	public String period3Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period3/{id}/period1")
	public String period3period1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period3/{id}/period2")
	public String period3period2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period3/{id}/period3")
	public String period3period3(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period3/{id}/period4")
	public String period3period4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period3/{id}/period5")
	public String period3period5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period3/{id}/period6")
	public String period3period6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod3Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 3);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 4 -------------------- //	
	
//	MAIN ROUTE
	@GetMapping("/period4")
	public String period4(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period4/{id}/homeroom")
	public String period4Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period4/{id}/period1")
	public String period4period1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period4/{id}/period2")
	public String period4period2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period4/{id}/period3")
	public String period4period3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period4/{id}/period4")
	public String period4period4(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period4/{id}/period5")
	public String period4period5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period4/{id}/period6")
	public String period4period6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod4Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 4);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 5 -------------------- //
	
//	MAIN ROUTE
	@GetMapping("/period5")
	public String period5(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period5/{id}/homeroom")
	public String period5Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period5/{id}/period1")
	public String period5period1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period5/{id}/period2")
	public String period5period2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period5/{id}/period3")
	public String period5period3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period5/{id}/period4")
	public String period5period4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period5/{id}/period5")
	public String period5period5(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period5/{id}/period6")
	public String period5period6(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod5Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 5);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
// -------------------- PERIOD 6 -------------------- //
	
//	MAIN ROUTE
	@GetMapping("/period6")
	public String period6(Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		model.addAttribute("studentDisplay", new Student());
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - HOME PAGNIATION
	@GetMapping("/period6/{id}/homeroom")
	public String period6Homeroom(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getHomeroomTeacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getHomeroomTeacher());
		model.addAttribute("showForm", displayStudent.getHomeroomTeacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 0);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 1 PAGNIATION
	@GetMapping("/period6/{id}/period1")
	public String period6period1(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod1Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod1Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod1Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 1);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 2 PAGNIATION
	@GetMapping("/period6/{id}/period2")
	public String period6period2(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod2Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod2Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod2Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 2);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 3 PAGNIATION
	@GetMapping("/period6/{id}/period3")
	public String period6period3(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod3Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod3Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod3Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 3);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 4 PAGNIATION
	@GetMapping("/period6/{id}/period4")
	public String period6period4(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod4Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod4Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod4Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 4);
		return "dashboard.jsp";
	}	
	
//	VIEW STUDENT - PERIOD 5 PAGNIATION
	@GetMapping("/period6/{id}/period5")
	public String period6period5(
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod5Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod5Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod5Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 5);
		return "dashboard.jsp";
	}
	
//	VIEW STUDENT - PERIOD 6 PAGNIATION
	@GetMapping("/period6/{id}/period6")
	public String period6period6(
		@ModelAttribute("supportNote") SupportNote blankSuportNote,
		Principal principal,
		Model model,
		@PathVariable("id") Long id
	) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("studentRoster",currentUser.getPeriod6Students());
		
		Student displayStudent = studentService.findStudentByID(id);
		model.addAttribute("studentDisplay", displayStudent);
		model.addAttribute("allNotes", supportNoteService.showAllSupportNotes(displayStudent.getPeriod6Teacher(), displayStudent));
		model.addAttribute("teacherDisplay", displayStudent.getPeriod6Teacher());
		model.addAttribute("showForm", displayStudent.getPeriod6Teacher().equals(currentUser));
		
		// to conditionally render active links
		model.addAttribute("sidebar", 6);
		model.addAttribute("studentSchedule", 6);
		return "dashboard.jsp";
	}
	
}
