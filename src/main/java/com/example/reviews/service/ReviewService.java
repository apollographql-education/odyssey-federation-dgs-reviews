package com.example.reviews.service;

import com.example.reviews.entity.Review;
import com.example.reviews.repository.ReviewRepository;
import com.example.reviews.dto.ReviewDto;
import com.example.reviews.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Flux<ReviewDto> all() {
        return this.reviewRepository.findAllReviews();
    }

    public Flux<ReviewDto> findByListingId(String listingId) {
        return this.reviewRepository.findByListingId(listingId);
    }

    public Mono<Float> findRatingsByListingId(String listingId) {
        return this.reviewRepository.findRatingsByListingId(listingId);
    }

    public Mono<Review> createReviewForListing(ReviewDto review) {

        Review reviewEntity = EntityDtoUtil.toEntity(review);
        return this.reviewRepository.save(reviewEntity);
    }
}
