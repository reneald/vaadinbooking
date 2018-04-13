package com.switchfully.vaadin.domain;

import java.time.Instant;

import static com.switchfully.vaadin.domain.AccomodationId.accomodationId;

public class Accomodation {

    private AccomodationId id;
    private String name;
    private int numberOfRooms;
    private StarRating starRating;
    private Instant dateCreated;
    private City city;

    private Accomodation(AccomodationBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.numberOfRooms = builder.numberOfRooms;
        this.starRating = builder.starRating;
        this.dateCreated = builder.dateCreated;
        this.city = builder.city;
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

    public City getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isPersisted() {
        return id != null;
    }

    public static class AccomodationBuilder {

        private AccomodationId id;
        private String name;
        private int numberOfRooms;
        private Instant dateCreated = Instant.now();
        private StarRating starRating;
        private City city;

        public static AccomodationBuilder accomodation() {
            return new AccomodationBuilder();
        }

        public static AccomodationBuilder cloneAccomodation(Accomodation accomodation) {
            return new AccomodationBuilder()
                    .withId(accomodation.getId())
                    .withName(accomodation.getName())
                    .withNumberOfRooms(accomodation.getNumberOfRooms())
                    .withCity(accomodation.getCity())
                    .withDateCreated(accomodation.getDateCreated())
                    .withStarRating(accomodation.getStarRating());
        }

        private AccomodationBuilder() {
        }

        public Accomodation build() {
            return new Accomodation(this);
        }

        public AccomodationBuilder withId() {
            if (id == null) id = accomodationId();
            return this;
        }

        public AccomodationBuilder withId(AccomodationId id) {
            this.id = id;
            return this;
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

        public AccomodationBuilder withCity(City city) {
            this.city = city;
            return this;
        }

        public AccomodationBuilder withName(String name) {
            this.name = name;
            return this;
        }
    }

}
