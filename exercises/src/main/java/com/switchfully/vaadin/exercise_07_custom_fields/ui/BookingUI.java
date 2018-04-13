package com.switchfully.vaadin.exercise_07_custom_fields.ui;

import com.switchfully.vaadin.domain.Booking;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.switchfully.vaadin.domain.Booking.BookingBuilder.booking;

@SpringUI
@Theme("valo")
public class BookingUI extends UI {

    private AccomodationService accomodationService;

    @Autowired
    public BookingUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        Booking booking = booking().build();

        BookingForm bookingForm = new BookingForm();

        VerticalLayout mainLayout = new VerticalLayout(bookingForm);
        setContent(mainLayout);
    }

}