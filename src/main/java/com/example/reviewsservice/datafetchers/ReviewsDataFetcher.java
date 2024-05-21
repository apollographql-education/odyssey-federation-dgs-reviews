package com.example.reviewsservice.datafetchers;
import com.example.reviewsservice.controller.ReviewController;
import com.example.reviewsservice.dto.ReviewDto;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

@DgsComponent
public class ReviewsDataFetcher {

    private final ReviewController reviewController;

    @Autowired
    public ReviewsDataFetcher(ReviewController reviewController) {
        this.reviewController = reviewController;
    }

    @DgsQuery
    public Flux<ReviewDto> allReviews() {
        return this.reviewController.all();
    }
}
