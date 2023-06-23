package com.softserve.itacademy.todolist.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TaskDto {
    private long id;

    @NotBlank(message = "The 'name' cannot be empty")
    private String name;

    @NotNull
    private String priority;

    @NotNull
    private long todoId;

    @NotNull
    private long stateId;

    @NotNull
    private String stateName;

    public TaskDto() {
    }

    public TaskDto(long id, String name, String priority, long todoId, long stateId, String stateName) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.todoId = todoId;
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskDto taskDto = (TaskDto) o;

        if (id != taskDto.id) return false;
        if (todoId != taskDto.todoId) return false;
        if (stateId != taskDto.stateId) return false;
        if (!Objects.equals(name, taskDto.name)) return false;
        if (!Objects.equals(priority, taskDto.priority)) return false;
        return Objects.equals(stateName, taskDto.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priority, todoId, stateId, stateName);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", todoId=" + todoId +
                ", stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
