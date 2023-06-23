package com.softserve.itacademy.todolist.controller;

import com.softserve.itacademy.todolist.dto.user.UpdateUserRequest;
import com.softserve.itacademy.todolist.dto.user.CreateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UserResponse;
import com.softserve.itacademy.todolist.model.User;
import com.softserve.itacademy.todolist.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.softserve.itacademy.todolist.exception.ValidatorException.validate;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    List<UserResponse> getAll() {
        return userService.getAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        User user = userService.readById(id);
        if (user != null) {
            UserResponse userResponse = new UserResponse(user);
            return ResponseEntity.ok(userResponse);
        } else {
            throw new EntityNotFoundException("User not found.");
            //return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        validate(createUserRequest);
        User createdUser = userService.create(User.builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .role(createUserRequest.getRole())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(createdUser));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest userRequest) {
        validate(userRequest);
        User updatedUser = userService.update(User.builder()
                .id(userRequest.getId())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build());
        if (updatedUser != null) {
            return ResponseEntity.ok(new UserResponse(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.readById(id);

        if (user == null) {
            throw new EntityNotFoundException("User not found.");
        }
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
