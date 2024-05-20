package com.educandoweb.course.services;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class CategoryServiceTest {
    @InjectMocks
    private CategoryService service;
    @Mock
    private CategoryRepository reporitory;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldFindCategoryById(){
        //given
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();
        category.setId(1L);
        category.setName("food");
        categoryList.add(category);
        Long categoryId = 1L;

        //Mock the call
        when(reporitory.findById(categoryId))
                .thenReturn(Optional.of(category));

        var response = service.findById(categoryId);
        assertEquals(category.getName(), response.getName());

    }
    @Test
    void shouldFindAllCategories() {
        //Given
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category(1L, "food");
        Category category2 = new Category(2L, "gym");
        categoryList.add(category1);
        categoryList.add(category2);

        //Mock the call
        when(reporitory.findAll()).thenReturn(categoryList);

        //wen
        List<Category> response = service.findAll();

        assertEquals(response.size(), categoryList.size());
    }

}