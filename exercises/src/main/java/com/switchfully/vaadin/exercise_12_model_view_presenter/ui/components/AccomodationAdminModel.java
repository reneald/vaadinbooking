package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;
import static java.util.stream.Collectors.toList;

public class AccomodationAdminModel {

    private final List<City> cities;
    private AccomodationService accomodationService;

    private String searchFilter = "";
    private List<Accomodation> accomodations;
    private List<Accomodation> resultList;

    private Accomodation activeAccomodation;

    private List<AccomodationAdminModelListener> listeners = new ArrayList<>();

    public AccomodationAdminModel(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cities = cityService.getCities();

        this.accomodations = accomodationService.getAccomodations();

        setSearchFilter("");
    }

    public void addListener(AccomodationAdminModelListener listener) {
        this.listeners.add(listener);
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Accomodation> getResultList() {
        return resultList;
    }

    public Accomodation getActiveAccomodation() {
        return activeAccomodation;
    }

    public String getSearchFilter() {
        return searchFilter;
    }

    public void setNewActiveAccomodation() {
        this.setActiveAccomodation(accomodation().build());
    }

    public void setActiveAccomodation(Accomodation accomodation) {
        this.activeAccomodation = accomodation;
        this.listeners.forEach(l -> l.activeAccomodationChanged(accomodation));
    }

    public void saveAccomodation(Accomodation accomodation) {
        accomodationService.save(accomodation);
        this.accomodations = accomodationService.getAccomodations();
        updateResultList();
    }

    public void deleteAccomodation(Accomodation accomodation) {
        accomodationService.delete(accomodation.getId());
        this.accomodations = accomodationService.getAccomodations();
        updateResultList();
    }

    public void setSearchFilter(String searchFilter) {
        this.searchFilter = searchFilter;
        updateResultList();
    }

    private void updateResultList() {
        this.resultList = this.accomodations.stream()
                .filter(acc -> acc.getName().toLowerCase().contains(this.searchFilter.toLowerCase()))
                .collect(toList());
        this.listeners.forEach(l -> l.resultListChanged(this.resultList));
    }

    public interface AccomodationAdminModelListener {

        void resultListChanged(List<Accomodation> newResultList);
        void activeAccomodationChanged(Accomodation accomodation);

    }

}
