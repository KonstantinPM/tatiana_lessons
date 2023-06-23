package com.softserve.itacademy.todolist.controller;


import com.softserve.itacademy.todolist.dto.TaskDto;
import com.softserve.itacademy.todolist.dto.TaskTransformer;
import com.softserve.itacademy.todolist.exception.EmptyNameException;
import com.softserve.itacademy.todolist.exception.WrongPriorityNameException;
import com.softserve.itacademy.todolist.exception.WrongStateId;
import com.softserve.itacademy.todolist.exception.WrongToDoId;
import com.softserve.itacademy.todolist.model.Priority;
import com.softserve.itacademy.todolist.model.State;
import com.softserve.itacademy.todolist.model.Task;
import com.softserve.itacademy.todolist.model.ToDo;
import com.softserve.itacademy.todolist.service.impl.StateServiceImpl;
import com.softserve.itacademy.todolist.service.impl.TaskServiceImpl;
import com.softserve.itacademy.todolist.service.impl.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;
    private final StateServiceImpl stateServiceImpl;

    private final ToDoServiceImpl toDoServiceImpl;

    @Autowired
    public TaskController(TaskServiceImpl taskServiceIml, StateServiceImpl stateServiceImpl, ToDoServiceImpl toDoServiceImpl) {
        this.taskServiceImpl = taskServiceIml;
        this.stateServiceImpl = stateServiceImpl;
        this.toDoServiceImpl = toDoServiceImpl;
    }

    @GetMapping()
    public List<TaskDto> getAllTasks() {
        List<Task> arrayList = taskServiceImpl.getAll();
        return arrayList.stream()
                .map(TaskTransformer::convertToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskDtoById(@PathVariable long id) {
        return TaskTransformer.convertToDto(taskServiceImpl.readById(id));
    }

    @PostMapping()
    public TaskDto createNewTask(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "priority") String priority,
                                 @RequestParam(value = "SetStateId") long stateId,
                                 @RequestParam(value = "SetTodoId") long todoId) {

        List<String> possiblePriorities = Arrays.stream(Priority.values())
                .map(Enum::name).toList();
        List<Long> stateList = stateServiceImpl.getAll().stream().map(State::getId).toList();
        List<Long> todosIds = toDoServiceImpl.getAll().stream().map(ToDo::getId).toList();

        if (name.isEmpty()) {
            throw new EmptyNameException();
        }

        if (!possiblePriorities.contains(priority)) {
            throw new WrongPriorityNameException(priority);
        }
        if (!stateList.contains(stateId)){
            throw new WrongStateId(stateId,stateList);
        }
        if (!todosIds.contains(todoId)){
            throw new WrongToDoId(todoId,todosIds);
        }


//        Task task = new Task();
//        System.out.println(task);
//        task.setName(name);
//        task.setPriority(Priority.LOW);
//        task.setState(new State());
//        task.setTodo(new ToDo());
//        taskServiceImpl.create(task);
        return null;

    }
}
