package com.switchfully.vaadin.exercise_04_field_binding_simple.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Property<String> name = new ObjectProperty<>("name");
        TextField input = new TextField("input", name);
        Label output = new Label(name);
        CheckBox autoCommit = new CheckBox("auto commit");
        Button commit = new Button("Commit input");

        autoCommit.addValueChangeListener(valueChangeEvent -> {
            input.setImmediate(autoCommit.getValue());
            commit.setVisible(!autoCommit.getValue());
        });
        commit.addClickListener(clickEvent -> name.setValue(input.getValue()));

        VerticalLayout mainLayout = new VerticalLayout(input, output, autoCommit, commit);
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}