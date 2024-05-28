package com.example.reviews.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReviewDto {

    private Integer id;
    private String text;
    private Float rating;
    private String listing;
}
