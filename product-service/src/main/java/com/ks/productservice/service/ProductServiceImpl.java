package com.ks.productservice.service;

import com.ks.productservice.entity.Product;
import com.ks.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Modelo de Servicio implementacion Productos.
 * @author Edwin Pinchao
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
    productRepository.deleteById(id);

    }

    @Override
    public List<Product> findByNombre(String term) {

        return productRepository.findByName(term) ;
    }

    @Override
    public Optional<Product> findProductoByid(Long id) {

        return  productRepository.findById(id);
    }
}
