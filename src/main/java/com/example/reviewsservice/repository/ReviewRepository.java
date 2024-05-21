package com.example.reviewsservice.repository;

import com.example.reviewsservice.entity.Review;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Integer> {
}
