package com.switchfully.vaadin.exercise_07_images.ui.components;

import com.switchfully.vaadin.common.Paths;
import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

public class AccomodationResult extends CustomComponent {

    private Accomodation accomodation;

    public AccomodationResult(Accomodation accomodation) {
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

        Panel panel = new Panel(main);

        setCompositionRoot(panel);
    }
}
