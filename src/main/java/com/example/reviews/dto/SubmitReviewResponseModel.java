package com.example.reviews.dto;

import com.example.reviews.entity.Review;
import com.example.reviews.generated.types.SubmitReviewResponse;
import reactor.core.publisher.Mono;

public class SubmitReviewResponseModel extends SubmitReviewResponse {

    public Mono<Review> getSubmittedReview() {
        return submittedReview;
    }

    public void setSubmittedReview(Mono<Review> submittedReview) {
        this.submittedReview = submittedReview;
    }

    Mono<Review> submittedReview;
}
