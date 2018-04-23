package com.switchfully.vaadin.exercise_05_binding_beans.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.Binder;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {
    private AccomodationAdmin admin;
    private AccomodationService accomodationService;
    private CityService cityService;
    private Accomodation accomodation;
    private TextField name;
    private NativeSelect city;
    private TextField numberOfRooms;
    private NativeSelect starRating;
//    private DateField dateCreated;
    private Button save;
    private Button delete;
    private Button cancel;

    @Autowired
    public EditAccomodationForm(AccomodationAdmin admin, AccomodationService accomodationService, CityService cityService) {
        this.admin = admin;
        this.accomodationService = accomodationService;
        this.cityService = cityService;

        name = new TextField("Name");
        city = new NativeSelect("City");
        numberOfRooms = new TextField("Number of rooms");
        starRating = new NativeSelect("Rating");
//        dateCreated = new DateField();

        city.setContainerDataSource(new BeanItemContainer<>(City.class, cityService.getCities()));
        city.setItemCaptionPropertyId("name");

        starRating.addItems((Object[]) StarRating.values());

        this.addComponents(name, city, numberOfRooms, starRating, /*dateCreated,*/ createButtons());
    }

    private HorizontalLayout createButtons() {
        save = new Button("Save");
        delete = new Button("Delete");
        cancel = new Button("Cancel");

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        delete.setStyleName(ValoTheme.BUTTON_DANGER);

        save.addClickListener(event -> save());
        cancel.addClickListener(event -> cancel());
        delete.addClickListener(event -> delete());

        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        buttons.setSpacing(true);
        return buttons;
    }

    private void save() {
        accomodationService.save(accomodation);
        admin.populateGrid(accomodationService.getAccomodations());
        setVisible(false);
    }

    private void delete() {
        accomodationService.delete(accomodation.getId());
        admin.populateGrid(accomodationService.getAccomodations());
        setVisible(false);
    }

    private void cancel() {
        setVisible(false);
    }

    public void setAccomodation(Accomodation accomodationToSet) {
        accomodation = cloneAccomodation(accomodationToSet).build();
        BeanFieldGroup.bindFieldsUnbuffered(accomodation, this);

    }
}
