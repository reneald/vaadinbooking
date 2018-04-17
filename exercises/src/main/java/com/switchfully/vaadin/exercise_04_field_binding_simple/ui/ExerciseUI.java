package com.switchfully.vaadin.exercise_04_field_binding_simple.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.vaadin.ui.AbstractTextField.TextChangeEventMode.EAGER;
import static com.vaadin.ui.AbstractTextField.TextChangeEventMode.LAZY;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        // Create a TextField and a Label, both bound to the same 'name' Property.
        // Add a button to commit the field.
        // Clicking the button should update the Label with the value in the TextField.

        // Extra credits: Add a checkbox to hide the button and make the TextField auto-commit.

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}