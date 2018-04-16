package com.switchfully.vaadin.exercise_xx_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.Booking;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class BookingDetailsComponent extends CustomComponent {

    private final Label guestFirstNameLabel;
    private final Label guestSurnameLabel;
    private final Label numberOfGuestsLabel;
    private final Label numberOfRoomsLabel;
    private final Label periodLabel;

    public BookingDetailsComponent() {
        guestFirstNameLabel = new Label();
        guestSurnameLabel = new Label();
        numberOfGuestsLabel = new Label();
        numberOfRoomsLabel = new Label();
        periodLabel = new Label();

        GridLayout grid = new GridLayout(2, 5);
        grid.setSpacing(true);

        grid.addComponent(new Label("First Name"));
        grid.addComponent(guestFirstNameLabel);
        grid.addComponent(new Label("Surname"));
        grid.addComponent(guestSurnameLabel);
        grid.addComponent(new Label("Number of guests"));
        grid.addComponent(numberOfGuestsLabel);
        grid.addComponent(new Label("Number of rooms"));
        grid.addComponent(numberOfRoomsLabel);
        grid.addComponent(new Label("Period"));
        grid.addComponent(periodLabel);

        VerticalLayout mainLayout = new VerticalLayout(
                new Label("Thanks for booking with us! Here are your booking details:"),
                grid);

        setCompositionRoot(mainLayout);
    }

    public void setBooking(Booking booking) {
        guestFirstNameLabel.setValue(booking.getGuestFirstName());
        guestSurnameLabel.setValue(booking.getGuestSurName());
        numberOfGuestsLabel.setValue(Integer.toString(booking.getNumberOfGuests()));
        numberOfRoomsLabel.setValue(Integer.toString(booking.getNumberOfRooms()));
        periodLabel.setValue(booking.getPeriod().toString());
    }

}
