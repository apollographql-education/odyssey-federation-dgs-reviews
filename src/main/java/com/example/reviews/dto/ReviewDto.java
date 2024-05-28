package com.example.reviews.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReviewDto {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public Integer id;
    public String text;
    public double rating;
    public String listing;
}
