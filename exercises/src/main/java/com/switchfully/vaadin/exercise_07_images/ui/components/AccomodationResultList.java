package com.switchfully.vaadin.exercise_07_images.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class AccomodationResultList extends CustomComponent {

    private List<Accomodation> accomodations = new ArrayList<>();
    private final VerticalLayout list;

    public AccomodationResultList() {
        list = new VerticalLayout();

        setCompositionRoot(list);
    }

    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
        refreshList();
    }

    private void refreshList() {
        this.list.removeAllComponents();
        this.accomodations
                .stream()
                .map(AccomodationResult::new)
                .forEach(component -> {
                    this.list.addComponent(component);
                });
    }

}
