package com.ks.productservice.service;

import com.ks.productservice.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Modelo de interfaz tabla product.
 * @author Edwin Pincha
 *
 */
public interface ProductService {

    public List<Product> findAll();
    Product save(Product product);
    public void delete(Long id);
    public List<Product> findByNombre(String term);
    public Optional<Product> findProductoByid(Long id);

}
