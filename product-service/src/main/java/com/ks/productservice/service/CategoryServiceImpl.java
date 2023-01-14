package com.ks.productservice.service;

import com.ks.productservice.entity.Category;
import com.ks.productservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return  categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByNombre(String term) {
        return categoryRepository.findByName(term);
    }

    @Override
    public Category findCategoryByid(Long id) {
        return null;
    }
}
