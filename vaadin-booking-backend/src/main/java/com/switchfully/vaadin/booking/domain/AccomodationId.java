package com.switchfully.vaadin.booking.domain;

public final class AccomodationId extends Id {

    private AccomodationId() {
        super();
    }

    private AccomodationId(String id) {
        super(id);
    }

    public static AccomodationId accomodationId() {
        return new AccomodationId();
    }

    public static AccomodationId fromString(String id) {
        return new AccomodationId(id);
    }

}
