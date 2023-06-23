package com.softserve.itacademy.todolist.exception;

public class EmptyNameException extends RuntimeException {

    public EmptyNameException() {
        super("Name can't be empty");
    }
}
