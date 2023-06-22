package com.softserve.itacademy.todolist.controller;

import com.softserve.itacademy.todolist.dto.ToDoResponse;
import com.softserve.itacademy.todolist.model.ToDo;
import com.softserve.itacademy.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/{user_id}/todos")
public class ToDoController {

    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoResponse>> getTodosByUserId(@PathVariable("user_id") long userId) {
        List<ToDo> todos = toDoService.getByUserId(userId);
        List<ToDoResponse> todoResponses = todos.stream()
                .map(ToDoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(todoResponses);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<ToDoResponse> getToDoById(
            @PathVariable("user_id") long user_id, @PathVariable("todoId") long todoId) {
        ToDo toDo = toDoService.readById(todoId);
        if (toDo != null) {
            ToDoResponse toDoResponse = new ToDoResponse(toDo);
            return ResponseEntity.ok(toDoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> updateToDo(
            @PathVariable("user_id") Long userId, @PathVariable("id") Long id, @RequestBody ToDo toDo) {
        if (toDo.getOwner() != null && toDo.getOwner().getId().equals(userId)) {
            toDo.setId(id);
            ToDo updatedToDo = toDoService.update(toDo);
            if (updatedToDo != null) {
                ToDoResponse toDoResponse = new ToDoResponse(updatedToDo);
                return ResponseEntity.ok(toDoResponse);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable("id") Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}