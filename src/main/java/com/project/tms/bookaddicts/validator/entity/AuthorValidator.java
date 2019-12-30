package com.project.tms.bookaddicts.validator.entity;

import com.project.tms.bookaddicts.pojo.Author;
import com.project.tms.bookaddicts.validator.Patterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Service
public class AuthorValidator implements Validator {

    @Autowired
    AuthorValidator authorValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Author author = (Author) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");

        if (!Pattern.compile(Patterns.NAME_PATTERN.getPattern()).matcher(author.getName()).matches()) {
            errors.rejectValue("name", "Wrong.name");
        }
        if (!Pattern.compile(Patterns.NAME_PATTERN.getPattern()).matcher(author.getSurname()).matches()) {
            errors.rejectValue("surname", "Wrong.surname");
        }
        if (!Pattern.compile(Patterns.NAME_PATTERN.getPattern()).matcher(author.getPatronymic()).matches()) {
            errors.rejectValue("patronymic", "Wrong.patronymic");
        }
    }
}
