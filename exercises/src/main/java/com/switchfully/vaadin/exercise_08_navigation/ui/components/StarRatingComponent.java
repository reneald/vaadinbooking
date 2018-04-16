package com.switchfully.vaadin.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.StarRating;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class StarRatingComponent extends Label {

    public StarRatingComponent(StarRating starRating) {
        super();
        this.setValue(generateStars(starRating));
        this.setContentMode(ContentMode.HTML);
    }

    private String generateStars(StarRating starRating) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < starRating.getNumberOfStars(); i++) {
            str.append(FontAwesome.STAR.getHtml());
        }
        return str.toString();
    }

}
