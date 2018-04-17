package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views;

import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.ExerciseUI;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components.AccomodationResultList;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class SearchAccomodationView extends CustomComponent implements View {

    public SearchAccomodationView(AccomodationService accomodationService) {
        // TODO Exercise 9: Change this view to use Declarative Layout

        AccomodationResultList resultList = new AccomodationResultList();
        resultList.addItemClickListener(accomodation -> {
            getUI().getNavigator().navigateTo(ExerciseUI.VIEW_ACCOMODATION_DETAIL + "/" + accomodation.getId().toString());
        });

        TextField searchField = new TextField();
        Button searchButton = new Button("Search",
                event -> resultList.setAccomodations(
                        accomodationService.findAccomodations(searchField.getValue())
                ));

        HorizontalLayout searchLayout = new HorizontalLayout(searchField, searchButton);

        VerticalLayout mainLayout = new VerticalLayout(searchLayout, resultList);

        setCompositionRoot(mainLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
