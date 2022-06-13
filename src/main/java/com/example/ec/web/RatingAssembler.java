package com.example.ec.web;

import com.example.ec.domain.TourRating;
import com.example.ec.repo.TourRepository;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;

/**
 * Rating Assembler, convert TourRating to a Hateoas Supported Rating class
 *
 * Created by maryellenbowman.
 */
@Component
public class RatingAssembler extends RepresentationModelAssemblerSupport<TourRating,RatingDto> {

    //Helper to fetch Spring Data Rest Repository links.
    private RepositoryEntityLinks entityLinks;

    public RatingAssembler( RepositoryEntityLinks entityLinks) {
        super(RatingController.class, RatingDto.class);
        this.entityLinks = entityLinks;
    }

    /**
     *  Generates "self", "rating" and tour links
     *
     * @param tourRating Tour Rating Entity
     * @return
     */
    @Override
    public RatingDto toModel(TourRating tourRating) {
        RatingDto rating = new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getCustomerId());

        // "self" : ".../ratings/{ratingId}"
        WebMvcLinkBuilder ratingLink = linkTo(methodOn(RatingController.class).getRating(tourRating.getId()));
        rating.add(ratingLink.withSelfRel());

        //"tour" : ".../tours/{tourId}"
       Link tourLink = entityLinks.linkToItemResource(TourRepository.class, tourRating.getTour().getId());
       rating.add(tourLink.withRel("tour"));
       return rating;
    }

    public List<RatingDto> toModels(List<TourRating> tourRatings) {

        List<RatingDto> ratingDtos = Collections.emptyList();
        tourRatings.forEach(tr -> ratingDtos.add(new RatingDto(tr.getScore(), tr.getComment(), tr.getCustomerId())));

        return ratingDtos;
    }

}
