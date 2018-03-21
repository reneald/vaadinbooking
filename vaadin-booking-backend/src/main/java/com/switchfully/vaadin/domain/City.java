package com.switchfully.vaadin.domain;

public class City {

    private CityId id;
    private String name;

    public City(City.CityBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public CityId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class CityBuilder {

        public CityId id = CityId.cityId();
        private String name;

        public static City.CityBuilder city() {
            return new City.CityBuilder();
        }

        private CityBuilder() {}

        public City build() {
            return new City(this);
        }

        public City.CityBuilder withName(String name) {
            this.name = name;
            return this;
        }
    }

}
