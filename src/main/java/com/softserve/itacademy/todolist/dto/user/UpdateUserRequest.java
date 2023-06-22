package com.softserve.itacademy.todolist.dto.user;

import com.softserve.itacademy.todolist.model.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateUserRequest {

    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    Role role;
}
