package com.switchfully.vaadin.exercise_12_model_view_presenter.ui;

import com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components.AccomodationAdminModel;
import com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components.AccomodationAdminPresenter;
import com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components.AccomodationAdminViewImpl;
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
        AccomodationAdminViewImpl accomodationAdminView = new AccomodationAdminViewImpl();
        new AccomodationAdminPresenter(new AccomodationAdminModel(accomodationService, cityService), accomodationAdminView);

        setContent(accomodationAdminView);
    }

}