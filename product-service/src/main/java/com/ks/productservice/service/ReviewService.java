package com.ks.productservice.service;

import com.ks.productservice.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public List<Review> findAll();
    Review save(Review review);
    public void delete(Long id);
    public Optional<Review> findReviewByid(Long id);
}
