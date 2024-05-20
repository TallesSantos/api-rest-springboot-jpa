package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository reporitory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sholdFindAllUsers() {
        //Given
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "João", "joao@gmail.com", "5199999999", "123456");
        User user2 = new User(2L, "Maria", "maria@gmail.com", "5199999999", " 654321");

        userList.add(user1);
        userList.add(user2);

        //Mock the call
        when(reporitory.findAll()).thenReturn(userList);

        //wen
        List<User> response = service.findAll();

        assertEquals(response.size(), userList.size());

    }

    @Test
    void sholdFindUserById() {
        //given
        User user = new User(1L, "João", "joao@gmail.com", "5199999999", "123456");

        Long userId = 1L;

        //Mock the call
        when(reporitory.findById(userId))
                .thenReturn(Optional.of(user));

        var response = service.findById(userId);
        assertEquals(response.getName(), user.getName());
    }

    @Test
    void sholdInsertUser() {
        //given
        List<User> userList = new ArrayList<>();
        User user = new User(1L, "João", "joao@gmail.com", "5199999999", "123456");


        User savedUser = new User(1L, "João", "joao@gmail.com", "5199999999", "123456");
        userList.add(user);

        //mock the call
        when(reporitory.save(user))
                .thenReturn(savedUser);

        //wen
        var response = service.insert(user);

        //then
        assertEquals(response.getName(), savedUser.getName());
    }

    @Test
    void sholdDeleteUser() {
      //TODO
    }

    @Test
    void sholdUpdateUser() {
        //TODO
    }
}