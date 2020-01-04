package com.project.tms.bookaddicts.validator.entity;

import com.project.tms.bookaddicts.validator.Patterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.project.tms.bookaddicts.pojo.User;
import com.project.tms.bookaddicts.service.UserService;

import java.util.regex.Pattern;

@Service
public class UserValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");

        if (!Pattern.compile(Patterns.NAME_PATTERN.getPattern()).matcher(user.getName()).matches()) {
            errors.rejectValue("name", "Wrong.name");
        }
        if (!Pattern.compile(Patterns.NAME_PATTERN.getPattern()).matcher(user.getSurname()).matches()) {
            errors.rejectValue("surname", "Wrong.surname");
        }

        if (user.getEmail().length() < 4 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }
        if (userService.findEmailWithoutCurrantId(user.getEmail(), user.getId()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.username");
        }
        if (!Pattern.compile(Patterns.EMAIL_PATTERN.getPattern()).matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "Wrong.email");
        }

    }
}
