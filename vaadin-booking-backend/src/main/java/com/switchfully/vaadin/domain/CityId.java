package com.switchfully.vaadin.domain;

public final class CityId extends Id {

    private CityId() {
        super();
    }

    private CityId(String id) {
        super(id);
    }

    public static CityId cityId() {
        return new CityId();
    }

    public static CityId fromString(String id) {
        return new CityId(id);
    }

}
