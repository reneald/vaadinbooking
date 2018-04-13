package com.switchfully.vaadin.exercise_01_basic_layouts.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class BookingUI extends UI {

    @Autowired
    public BookingUI() {
    }

    @Override
    protected void init(VaadinRequest request) {
        // Using VerticalLayout and HorizontalLayout, create
        Label firstNameCaption = new Label("First Name:");
        Label firstName = new Label("Donald");

        Label surNameCaption = new Label("Surname:");
        Label surName = new Label("Trump");

        HorizontalLayout firstNameLayout = new HorizontalLayout(firstNameCaption, firstName);
        firstNameLayout.setSpacing(true);
        HorizontalLayout surNameLayout = new HorizontalLayout(surNameCaption, surName);
        surNameLayout.setSpacing(true);

        VerticalLayout mainLayout = new VerticalLayout(firstNameLayout, surNameLayout);

        setContent(mainLayout);
    }

}