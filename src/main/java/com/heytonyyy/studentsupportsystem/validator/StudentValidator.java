package com.heytonyyy.studentsupportsystem.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.heytonyyy.studentsupportsystem.models.Student;

@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
    	Student student = (Student) object;
        
        // MSG TEXT LOCATED --> messages.propperties
        
    	// ERROR MSG IF STUDENT LAST NAME IS BLANK
        if (student.getFirstName().length() < 1) {
            errors.rejectValue("firstName", "StudentFirstName");
        }
        
        // ERROR MSG IF STUDENT LAST NAME IS BLANK
        if (student.getLastName().length() < 1) {
        	errors.rejectValue("lastName", "StudentLastName");
        }
        
        // ERROR MSG IF GUARDIAN FIRST NAME IS BLANK
        if (student.getGuardianFirstName().length() < 1) {
        	errors.rejectValue("guardianFirstName", "GuardianFirstName");
        }
        
        // ERROR MSG IF GUARDIAN LAST NAME IS BLANK
        if (student.getGuardianLastName().length() < 1) {
        	errors.rejectValue("guardianLastName", "GuardianLastName");
        }
        
    }
}
