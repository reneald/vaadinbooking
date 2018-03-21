package com.switchfully.vaadin.domain;

public enum StarRating {

    NO_STARS(0), ONE_STAR(1), TWO_STARS(1), THREE_STARS(1), FOUR_STARS(1), FIVE_STARS(1);

    private int numberOfStars;

    StarRating(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

}
