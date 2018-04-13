package com.switchfully.vaadin.domain;

public final class BookingId extends Id {

    private BookingId() {
        super();
    }

    private BookingId(String id) {
        super(id);
    }

    public static BookingId bookingId() {
        return new BookingId();
    }

    public static BookingId fromString(String id) {
        return new BookingId(id);
    }

}
