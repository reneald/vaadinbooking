package com.switchfully.vaadin.exercise_04_field_binding_simple.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import static com.vaadin.ui.AbstractTextField.TextChangeEventMode.EAGER;
import static com.vaadin.ui.AbstractTextField.TextChangeEventMode.LAZY;

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

        // with setImmediate() the Label gets updated when you move the cursor out of the TextField.
        // The solution in the solutions branch changes the Label in real time (with a TextChangeListener).
        autoCommit.addValueChangeListener(valueChangeEvent -> {
            input.setImmediate(autoCommit.getValue());
            commit.setVisible(!autoCommit.getValue());
        });
        commit.addClickListener(clickEvent -> input.commit());

        VerticalLayout mainLayout = new VerticalLayout(input, output, autoCommit, commit);
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}