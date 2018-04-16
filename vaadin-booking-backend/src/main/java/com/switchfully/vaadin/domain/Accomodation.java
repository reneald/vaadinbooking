package com.switchfully.vaadin.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.switchfully.vaadin.domain.AccomodationId.accomodationId;
import static java.util.Collections.unmodifiableList;

public class Accomodation {

    private AccomodationId id;
    private String name;
    private String description;
    private int numberOfRooms;
    private StarRating starRating;
    private Instant dateCreated;
    private City city;
    private String imagePath;

    private List<Booking> bookings = new ArrayList<>();

    private Accomodation(AccomodationBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.imagePath = builder.imagePath;
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

    public List<Booking> getBookings() {
        return unmodifiableList(bookings);
    }

    public void addBooking(Booking booking) {
        // TODO: validate availability.
        this.bookings.add(booking);
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

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public static class AccomodationBuilder {

        private static final String DEFAULT_DESCRIPTION = "Lorem <b>ipsum</b> dolor sit <u>amet</u>, " +
                "consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor " +
                "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        private static final String DEFAULT_IMAGE = "generic_hotel.jpg";

        private AccomodationId id;
        private String name;
        private String description = DEFAULT_DESCRIPTION;
        private String imagePath = DEFAULT_IMAGE;
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
                    .withImagePath(accomodation.getImagePath())
                    .withDescription(accomodation.getDescription())
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

        public AccomodationBuilder withImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public AccomodationBuilder withDescription(String description) {
            this.description = description;
            return this;
        }
    }

}
