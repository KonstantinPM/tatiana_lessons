package com.softserve.itacademy.todolist.controller;

import com.softserve.itacademy.todolist.dto.toDo.CreateToDoRequest;
import com.softserve.itacademy.todolist.dto.toDo.ToDoResponse;
import com.softserve.itacademy.todolist.dto.toDo.UpdateToDoRequest;
import com.softserve.itacademy.todolist.model.ToDo;
import com.softserve.itacademy.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/{user_id}/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


@GetMapping
public List<ToDoResponse> getAll() {
    return toDoService.getAll().stream()
            .map(ToDoResponse::new)
            .collect(Collectors.toList());
}

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponse> getById(@PathVariable Long id) {
        ToDo toDo = toDoService.readById(id);
        if (toDo != null) {
            ToDoResponse toDoResponse = new ToDoResponse(toDo);
            return ResponseEntity.ok(toDoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoResponse> createToDo(@RequestBody CreateToDoRequest createToDoRequest) {
        ToDo createdToDo = toDoService.create(ToDo.builder()
                .title(createToDoRequest.getTitle())
                .createdAt(LocalDateTime.now())
                .owner(createToDoRequest.getOwner())
                .tasks(new ArrayList<>())
                .collaborators(createToDoRequest.getCollaborators())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ToDoResponse(createdToDo));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoResponse> updateToDo(@RequestBody UpdateToDoRequest updateToDoRequest) {
        ToDo updatedToDo = toDoService.update(ToDo.builder()
                .id(updateToDoRequest.getId())
                .title(updateToDoRequest.getTitle())
                .createdAt(updateToDoRequest.getCreatedAt())
                .owner(updateToDoRequest.getOwner())
                .tasks(updateToDoRequest.getTasks())
                .collaborators(updateToDoRequest.getCollaborators())
                .build());
        if (updatedToDo != null) {
            return ResponseEntity.ok(new ToDoResponse(updatedToDo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}