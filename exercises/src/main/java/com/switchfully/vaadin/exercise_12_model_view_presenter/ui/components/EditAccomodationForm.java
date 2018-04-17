package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private final AccomodationAdmin admin;
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

    public EditAccomodationForm(AccomodationAdmin admin, AccomodationService accomodationService, CityService cityService) {
        this.admin = admin;
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
        admin.updateList();
        setVisible(false);
    }

    private void save() {
        accomodationService.save(accomodation);
        admin.updateList();
        setVisible(false);
    }
}