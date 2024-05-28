package com.example.reviews.service;

import com.example.reviews.dto.ReviewDto;
import com.example.reviews.repository.ReviewRepository;
import com.example.reviews.util.EntityDtoUtil;
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
