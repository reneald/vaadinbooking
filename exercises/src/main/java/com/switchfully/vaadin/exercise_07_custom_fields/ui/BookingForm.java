package com.switchfully.vaadin.exercise_07_custom_fields.ui;

import com.switchfully.vaadin.domain.Booking;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;

import java.util.function.Consumer;

import static com.switchfully.vaadin.domain.Booking.BookingBuilder.booking;

public class BookingForm extends CustomComponent {

    private Booking booking = booking().build();
    private Consumer<Booking> saveClickListener;

    public BookingForm() {
        BeanFieldGroup<Booking> binder = new BeanFieldGroup<>(Booking.class);
        binder.setItemDataSource(booking);
        binder.setFieldFactory(new CustomFieldGroupFieldFactory());

        TextField firstNameField = (TextField) binder.buildAndBind(
                "First Name", "guestFirstName");
        firstNameField.setNullRepresentation("");

        TextField surnameField = (TextField) binder.buildAndBind(
                "Surname", "guestSurName");
        surnameField.setNullRepresentation("");

        Field<?> numberOfGuestsField = binder.buildAndBind(
                "# of guests", "numberOfGuests");
        Field<?> numberOfRoomsField = binder.buildAndBind(
                "# of rooms", "numberOfRooms");
        Field<?> periodField = binder.buildAndBind(
                "Period", "period");

        FormLayout form = new FormLayout();

        form.addComponents(
                firstNameField,
                surnameField,
                numberOfGuestsField,
                numberOfRoomsField,
                periodField);

        Button save = new Button("Save");
        save.addClickListener(e -> {
            try {
                binder.commit();
                if (saveClickListener != null) saveClickListener.accept(this.booking);
            } catch (FieldGroup.CommitException e1) {
                e1.printStackTrace();
            }
        });

        HorizontalLayout buttons = new HorizontalLayout(save);
        buttons.setSpacing(true);

        VerticalLayout mainLayout = new VerticalLayout(form, buttons);
        mainLayout.setMargin(true);

        setCompositionRoot(mainLayout);
    }

    public void addSaveClickListener(Consumer<Booking> saveClickListener) {
        this.saveClickListener = saveClickListener;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
