package com.softserve.itacademy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    @OneToMany
//    @JoinColumn(name = "todo_id")
//    private List<ToDoCollaborator> collaborators;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "user_todo", joinColumns = {@JoinColumn(name = "todo_id")},
                                inverseJoinColumns = {@JoinColumn(name="user_id")})

    private List<User> owners ;


}

