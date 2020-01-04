package com.project.tms.bookaddicts.validator.entity;

import com.project.tms.bookaddicts.pojo.Book;
import com.project.tms.bookaddicts.validator.Patterns;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Service
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfPages", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publicationYear", "NotEmpty");

        if (!Pattern.compile(Patterns.NUMBER_PATTERN.getPattern()).matcher(String.valueOf(book.getNumberOfPages())).matches()) {
            errors.rejectValue("numberOfPages", "Wrong.number");
        }
    }
}
