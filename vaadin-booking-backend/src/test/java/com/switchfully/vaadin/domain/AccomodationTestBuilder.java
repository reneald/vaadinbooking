package com.switchfully.vaadin.domain;

import java.time.Instant;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;
import static com.switchfully.vaadin.domain.AccomodationId.accomodationId;
import static com.switchfully.vaadin.domain.City.CityBuilder.city;

public class AccomodationTestBuilder {

    private final Accomodation.AccomodationBuilder builder;

    private AccomodationTestBuilder() {
        builder = accomodation()
            .withId(accomodationId())
            .withName("Dummy hotel name")
            .withCity(city().withName("Brussels").build())
            .withDateCreated(Instant.now())
            .withDescription("Dummy test description")
            .withImagePath("path/to/image.jpg")
            .withNumberOfRooms(120)
            .withStarRating(StarRating.FOUR_STARS)
        ;
    }

    public static AccomodationTestBuilder anAccomodation() {
        return new AccomodationTestBuilder();
    }

    public Accomodation build() {
        return builder.build();
    }

    public AccomodationTestBuilder withNumberOfRooms(int numberOfRooms) {
        builder.withNumberOfRooms(numberOfRooms);
        return this;
    }

    public AccomodationTestBuilder withDateCreated(Instant dateCreated) {
        builder.withDateCreated(dateCreated);
        return this;
    }

    public AccomodationTestBuilder withStarRating(StarRating starRating) {
        builder.withStarRating(starRating);
        return this;
    }

    public AccomodationTestBuilder withCity(City city) {
        builder.withCity(city);
        return this;
    }

    public AccomodationTestBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public AccomodationTestBuilder withImagePath(String imagePath) {
        builder.withImagePath(imagePath);
        return this;
    }

    public AccomodationTestBuilder withDescription(String description) {
        builder.withDescription(description);
        return this;
    }
}