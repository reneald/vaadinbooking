package com.switchfully.vaadin.service;

import com.switchfully.vaadin.domain.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.City.CityBuilder.city;

@Service
public class CityService {

    static final City AMSTERDAM = city().withName("Amsterdam").build();
    static final City BERLIN = city().withName("Berlin").build();
    static final City BRUSSELS = city().withName("Brussels").build();
    static final City LONDON = city().withName("London").build();
    static final City NEW_YORK = city().withName("New York").build();
    static final City PARIS = city().withName("Paris").build();

    private List<City> cities = new ArrayList<>();

    public CityService() {
        initData();
    }

    private void initData() {
        cities.add(AMSTERDAM);
        cities.add(BERLIN);
        cities.add(BRUSSELS);
        cities.add(LONDON);
        cities.add(NEW_YORK);
        cities.add(PARIS);
    }

    public List<City> getCities() {
        return cities;
    }

}
