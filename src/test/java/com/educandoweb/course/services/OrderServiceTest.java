package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @InjectMocks
    private OrderService service;
    @Mock
    private OrderRepository reporitory;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldFindCategoryById(){
        //given
        Instant moment = Instant.now();
        Order order = new Order();
        order.setId(1L);
        order.setMoment(moment);
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        Long orderId = 1L;

        //Mock the call
        when(reporitory.findById(orderId))
                .thenReturn(Optional.of(order));

        var response = service.findById(orderId);
        assertEquals(moment, response.getMoment());

    }
    @Test
    void shouldFindAllCategories() {
        //Given
        Instant moment1 = Instant.now();
        Instant moment2 = Instant.now();
        Order order1 = new Order();
        order1.setId(1L);
        order1.setMoment(moment1);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setMoment(moment2);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        //Mock the call
        when(reporitory.findAll()).thenReturn(orderList);

        //wen
        List<Order> response = service.findAll();

        assertEquals(response.size(), orderList.size());
    }

}