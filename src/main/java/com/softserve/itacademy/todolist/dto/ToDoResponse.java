package com.softserve.itacademy.todolist.dto;

import com.softserve.itacademy.todolist.model.ToDo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ToDoResponse {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private Long ownerId;

    public ToDoResponse(ToDo toDo) {
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.createdAt = toDo.getCreatedAt();
        this.ownerId = toDo.getOwner().getId();
    }

}
