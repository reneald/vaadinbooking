package com.switchfully.vaadin.exercise_05_binding_beans.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final BookingUI ui;
    private AccomodationService accomodationService;
    private final CityService cityService;

    private TextField name = new TextField("Name");
    private NativeSelect city = new NativeSelect("City");
    private TextField numberOfRooms = new TextField("Number of rooms");
    private NativeSelect starRating = new NativeSelect("Rating");
    private Button delete = new Button("Delete");
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private Accomodation accomodation;

    public EditAccomodationForm(BookingUI ui, AccomodationService accomodationService, CityService cityService) {
        this.ui = ui;
        this.accomodationService = accomodationService;
        this.cityService = cityService;

        name.setWidth("30em");
        name.setNullRepresentation("");
        starRating.addItems((Object[]) StarRating.values());
        city.setContainerDataSource(new BeanItemContainer<>(City.class, cityService.getCities()));
        city.setItemCaptionPropertyId("name");

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> cancel());

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        buttons.setSpacing(true);
        addComponents(name, city, numberOfRooms, starRating, buttons);
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = cloneAccomodation(accomodation).build();
        BeanFieldGroup.bindFieldsUnbuffered(this.accomodation, this);

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.selectAll();
    }
    private void delete() {
        accomodationService.delete(accomodation.getId());
        ui.updateList();
        setVisible(false);
    }

    private void save() {
        accomodationService.save(accomodation);
        ui.updateList();
        setVisible(false);
    }
}
