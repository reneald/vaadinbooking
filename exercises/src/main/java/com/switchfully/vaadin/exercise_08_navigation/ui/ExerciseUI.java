package com.switchfully.vaadin.exercise_08_navigation.ui;

import com.switchfully.vaadin.exercise_08_navigation.ui.views.AccomodationDetailView;
import com.switchfully.vaadin.exercise_08_navigation.ui.views.SearchAccomodationView;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    public static final String VIEW_ACCOMODATION_HOME = "";
    public static final String VIEW_ACCOMODATION_DETAIL = "detail";

    private AccomodationService accomodationService;
    private Navigator navigator;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(VIEW_ACCOMODATION_HOME, new SearchAccomodationView(accomodationService));
        navigator.addView(VIEW_ACCOMODATION_DETAIL, new AccomodationDetailView(accomodationService));
    }

}