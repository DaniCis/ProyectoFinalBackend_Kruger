package com.ks.productservice.repository;

import com.ks.productservice.entity.Category;
import com.ks.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByName (String name);

    List<Category> findByCategory (Category category);


}
