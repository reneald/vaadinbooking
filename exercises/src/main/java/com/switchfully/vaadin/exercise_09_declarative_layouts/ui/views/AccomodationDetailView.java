package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.views;

import com.switchfully.vaadin.common.Paths;
import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.AccomodationId;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.ExerciseUI;
import com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components.AccomodationDetails;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

public class AccomodationDetailView extends CustomComponent implements View {

    private AccomodationService accomodationService;
    private final VerticalLayout mainLayout;

    public AccomodationDetailView(AccomodationService accomodationService) {
        // TODO Exercise 9 (Extra): Change this view to use Declarative Layout
        this.accomodationService = accomodationService;

        mainLayout = new VerticalLayout();
        setCompositionRoot(mainLayout);
    }

    private void init(AccomodationId accomodationId) {
        mainLayout.removeAllComponents();
        Accomodation accomodation = accomodationService.getAccomodation(accomodationId);

        FileResource resource = new FileResource(new File(
                Paths.IMAGES_PATH + accomodation.getImagePath()));

        // Show the image in the application
        Image accomodationImage = new Image();
        accomodationImage.setSource(resource);
        accomodationImage.setWidth("600px");

        AccomodationDetails accomodationDetails = new AccomodationDetails(accomodation);

        Button backButton = new Button("Back to search",
                e -> getUI().getNavigator().navigateTo(ExerciseUI.VIEW_ACCOMODATION_HOME));

        mainLayout.addComponents(backButton, accomodationImage, accomodationDetails);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        System.out.println("View parameters: " + event.getParameters());
        AccomodationId accomodationId = AccomodationId.fromString(event.getParameters());
        init(accomodationId);
    }

}
