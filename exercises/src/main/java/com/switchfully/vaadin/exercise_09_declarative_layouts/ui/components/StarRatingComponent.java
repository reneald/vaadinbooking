package com.switchfully.vaadin.exercise_09_declarative_layouts.ui.components;

import com.switchfully.vaadin.domain.StarRating;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

public class StarRatingComponent extends CustomComponent {

    private Label label;

    public StarRatingComponent() {
        super();
        this.label = new Label();
        this.label.setContentMode(ContentMode.HTML);
        setCompositionRoot(label);
    }

    public void setStarRating(StarRating starRating) {
        this.label.setValue(generateStars(starRating));
    }

    @Override
    public void addStyleName(String style) {
        this.label.addStyleName(style);
    }

    private String generateStars(StarRating starRating) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < starRating.getNumberOfStars(); i++) {
            str.append(FontAwesome.STAR.getHtml());
        }
        return str.toString();
    }

}
