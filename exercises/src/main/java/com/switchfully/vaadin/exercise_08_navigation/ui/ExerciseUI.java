package com.switchfully.vaadin.exercise_08_navigation.ui;

import com.switchfully.vaadin.exercise_08_navigation.ui.components.AccomodationResultList;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // TODO Exercise 8: Add an accomodation Detail view that is opened when you click on a result in the list.
        // TODO Exercise 8: Use the Vaadin Navigator to navigate between the list and detail views. Make the detail view have a different url, such as: /accomodation/{id} so that this view is bookmarkable and supports the back button.

        AccomodationResultList resultList = new AccomodationResultList();

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccomodations(
                accomodationService.findAccomodations(searchField.getValue())
        ));

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        VerticalLayout mainLayout = new VerticalLayout(searchLayout, resultList);
        setContent(mainLayout);
    }

}