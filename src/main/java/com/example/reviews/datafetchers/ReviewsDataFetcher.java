package com.example.reviews.datafetchers;
import com.example.reviews.dto.ReviewDto;
import com.example.reviews.controller.ReviewController;
import com.example.reviews.dto.SubmitReviewResponseModel;
import com.example.reviews.entity.Review;
import com.example.reviews.generated.types.Listing;
import com.example.reviews.generated.types.ReviewInput;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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

    @DgsMutation
    public SubmitReviewResponseModel submitReview(@InputArgument String listingId, @InputArgument ReviewInput review) {
        SubmitReviewResponseModel submitReviewResponse = new SubmitReviewResponseModel();

        try {
           Mono<Review> createdReview = this.reviewController.submitReview(listingId, review);
            submitReviewResponse.setSubmittedReview(createdReview);
            submitReviewResponse.setCode(200);
            submitReviewResponse.setSuccess(true);
            submitReviewResponse.setMessage("Review successfully submitted.");
        } catch (Exception e) {
            submitReviewResponse.setCode(500);
            submitReviewResponse.setSuccess(false);
            submitReviewResponse.setMessage("Failed to save review.");
        }

        return submitReviewResponse;
    }

    // Create separate datafetcher method to extract submitted review property so we dont block the Mono<Review>
    @DgsData(parentType = "SubmitReviewResponse")
    public Mono<Review> review(DgsDataFetchingEnvironment dfe) {
        SubmitReviewResponseModel submitReviewResponse = dfe.getSource();
        return submitReviewResponse.getSubmittedReview();
    }

    @DgsEntityFetcher(name = "Listing")
    public Listing resolveListingReference(Map<String, Object> entityRepresentation) {
        Listing listing = new Listing();
        String id = (String) entityRepresentation.get("id");
        listing.setId(id);
        return listing;
    }

    @DgsData(parentType="Listing")
    public Flux<ReviewDto> reviews(DgsDataFetchingEnvironment dfe) {
        Listing listing = dfe.getSource();
        String id = listing.getId();
        return this.reviewController.reviewsForListing(id);
    }

    @DgsData(parentType="Listing")
    public Mono<Float> overallRating(DgsDataFetchingEnvironment dfe) {
        Listing listing = dfe.getSource();
        String id = listing.getId();
        return this.reviewController.averageRatingForListing(id);
    }
}
