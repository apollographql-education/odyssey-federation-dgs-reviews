package com.example.reviews.controller;

import com.example.reviews.service.ReviewService;
import com.example.reviews.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("all")
    public Flux<ReviewDto> all() {
        return this.service.all();
    }

    @GetMapping("reviewsForListing")
    public Flux<ReviewDto> reviewsForListing(String listingId) {

        return this.service.findByListingId(listingId);

    }

    @GetMapping("averageRatingForListing")
    public Mono<Float> averageRatingForListing(String listingId) {
        return this.service.findRatingsByListingId(listingId);
    }
}
