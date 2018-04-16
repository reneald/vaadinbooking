package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class AccomodationAdminViewImpl extends CustomComponent implements AccomodationAdminView, EditAccomodationForm.EditAccomodationFormListener {

    private Grid grid = new Grid();

    private TextField filter;
    private Button newAccomodationButton;

    private List<Accomodation> accomodations;
    private List<AccomodationAdminViewListener> listeners =
            new ArrayList<AccomodationAdminViewListener>();
    private final EditAccomodationForm form;

    public AccomodationAdminViewImpl() {
        populateGrid(accomodations);

        CssLayout filtering = createFilterComponent();

        // Add a form to the right of the grid to edit details of an accomodation.

        form = new EditAccomodationForm();
        form.addListener(this);
        form.setVisible(false);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSpacing(true);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);

        grid.addSelectionListener(event -> {
            if (event.getSelected().isEmpty()) {
                listeners.forEach(l -> l.accomodationSelected(null));
            } else {
                listeners.forEach(l -> l.accomodationSelected((Accomodation) event.getSelected().iterator().next()));
            }
        });

        newAccomodationButton = new Button("Add new accomodation");
        newAccomodationButton.addClickListener(e -> listeners.forEach(l -> l.addNewAccomodationClicked()));

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodationButton);
        toolbar.setSpacing(true);


        VerticalLayout mainLayout = new VerticalLayout(toolbar, main);
        mainLayout.setMargin(true);
        setCompositionRoot(mainLayout);
    }

    @Override
    public void addListener(AccomodationAdminViewListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void setSearchResults(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
        populateGrid(accomodations);
    }

    @Override
    public void setActiveAccomodation(Accomodation accomodation) {
        if (accomodation == null) {
            this.form.setVisible(false);
        } else {
            this.form.setVisible(true);
            this.form.setAccomodation(accomodation);
        }
    }

    @Override
    public void setSearchFilter(String searchFilter) {
        this.filter.setValue(searchFilter);
    }

    @Override
    public void setCities(List<City> cities) {
        this.form.setCities(cities);
    }

    private CssLayout createFilterComponent() {
        filter = new TextField();
        filter.setInputPrompt("Filter by name...");
        filter.addTextChangeListener(
                e -> listeners.forEach(l -> l.searchFilterChanged(e.getText())));

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> listeners.forEach(l -> l.clearSearchFilterClicked()));

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filter, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        return filtering;
    }

    private void populateGrid(List<Accomodation> accomodations) {
        BeanItemContainer<Accomodation> container =
                new BeanItemContainer<>(Accomodation.class, accomodations);

        container.addNestedContainerProperty("city.name");

        grid.setColumns("name", "starRating", "city.name");

        grid.getColumn("city.name").setHeaderCaption("City");

        grid.setContainerDataSource(container);
    }

    @Override
    public void saveAccomodationClicked(Accomodation accomodation) {
        listeners.forEach(l -> l.acccomodationSaved(accomodation));
    }

    @Override
    public void deleteAccomodationClicked(Accomodation accomodation) {
        listeners.forEach(l -> l.accomodationDeleted(accomodation));
    }

    @Override
    public void cancelClicked() {
        listeners.forEach(l -> l.accomodationFormCanceled());
    }
}

