package com.switchfully.vaadin.exercise_01_basic_layouts.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class ExerciseUI extends UI {

    @Autowired
    public ExerciseUI() {
    }

    @Override
    protected void init(VaadinRequest request) {
        // TODO Exercise 1: Using VerticalLayout and HorizontalLayout, create a button layout resembling the buttons of an old school cellphone.

        // Use the Button component to create the buttons:
        // Button one = new Button("1");

        // Don't forget to set your main layout using setContent(myLayout)

    }

}