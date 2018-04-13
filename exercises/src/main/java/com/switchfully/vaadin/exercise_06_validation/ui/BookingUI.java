package com.switchfully.vaadin.exercise_06_validation.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.switchfully.vaadin.domain.Accomodation.AccomodationBuilder.accomodation;
import static java.util.stream.Collectors.toList;

@SpringUI
@Theme("valo")
public class BookingUI extends UI {

    private AccomodationService accomodationService;
    private CityService cityService;

    private Grid grid;
    private TextField filter;
    private EditAccomodationForm form;

    private List<Accomodation> accomodations;

    @Autowired
    public BookingUI(AccomodationService accomodationService, CityService cityService) {
        this.accomodationService = accomodationService;
        this.cityService = cityService;
    }

    @Override
    protected void init(VaadinRequest request) {
        this.accomodations = accomodationService.getAccomodations();
        this.grid = createGrid();
        this.form = new EditAccomodationForm(this, accomodationService, cityService);

        populateGrid(accomodations);

        form.setVisible(false);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSpacing(true);
        main.setSizeFull();
        main.setExpandRatio(grid, 1);

        VerticalLayout mainLayout = new VerticalLayout(createToolbar(), main);
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

    private HorizontalLayout createToolbar() {
        CssLayout filtering = createFilterComponent(accomodations);
        Button newAccomodationButton = createNewAccomodationButton();

        HorizontalLayout toolbar = new HorizontalLayout(filtering, newAccomodationButton);
        toolbar.setSpacing(true);
        return toolbar;
    }

    private Button createNewAccomodationButton() {
        Button button = new Button("Add new accomodation");
        button.addClickListener(e -> form.setAccomodation(accomodation()
                .build()));
        return button;
    }

    private Grid createGrid() {
        Grid grid = new Grid();

        grid.setColumns("name", "starRating", "city.name");
        grid.getColumn("city.name").setHeaderCaption("City");
        grid.setSizeFull();

        grid.addSelectionListener(event -> {
            if (event.getSelected().isEmpty()) {
                form.setVisible(false);
            } else {
                Accomodation accomodation = (Accomodation) event.getSelected().iterator().next();
                form.setAccomodation(accomodation);
            }
        });

        return grid;
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

    private void populateGrid(List<Accomodation> accomodations) {
        BeanItemContainer<Accomodation> container =
                new BeanItemContainer<>(Accomodation.class, accomodations);

        container.addNestedContainerProperty("city.name");

        grid.setContainerDataSource(container);
    }

    public void updateList() {
        filter.clear();
        populateGrid(accomodationService.getAccomodations());
    }

}