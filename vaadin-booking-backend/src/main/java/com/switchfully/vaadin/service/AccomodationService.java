package com.switchfully.vaadin.service;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.StarRating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccomodationService {

    private List<Accomodation> accomodations = new ArrayList<>();

    public AccomodationService() {
        initData();
    }

    private void initData() {
        // Amsterdam
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Tulip")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.THREE_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Onder dat brugje")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.NO_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Estherea")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.FIVE_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Breitner House")
                .withCity(CityService.AMSTERDAM)
                .withStarRating(StarRating.FOUR_STARS)
                .build());

        // Berlin
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Otto")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.FOUR_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Unter der Brücke")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.NO_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Edelweiss")
                .withCity(CityService.BERLIN)
                .withStarRating(StarRating.TWO_STARS)
                .build());

        // Brussels
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Amigo")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.FIVE_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("B&B Onder de Brug")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.NO_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Regency Hotel")
                .withCity(CityService.BRUSSELS)
                .withStarRating(StarRating.FOUR_STARS)
                .build());

        // London
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("The Royal Horseguards")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FIVE_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hilton London Westminster")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FOUR_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Under The Bridge")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.NO_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Shangri-La Hotel, At The Shard")
                .withCity(CityService.LONDON)
                .withStarRating(StarRating.FOUR_STARS)
                .build());

        // New-York
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hotel Trump")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.FOUR_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Chelsea International Hostel")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.ONE_STAR)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("The Plaza")
                .withCity(CityService.NEW_YORK)
                .withStarRating(StarRating.FIVE_STARS)
                .build());

        // Paris
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hilton Paris Centre")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.FOUR_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Hyatt Paris Nord")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.FOUR_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Novotel Paris Centre")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.THREE_STARS)
                .build());
        accomodations.add(Accomodation.AccomodationBuilder.accomodation()
                .withName("Sous le Pont")
                .withCity(CityService.PARIS)
                .withStarRating(StarRating.NO_STARS)
                .build());
    }

    public List<Accomodation> getAccomodations() {
        return accomodations;
    }

}
