package com.example.reviewsservice.util;

import com.example.reviewsservice.dto.ReviewDto;
import com.example.reviewsservice.entity.Review;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static ReviewDto toDto(Review review) {
        ReviewDto dto = new ReviewDto();
        BeanUtils.copyProperties(review, dto);
        return dto;
    }

    public static Review toEntity(ReviewDto dto) {
        Review review = new Review();
        BeanUtils.copyProperties(dto, review);
        return review;
    }

}
