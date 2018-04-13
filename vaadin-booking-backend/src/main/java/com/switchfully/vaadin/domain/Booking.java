package com.switchfully.vaadin.domain;

import static com.switchfully.vaadin.domain.BookingId.bookingId;

public class Booking {

    private BookingId id;
    private DateRange period;
    private int numberOfGuests;
    private int numberOfRooms;
    private String guestFirstName;
    private String guestSurName;

    private Booking(BookingBuilder builder) {
        this.id = builder.id;
        this.period = builder.period;
        this.numberOfGuests = builder.numberOfGuests;
        this.numberOfRooms = builder.numberOfRooms;
        this.guestFirstName = builder.guestFirstName;
        this.guestSurName = builder.guestSurName;
    }

    public BookingId getId() {
        return id;
    }

    public DateRange getPeriod() {
        return period;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public String getGuestSurName() {
        return guestSurName;
    }

    public void setPeriod(DateRange period) {
        this.period = period;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public void setGuestSurName(String guestSurName) {
        this.guestSurName = guestSurName;
    }

    public static class BookingBuilder {

        private BookingId id;
        private DateRange period;
        private int numberOfGuests;
        private int numberOfRooms;
        private String guestFirstName;
        private String guestSurName;

        public static BookingBuilder booking() {
            return new BookingBuilder();
        }

        public static BookingBuilder cloneBooking(Booking booking) {
            return new BookingBuilder()
                    .withId(booking.getId())
                    .withPeriod(booking.getPeriod())
                    .withNumberOfGuests(booking.getNumberOfGuests())
                    .withNumberOfRooms(booking.getNumberOfRooms())
                    .withGuestFirstName(booking.getGuestFirstName())
                    .withGuestSurName(booking.getGuestSurName());
        }

        private BookingBuilder() {
        }

        public Booking build() {
            return new Booking(this);
        }

        public BookingBuilder withId() {
            if (id == null) id = bookingId();
            return this;
        }

        public BookingBuilder withId(BookingId id) {
            this.id = id;
            return this;
        }

        public BookingBuilder withPeriod(DateRange period) {
            this.period = period;
            return this;
        }

        public BookingBuilder withNumberOfGuests(int numberOfGuests) {
            this.numberOfGuests = numberOfGuests;
            return this;
        }

        public BookingBuilder withNumberOfRooms(int numberOfRooms) {
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public BookingBuilder withGuestFirstName(String guestFirstName) {
            this.guestFirstName = guestFirstName;
            return this;
        }

        public BookingBuilder withGuestSurName(String guestSurName) {
            this.guestSurName = guestSurName;
            return this;
        }
    }
}
