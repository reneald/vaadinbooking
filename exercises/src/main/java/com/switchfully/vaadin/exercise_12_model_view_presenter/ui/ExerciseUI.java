package com.switchfully.vaadin.exercise_12_model_view_presenter.ui;

import com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components.AccomodationAdmin;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    private AccomodationService accomodationService;
    private CityService cityService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // TODO Exercise 12: Refactor this exercise using the Model-View-Presenter pattern.
        // TODO Exercise 12 (Extra): Write an (integration) test for the Presenter using the actual model, mocks for the services, and a test stub implementing the View interface.

        setContent(new AccomodationAdmin(this.accomodationService, this.cityService));
    }

}
