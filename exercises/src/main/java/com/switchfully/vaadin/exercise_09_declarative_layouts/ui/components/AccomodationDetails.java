package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;

public class AccomodationDetails extends CustomComponent {

    private AccomodationDetailsDesign design = new AccomodationDetailsDesign();

    public AccomodationDetails() {
        Design.read(design);

        design.name.addStyleName(ValoTheme.LABEL_H3);
        design.rating.addStyleName(ValoTheme.LABEL_H3);

        design.city.addStyleName(ValoTheme.LABEL_BOLD);
        design.description.setContentMode(ContentMode.HTML);

        setCompositionRoot(design);
    }

    public void setAccomodation(Accomodation accomodation) {
        design.name.setValue(accomodation.getName());
        design.rating.setStarRating(accomodation.getStarRating());
        design.city.setValue("In " + accomodation.getCity().getName());
        design.description.setValue(accomodation.getDescription());
    }

    @DesignRoot
    public static class AccomodationDetailsDesign extends VerticalLayout {

        Label name;
        StarRatingComponent rating;
        Label city;
        Label description;

    }

}
