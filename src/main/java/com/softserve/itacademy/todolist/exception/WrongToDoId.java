package com.softserve.itacademy.todolist.exception;

import java.util.List;

public class WrongToDoId extends RuntimeException {

    public WrongToDoId (long toDoId, List<Long> todoList) {
        super("You set incorrect ToDoId: " + toDoId + ". Valid todo id are: " + todoList);
    }
}
