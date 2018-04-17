package com.switchfully.vaadin.exercise_08_navigation.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AccomodationResultList extends CustomComponent {

    private List<Accomodation> accomodations = new ArrayList<>();
    private final VerticalLayout list;
    private List<Consumer<Accomodation>> itemClickListeners = new ArrayList<>();

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
                    component.addClickListener(event ->
                            AccomodationResultList.this.itemClickListeners
                                    .forEach(icl -> icl.accept(component.getAccomodation())));
                    this.list.addComponent(component);
                });
    }

    public void addItemClickListener(Consumer<Accomodation> itemClickListener) {
        this.itemClickListeners.add(itemClickListener);
    }
}
