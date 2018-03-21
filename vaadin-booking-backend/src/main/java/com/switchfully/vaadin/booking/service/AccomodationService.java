package com.switchfully.vaadin.booking.service;

import com.switchfully.vaadin.booking.domain.Accomodation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.booking.domain.Accomodation.AccomodationBuilder.accomodation;

@Service
public class AccomodationService {

    public List<Accomodation> getAccomodations() {
        List<Accomodation> accomodations = new ArrayList<>();
        accomodations.add(accomodation().withName("Hilton Paris Centre").build());
        accomodations.add(accomodation().withName("Hyatt Paris Nord").build());
        accomodations.add(accomodation().withName("Novotel Paris Centre").build());
        return accomodations;
    }

}
