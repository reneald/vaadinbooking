package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.domain.StarRating;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.cloneAccomodation;

public class EditAccomodationForm extends FormLayout {

    private TextField name = new TextField("Name");
    private NativeSelect city = new NativeSelect("City");
    private TextField numberOfRooms = new TextField("Number of rooms");
    private NativeSelect starRating = new NativeSelect("Rating");
    private Button delete = new Button("Delete");
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private Accomodation accomodation;

    private List<EditAccomodationFormListener> listeners = new ArrayList<>();

    public EditAccomodationForm() {
        name.setWidth("30em");
        name.setNullRepresentation("");
        starRating.addItems((Object[]) StarRating.values());

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

    public void setCities(List<City> cities) {
        city.setContainerDataSource(new BeanItemContainer<>(City.class, cities));
    }

    public void addListener(EditAccomodationFormListener listener) {
        this.listeners.add(listener);
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = cloneAccomodation(accomodation).build();
        BeanFieldGroup.bindFieldsUnbuffered(this.accomodation, this);

        // Show delete button for only customers already in the database
        delete.setVisible(accomodation.isPersisted());
        setVisible(true);
        name.selectAll();
    }

    private void cancel() {
        listeners.forEach(l -> l.cancelClicked());
    }
    private void delete() {
        listeners.forEach(l -> l.deleteAccomodationClicked(accomodation));
    }

    private void save() {
        listeners.forEach(l -> l.saveAccomodationClicked(accomodation));
    }

    public interface EditAccomodationFormListener {

        void saveAccomodationClicked(Accomodation accomodation);
        void deleteAccomodationClicked(Accomodation accomodation);
        void cancelClicked();

    }
}
