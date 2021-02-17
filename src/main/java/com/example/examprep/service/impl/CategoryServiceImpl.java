package com.example.examprep.service.impl;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.enums.CategoryName;
import com.example.examprep.repository.CategoryRepository;
import com.example.examprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName);
                        categoryRepository.save(category);
                    });
        }
    }
}
