package com.softserve.itacademy.todolist.controller;

import com.softserve.itacademy.todolist.dto.user.CreateUserRequest;
import com.softserve.itacademy.todolist.dto.user.UpdateUserRequest;
import com.softserve.itacademy.todolist.model.Role;
import com.softserve.itacademy.todolist.model.User;
import com.softserve.itacademy.todolist.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice()
                .build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("johndoe@example.com");
        user1.setRole(new Role());

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setEmail("janesmith@example.com");
        user2.setRole(new Role());

        List<User> users = Arrays.asList(user1, user2);

        given(userService.getAll()).willReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(users.size()))
                .andExpect(jsonPath("$[0].id").value(user1.getId()));

        verify(userService, times(1)).getAll();
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserById() throws Exception {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        user.setRole(new Role());

        given(userService.readById(userId)).willReturn(user);

        mockMvc.perform(get("/api/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(user.getId()));

        verify(userService, times(1)).readById(userId);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserById_UserNotFound() throws Exception {
        Long userId = 1L;

        given(userService.readById(userId)).willReturn(null);

        mockMvc.perform(get("/api/users/{id}", userId))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).readById(userId);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testCreateUser() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("John");
        createUserRequest.setLastName("Doe");
        createUserRequest.setEmail("johndoe@example.com");
        createUserRequest.setPassword("password");
        createUserRequest.setRole(new Role());

        User createdUser = new User();
        createdUser.setId(1L);
        createdUser.setFirstName(createUserRequest.getFirstName());
        createdUser.setLastName(createUserRequest.getLastName());
        createdUser.setEmail(createUserRequest.getEmail());
        createdUser.setPassword(createUserRequest.getPassword());
        createdUser.setRole(createUserRequest.getRole());

        given(userService.create(any(User.class))).willReturn(createdUser);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(createUserRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(createdUser.getId()))
                .andExpect(jsonPath("$.email").value(createdUser.getEmail()));

        verify(userService, times(1)).create(any(User.class));
        verifyNoMoreInteractions(userService);
    }

//    @Test
//    public void testUpdateUser() throws Exception {
//        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
//        updateUserRequest.setId(1L);
//        updateUserRequest.setFirstName("John");
//        updateUserRequest.setLastName("Doe");
//        updateUserRequest.setEmail("johndoe@example.com");
//        updateUserRequest.setPassword("newpassword");
//        updateUserRequest.setRole(new Role());
//
//        User updatedUser = new User();
//        updatedUser.setId(1L);
//        updatedUser.setFirstName("John");
//        updatedUser.setLastName("Doe");
//        updatedUser.setEmail("johndoe@example.com");
//        updatedUser.setPassword("newpassword");
//        updatedUser.setRole(updatedUser.getRole());
//
//        given(userService.update(any(User.class))).willReturn(updatedUser);
//
//        mockMvc.perform(put("/api/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(updateUserRequest)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(updatedUser.getId()))
//                .andExpect(jsonPath("$.email").value(updatedUser.getEmail()));
//
//        verify(userService, times(1)).update(any(User.class));
//        verifyNoMoreInteractions(userService);
//    }

    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L;

        mockMvc.perform(delete("/api/users/{id}", userId))
                .andExpect(status().isNoContent());

        verify(userService, times(1)).delete(userId);
        verifyNoMoreInteractions(userService);
    }

    private String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}