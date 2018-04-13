package com.switchfully.vaadin.exercise_02_grids.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class BookingUI extends UI {

    private Grid grid = new Grid();
    private final TextField filter;
    private final Button addNewBtn;

    private AccomodationService accomodationService;

    @Autowired
    public BookingUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
        this.filter = new TextField();
        this.addNewBtn = new Button("New accomodation", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid);

        mainLayout.setStyleName("mainLayout");

        BeanItemContainer<Accomodation> container = new BeanItemContainer<>(Accomodation.class, accomodationService.getAccomodations());
        container.addNestedContainerProperty("city.name");

        grid.setColumns("name", "starRating", "city.name");

        grid.getColumn("city.name").setHeaderCaption("City");

//        grid.setWidth("100%");
        grid.setContainerDataSource(container);

        mainLayout.setMargin(true);
        setContent(mainLayout);

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setInputPrompt("Accomodation name...");
        filter.addValueChangeListener(e -> listCustomers(e.getProperty()));

        // Connect selected Customer to editor or hide if none is selected

        // Instantiate and edit new Customer the new button is clicked
//        addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("", "")));

        // Listen changes made by the editor, refresh data from backend

        // Initialize listing
        listCustomers(null);
    }

    // tag::listCustomers[]
    void listCustomers(Property property) {
    }
    // end::listCustomers[]

}