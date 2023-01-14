package com.ks.productservice.service;

import com.ks.productservice.entity.Category;
import com.ks.productservice.entity.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();
    Category save(Category category);
    public void delete(Long id);
    public List<Category> findByNombre(String term);
    public Category findCategoryByid(Long id);
}
