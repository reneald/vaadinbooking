package com.switchfully.vaadin.exercise_05_binding_beans.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;
import static java.util.stream.Collectors.toList;

public class AccomodationAdmin extends CustomComponent {

    private Grid grid = new Grid();

    private AccomodationService accomodationService;
    private CityService cityService;
    private TextField filter;

    public AccomodationAdmin(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;

        List<Accomodation> accomodations = accomodationService.getAccomodations();
        populateGrid(accomodations);

        CssLayout filtering = createFilterComponent(accomodations);

        EditAccomodationForm form = new EditAccomodationForm(this, accomodationService, cityService);
        form.setVisible(false);

        Button newAccomodation = new Button("New Accomodation");
        newAccomodation.addClickListener(event -> initiateAccomodationForm(form));

        grid.addSelectionListener(event -> {
            if (event.getSelected().isEmpty()) {
                form.setVisible(false);

            } else {
                Accomodation selectedAccomodation = (Accomodation) event.getSelected().iterator().next();
                form.setAccomodation(selectedAccomodation);
                form.setVisible(true);
            }

        });

        // TODO Exercise 5 (Extra): Add ta DateField for creationDate to the form.

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodation);
        toolbar.setSpacing(true);

        HorizontalLayout accomodationLayout = new HorizontalLayout(grid, form);
        accomodationLayout.setSpacing(true);

        VerticalLayout mainLayout = new VerticalLayout(toolbar, accomodationLayout);
        mainLayout.setMargin(true);
        setCompositionRoot(mainLayout);
    }

    private void initiateAccomodationForm(EditAccomodationForm form) {
        form.setAccomodation(accomodation().build());
        form.setVisible(true);
    }

    private CssLayout createFilterComponent(List<Accomodation> accomodations) {
        filter = new TextField();
        filter.setInputPrompt("Filter by name...");
        filter.addTextChangeListener(e -> populateGrid(filterByName(accomodations, e.getText())));

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filter.clear();
            populateGrid(accomodations);
        });


        CssLayout filtering = new CssLayout();
        filtering.addComponents(filter, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        return filtering;
    }

    private List<Accomodation> filterByName(List<Accomodation> accomodations, String filter) {
        return accomodations.stream()
                .filter(accomodation -> accomodation.getName().toLowerCase().contains(filter.toLowerCase()))
                .collect(toList());
    }

    public void populateGrid(List<Accomodation> accomodations) {
        BeanItemContainer<Accomodation> container =
                new BeanItemContainer<>(Accomodation.class, accomodations);

        container.addNestedContainerProperty("city.name");

        grid.setColumns("name", "starRating", "city.name");

        grid.getColumn("city.name").setHeaderCaption("City");

        grid.setContainerDataSource(container);
    }

}
