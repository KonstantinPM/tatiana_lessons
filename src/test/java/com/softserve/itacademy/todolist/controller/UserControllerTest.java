package com.softserve.itacademy.todolist.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.itacademy.todolist.dto.user.UserResponse;
import com.softserve.itacademy.todolist.dto.validator.UserRequestValidator;
import com.softserve.itacademy.todolist.model.Role;
import com.softserve.itacademy.todolist.model.User;
import com.softserve.itacademy.todolist.service.impl.UserServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebSecurityConfigurer.class)})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserServiceImpl userService;
    @MockBean
    private UserRequestValidator userRequestValidator;

    @SneakyThrows
    @Test
    void shouldGetAll() {
        List<User> userList = List.of(User.builder().firstName("Petya").role(new Role(1L, "ADMIN")).build(),
                                      User.builder().firstName("Vasya").role(new Role(1L, "ADMIN")).build());
        when(userService.getAll()).thenReturn(userList);

        List<UserResponse> userResponses = List.of(new UserResponse(userList.get(0)), new UserResponse(userList.get(1)));
        mockMvc.perform(get("/api/users"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json(objectMapper.writeValueAsString(userResponses)));
    }
}