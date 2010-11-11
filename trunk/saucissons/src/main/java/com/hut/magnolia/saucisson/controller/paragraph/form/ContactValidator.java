package com.hut.magnolia.saucisson.controller.paragraph.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ContactValidator {
    private static final String nameField = "name";
    private static final String emailField = "email";

    public boolean supports(Class<?> clazz) {
        return ContactBean.class.equals(clazz);
    }

    public void validate(Object formbean, Errors errors) {
        ContactBean fbean = (ContactBean) formbean;
        // PersonName validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, nameField, "name.field.required", "Name cannot be blank");

        // Email validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, emailField, "email.field.required", "Email cannot be blank");
        // Ensure the email address contains an @
        boolean validEmail = true;
        int atIndex = fbean.getEmail().indexOf('@');
        if (atIndex <= 0) {
            validEmail = false;
        }
        // Ensure there is at least one dot after the "@" sign
        String afterTheAt = fbean.getEmail().substring(atIndex + 1);
        // Split the part after the @ on the dot.
        // Ensure that all the dot separated parts have at least one character
        String[] afterParts = afterTheAt.split("\\.");
        if (afterParts.length < 2) {
            validEmail = false;
        }
        for (String part : afterParts) {
            if (part.trim().length() < 1) {
                validEmail = false;
            }
        }
        if (!validEmail) {
            errors.rejectValue(emailField, "email.invalid", "Email is invalid");
        }
    }
}
