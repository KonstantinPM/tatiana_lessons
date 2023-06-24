package com.softserve.itacademy.todolist.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;

import com.softserve.itacademy.todolist.dto.user.CreateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UpdateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UserResponse;
import com.softserve.itacademy.todolist.dto.validator.UserRequestValidator;
import com.softserve.itacademy.todolist.model.User;
import com.softserve.itacademy.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRequestValidator requestValidator;

    @GetMapping
    ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll().stream()
                                            .map(UserResponse::new)
                                            .collect(Collectors.toList()));
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
        requestValidator.validate(createUserRequest);
        User createdUser = userService.create(User.builder()
                                                  .firstName(createUserRequest.getFirstName())
                                                  .lastName(createUserRequest.getLastName())
                                                  .email(createUserRequest.getEmail())
                                                  .password(createUserRequest.getPassword())
                                                  .role(createUserRequest.getRole())
                                                  .build());
        return ResponseEntity.ok(new UserResponse(createdUser));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest userRequest) {
        requestValidator.validate(userRequest);
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
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
