package com.softserve.itacademy.todolist.dto.validator;

import com.softserve.itacademy.todolist.dto.user.CreateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UpdateUserRequest;
import com.softserve.itacademy.todolist.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRequestValidator {

    public void validate(CreateUserRequest createUserRequest) throws ValidationException {
        if (createUserRequest.getFirstName() == null || createUserRequest.getFirstName().isEmpty()) {
            throw new ValidationException("First name is required.");
        }

        if (createUserRequest.getLastName() == null || createUserRequest.getLastName().isEmpty()) {
            throw new ValidationException("Last name is required.");
        }

        if (createUserRequest.getEmail() == null || createUserRequest.getEmail().isEmpty()) {
            throw new ValidationException("Email is required.");
        }

        if (createUserRequest.getPassword() == null || createUserRequest.getPassword().isEmpty()) {
            throw new ValidationException("Password is required.");
        }

        if (createUserRequest.getRole() == null) {
            throw new ValidationException("Role is required.");
        }
    }

    public void validate(UpdateUserRequest updateUserRequest) throws ValidationException {
        if (updateUserRequest.getId() == null) {
            throw new ValidationException("User ID is required.");
        }

        if (updateUserRequest.getFirstName() == null || updateUserRequest.getFirstName().isEmpty()) {
            throw new ValidationException("First name is required.");
        }

        if (updateUserRequest.getLastName() == null || updateUserRequest.getLastName().isEmpty()) {
            throw new ValidationException("Last name is required.");
        }

        if (updateUserRequest.getEmail() == null || updateUserRequest.getEmail().isEmpty()) {
            throw new ValidationException("Email is required.");
        }
        if (updateUserRequest.getPassword() == null || updateUserRequest.getPassword().isEmpty()) {
            throw new ValidationException("Password is required.");
        }
        if (updateUserRequest.getRole() == null) {
            throw new ValidationException("Role is required.");
        }
    }
}
