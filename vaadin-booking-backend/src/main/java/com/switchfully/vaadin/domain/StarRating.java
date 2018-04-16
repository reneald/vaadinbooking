package com.switchfully.vaadin.domain;

public enum StarRating {

    NO_STARS(0), ONE_STAR(1), TWO_STARS(2), THREE_STARS(3), FOUR_STARS(4), FIVE_STARS(5);

    private int numberOfStars;

    StarRating(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

}
