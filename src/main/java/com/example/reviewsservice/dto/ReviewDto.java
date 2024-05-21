package com.example.reviewsservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReviewDto {

    private Integer id;
    private String text;
    private Float rating;
}
