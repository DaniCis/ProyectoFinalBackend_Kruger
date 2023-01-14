package com.ks.productservice.controller;


import com.ks.productservice.entity.Review;
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
        Review reviewNew = reviewService.save(review);
        return ResponseEntity.ok(reviewNew);
    }



}
