package com.softserve.itacademy.todolist.dto.toDo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softserve.itacademy.todolist.model.Task;
import com.softserve.itacademy.todolist.model.User;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateToDoRequest {

    private Long id;

    private String title;

    private LocalDateTime createdAt;

    private User owner;

    private List<Task> tasks;

    private List<User> collaborators;

}
