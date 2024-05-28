package com.example.reviews.repository;

import com.example.reviews.entity.Review;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Integer> {
}
