package com.example.reviewsservice.service;

import com.example.reviewsservice.dto.ReviewDto;
import com.example.reviewsservice.repository.ReviewRepository;
import com.example.reviewsservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Flux<ReviewDto> all() {
        return this.reviewRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
}
