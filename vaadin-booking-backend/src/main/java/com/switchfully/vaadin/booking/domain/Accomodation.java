package com.switchfully.vaadin.booking.domain;

import java.time.Instant;

import static com.switchfully.vaadin.booking.domain.AccomodationId.accomodationId;

public class Accomodation {

    private AccomodationId id;
    private String name;
    private int numberOfRooms;
    private StarRating starRating;
    private Instant dateCreated;

    public Accomodation(AccomodationBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.numberOfRooms = builder.numberOfRooms;
        this.starRating = builder.starRating;
        this.dateCreated = builder.dateCreated;
    }

    public AccomodationId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public static class AccomodationBuilder {

        public AccomodationId id = accomodationId();
        private String name;
        private int numberOfRooms;
        private Instant dateCreated = Instant.now();
        private StarRating starRating;

        public static AccomodationBuilder accomodation() {
            return new AccomodationBuilder();
        }

        private AccomodationBuilder() {}

        public Accomodation build() {
            return new Accomodation(this);
        }

        public AccomodationBuilder withNumberOfRooms(int numberOfRooms) {
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public AccomodationBuilder withDateCreated(Instant dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public AccomodationBuilder withStarRating(StarRating starRating) {
            this.starRating = starRating;
            return this;
        }

        public AccomodationBuilder withName(String name) {
            this.name = name;
            return this;
        }
    }

}
