package com.softserve.itacademy.todolist.exception;

import com.softserve.itacademy.todolist.dto.user.CreateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UpdateUserRequest;
import com.softserve.itacademy.todolist.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

public class ValidatorException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(ValidatorException.class);

    public ValidatorException(String message) {
        super(message);
    }

    public static void validate(CreateUserRequest createUserRequest) throws ValidatorException {
        if (createUserRequest.getFirstName() == null || createUserRequest.getFirstName().isEmpty()) {
            throw new ValidatorException("First name is required.");
        }

        if (createUserRequest.getLastName() == null || createUserRequest.getLastName().isEmpty()) {
            throw new ValidatorException("Last name is required.");
        }

        if (createUserRequest.getEmail() == null || createUserRequest.getEmail().isEmpty()) {
            throw new ValidatorException("Email is required.");
        }

        if (createUserRequest.getPassword() == null || createUserRequest.getPassword().isEmpty()) {
            throw new ValidatorException("Password is required.");
        }

        if (createUserRequest.getRole() == null) {
            throw new ValidatorException("Role is required.");
        }
    }

    public static void validate(UpdateUserRequest updateUserRequest) throws ValidatorException {
        if (updateUserRequest.getId() == null) {
            throw new ValidatorException("User ID is required.");
        }

        if (updateUserRequest.getFirstName() == null || updateUserRequest.getFirstName().isEmpty()) {
            throw new ValidatorException("First name is required.");
        }

        if (updateUserRequest.getLastName() == null || updateUserRequest.getLastName().isEmpty()) {
            throw new ValidatorException("Last name is required.");
        }

        if (updateUserRequest.getEmail() == null || updateUserRequest.getEmail().isEmpty()) {
            throw new ValidatorException("Email is required.");
        }
        if (updateUserRequest.getPassword() == null || updateUserRequest.getPassword().isEmpty()) {
            throw new ValidatorException("Password is required.");
        }
        if (updateUserRequest.getRole() == null) {
            throw new ValidatorException("Role is required.");
        }
    }

    public static void validate (User user) throws ValidatorException{
        if (user == null) {
            throw new EntityNotFoundException("User not found.");
        }
    }
}
