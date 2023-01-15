package com.ks.productservice.controller;

import com.ks.productservice.entity.Category;
import com.ks.productservice.entity.Product;
import com.ks.productservice.service.CategoryService;
import com.ks.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable("id") Long id){
        Optional<Product> product = productService.findProductoByid(id);
        if(product==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){

       Optional< Category> category= categoryService.findCategoryByid(product.getCategory().getId());

        product.setCategory(category.get());
        Product productNew = productService.save(product);
        return ResponseEntity.ok(productNew);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable("id") Long id ){
        Optional< Category> category= categoryService.findCategoryByid(product.getCategory().getId());
        Product product1= productService.findProductoByid(id).get();
        product1.setCategory(category.get());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setStatus(product.isStatus());
        Product productNew = productService.save(product1);
        return ResponseEntity.ok(productNew);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


}
