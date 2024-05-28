package com.example.reviews.datafetchers;
import com.example.reviews.controller.ReviewController;
import com.example.reviews.dto.ReviewDto;
import com.example.reviews.generated.types.Listing;
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

    @DgsEntityFetcher(name = "Listing")
    public Listing resolveListingReference(Map<String, Object> entityRepresentation) {
        String id = (String) entityRepresentation.get("id");
        Listing listing = new Listing();
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
