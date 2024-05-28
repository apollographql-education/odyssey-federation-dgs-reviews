package com.example.reviews.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReviewDto {

    public String listing;
    private Integer id;
    private String text;
    public Float rating;
}
