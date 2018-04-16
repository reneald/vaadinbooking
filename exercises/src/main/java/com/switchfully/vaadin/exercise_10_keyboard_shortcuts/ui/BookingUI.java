package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class BookingUI extends UI {

    @Autowired
    public BookingUI() {
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout mainLayout = new VerticalLayout(new ExampleForm1(), new ExampleForm2());
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}