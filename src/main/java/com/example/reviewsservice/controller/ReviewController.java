package com.example.reviewsservice.controller;

import com.example.reviewsservice.dto.ReviewDto;
import com.example.reviewsservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("all")
    public Flux<ReviewDto> all() {
        return this.service.all();
    }
}
