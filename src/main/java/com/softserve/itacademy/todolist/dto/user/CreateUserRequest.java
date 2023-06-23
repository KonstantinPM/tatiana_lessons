package com.softserve.itacademy.todolist.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softserve.itacademy.todolist.model.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {

    String firstName;
    String lastName;
    String email;
    String password;
    Role role;
}
