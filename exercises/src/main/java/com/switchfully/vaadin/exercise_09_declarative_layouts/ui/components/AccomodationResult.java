package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components;

import com.switchfully.vaadin.common.Paths;
import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.event.MouseEvents;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

public class AccomodationResult extends CustomComponent {

    private Accomodation accomodation;
    private final Panel panel;

    public AccomodationResult(Accomodation accomodation) {
        // TODO Exercise 9 (Extra): Change this component to use Declarative Layout
        this.accomodation = accomodation;
        VerticalLayout main = new VerticalLayout();

        // Image as a file resource
        FileResource resource = new FileResource(new File(
                Paths.IMAGES_PATH + accomodation.getImagePath()));

        // Show the image in the application
        Image accomodationImage = new Image();
        accomodationImage.setSource(resource);
        accomodationImage.setWidth("300px");

        AccomodationDetails accomodationDetails = new AccomodationDetails(this.accomodation);
        accomodationDetails.setWidth("100%");

        HorizontalLayout horizontalLayout = new HorizontalLayout(accomodationImage, accomodationDetails);
        horizontalLayout.setExpandRatio(accomodationDetails, 1.0f);
        horizontalLayout.setWidth("100%");

        main.addComponent(
                horizontalLayout
        );

        panel = new Panel(main);
        panel.setData(this.accomodation);

        setCompositionRoot(panel);
    }

    public void addClickListener(MouseEvents.ClickListener listener) {
        panel.addClickListener(listener);
    }

    Accomodation getAccomodation() {
        return this.accomodation;
    }
}
