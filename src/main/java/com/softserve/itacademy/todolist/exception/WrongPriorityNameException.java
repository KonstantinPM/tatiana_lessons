package com.softserve.itacademy.todolist.exception;

import com.softserve.itacademy.todolist.model.Priority;

public class WrongPriorityNameException extends RuntimeException {

    public WrongPriorityNameException(String priority) {
        super("You set incorrect Task priority: " + priority + ". Valid priorities are: " + getPossiblePriorities());
    }
    private static String getPossiblePriorities() {
        StringBuilder sb = new StringBuilder();
        Priority[] priorities = Priority.values();

        for (int i = 0; i < priorities.length; i++) {
            sb.append(priorities[i]);

            if (i < priorities.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
