package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @InjectMocks
    private ProductService service;
    @Mock
    private ProductRepository reporitory;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldFindProductById(){
        //given
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setId(1L);
        product.setName("Arroz");
        product.setDescription("Arroz branco, a alma gêmea do feijão");
        product.setPrice(15.00);
        product.setImageUrl("www.img-de-arroz.png");

        productList.add(product);
        Long productId = 1L;

        //Mock the call
        when(reporitory.findById(productId))
                .thenReturn(Optional.of(product));

        var response = service.findById(productId);
        assertEquals(product.getName(), response.getName());
    }

    @Test
    void shouldFindAllProducts() {
        //Given
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1L, "Arroz", "Arroz branco, a alma gêmea do feijão", 15.00, "www.img-de-arroz.png");
        Product product2 =  new Product(2L, "Feijao", "Feijão preto, a alma gêmea do arroz", 18.00, "www.img-de-feijao.png");

        productList.add(product1);
        productList.add(product2);

        //Mock the call
        when(reporitory.findAll()).thenReturn(productList);

        //wen
        List<Product> response = service.findAll();

        assertEquals(response.size(), productList.size());
    }


}