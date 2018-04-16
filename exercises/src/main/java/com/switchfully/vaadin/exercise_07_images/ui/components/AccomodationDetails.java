package com.switchfully.vaadin.exercise_07_images.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AccomodationDetails extends CustomComponent {

    private Accomodation accomodation;

    public AccomodationDetails(Accomodation accomodation) {
        this.accomodation = accomodation;

        Label name = new Label(accomodation.getName());
        name.addStyleName(ValoTheme.LABEL_H3);

        StarRatingComponent rating = new StarRatingComponent(accomodation.getStarRating());
        rating.addStyleName(ValoTheme.LABEL_H3);

        HorizontalLayout nameAndRating = new HorizontalLayout(name, rating);
        nameAndRating.setSpacing(true);

        Label city = new Label("In " + accomodation.getCity().getName());
        city.addStyleName(ValoTheme.LABEL_BOLD);

        Label description = new Label(accomodation.getDescription());
        description.setContentMode(ContentMode.HTML);

        VerticalLayout mainLeft = new VerticalLayout(nameAndRating, city, description);
//        VerticalLayout mainRight = new VerticalLayout();

        HorizontalLayout main = new HorizontalLayout(mainLeft /*, mainRight*/);
        main.setWidth("100%");
        setCompositionRoot(main);
    }
}
