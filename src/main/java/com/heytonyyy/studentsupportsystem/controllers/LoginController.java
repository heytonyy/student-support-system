package com.heytonyyy.studentsupportsystem.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heytonyyy.studentsupportsystem.models.Student;
import com.heytonyyy.studentsupportsystem.models.User;
import com.heytonyyy.studentsupportsystem.services.UserService;
import com.heytonyyy.studentsupportsystem.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	
//	REGISTER TEACHER (VIEW REGISTER PAGE)
	@GetMapping("/registration")
	public String registerPage(@Valid @ModelAttribute("user") User user) {
		return "registerPage.jsp";
	}
	
//	REGISTER TEACHER (PROCESS ACCOUNT)
	@PostMapping("/registration")
	public String registration(
		@Valid @ModelAttribute("user") User user,
		BindingResult result,
		Model model,
		HttpSession session
	) {
		userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registerPage.jsp";
        }
        userService.saveWithTeacherRole(user);
        return "redirect:/login";
    }
	
//	LOGIN (VIEW LOGIN PAGE)
	@GetMapping("/login")
	public String login(
		@RequestParam(value="error", required=false) String error,
		@RequestParam(value="logout", required=false) String logout,
		Model model
	) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
	
//  DASHBOARD (SUCCESSFUL LOGIN)
    @GetMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
    	String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        if (currentUser.isAdmin()) {
        	return "redirect:/admin";
        }
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("studentDisplay", new Student());
        model.addAttribute("studentRoster", new ArrayList<Student>());
        
        return "dashboard.jsp"; 
    }

    
}
