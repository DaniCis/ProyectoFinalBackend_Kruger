package com.ks.productservice.controller;


import com.ks.productservice.entity.Category;
import com.ks.productservice.entity.Product;
import com.ks.productservice.entity.Review;
import com.ks.productservice.service.ProductService;
import com.ks.productservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        List<Review> reviews = reviewService.findAll();
        if(reviews.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getById(@PathVariable("id") Long id){
        Optional<Review> review = reviewService.findReviewByid(id);
        if(review==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(review);
    }

    @PostMapping()
    public ResponseEntity<Review> save(@RequestBody Review review){
        Optional<Product> product= productService.findProductoByid(review.getProduct().getId());
      review.setProduct(product.get());
        Review reviewNew = reviewService.save(review);
        return ResponseEntity.ok(reviewNew);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Review> update(@RequestBody Review review,@PathVariable("id") Long id ){

        Optional<Product> product = productService.findProductoByid(review.getProduct().getId());
        Review review1 = reviewService.findReviewByid(id).get();
       review1.setRating(review.getRating());
       review1.setText(review.getText());
       review1.setProduct(product.get());
        Review reviewNew = reviewService.save(review1);
       return ResponseEntity.ok(reviewNew);
    }


}
