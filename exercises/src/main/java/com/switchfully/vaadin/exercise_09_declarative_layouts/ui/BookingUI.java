package com.switchfully.vaadin.exercise_09_declarative_layouts.ui;

import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views.AccomodationDetailView;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views.SearchAccomodationView;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class BookingUI extends UI {

    public static final String VIEW_ACCOMODATION_HOME = "";
    public static final String VIEW_ACCOMODATION_DETAIL = "detail";

    private AccomodationService accomodationService;
    private Navigator navigator;

    @Autowired
    public BookingUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // Solution: ADD start
        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(VIEW_ACCOMODATION_HOME, new SearchAccomodationView(accomodationService));
        navigator.addView(VIEW_ACCOMODATION_DETAIL, new AccomodationDetailView(accomodationService));
        // Solution: ADD end

        // Solution: REMOVE start

//        AccomodationResultList resultList = new AccomodationResultList();
//
//        TextField searchField = new TextField();
//        Button searchButton = new Button("Search",
//                event -> resultList.setAccomodations(
//                accomodationService.findAccomodations(searchField.getValue())
//        ));
//
//        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

//        VerticalLayout mainLayout = new VerticalLayout(searchLayout, resultList);
//        setContent(mainLayout);

        // Solution: REMOVE end
    }

}