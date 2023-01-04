package com.heytonyyy.studentsupportsystem.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.heytonyyy.studentsupportsystem.models.User;

@Component
public class UserValidator implements Validator {
    

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        // MSG TEXT LOCATED --> messages.propperties
        
        // ERROR MSG IF PW'S DONT MATCH
        if (!user.getConfirm().equals(user.getPassword())) {
            errors.rejectValue("confirm", "Match");
        }
        
        // ERROR MSG IF USERNAME TOO SHORT
        if (user.getUsername().length() < 3) {
        	errors.rejectValue("username", "Username");
        }
        
        // ERROR MSG IF PW TOO SHORT
        if (user.getPassword().length() < 8) {
        	errors.rejectValue("password", "Password");
        }
        
    }
}
