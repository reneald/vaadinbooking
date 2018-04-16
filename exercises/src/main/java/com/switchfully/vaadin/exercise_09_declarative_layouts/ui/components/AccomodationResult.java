package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components;

import com.switchfully.vaadin.common.Paths;
import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.event.MouseEvents;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;

import java.io.File;

public class AccomodationResult extends CustomComponent {

    private Accomodation accomodation;
    private AccomodationResultDesign design = new AccomodationResultDesign();

    public AccomodationResult() {
        Design.read(design);

        setCompositionRoot(design);
    }

    public void addClickListener(MouseEvents.ClickListener listener) {
        design.addClickListener(listener);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;

        FileResource resource = new FileResource(new File(
                Paths.IMAGES_PATH + accomodation.getImagePath()));
        design.accomodationImage.setSource(resource);
        design.accomodationDetails.setAccomodation(accomodation);
        design.setData(this.accomodation);
    }

    Accomodation getAccomodation() {
        return this.accomodation;
    }

    @DesignRoot
    public static class AccomodationResultDesign extends Panel {

        Image accomodationImage;
        AccomodationDetails accomodationDetails;

    }

}
