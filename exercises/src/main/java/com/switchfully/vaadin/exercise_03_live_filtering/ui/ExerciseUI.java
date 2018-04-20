package com.switchfully.vaadin.exercise_03_live_filtering.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class ExerciseUI extends UI {

    private Grid grid = new Grid();

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {

        BeanItemContainer<Accomodation> container =
                new BeanItemContainer<>(Accomodation.class, accomodationService.getAccomodations());

        container.addNestedContainerProperty("city.name");

        grid.setColumns("name", "starRating", "city.name");

        grid.getColumn("city.name").setHeaderCaption("City");

        grid.setContainerDataSource(container);

        TextField filterField = new TextField();
        filterField.setInputPrompt("Filter by name...");
        filterField.addTextChangeListener(change -> {
            container.removeAllContainerFilters();
            if (!change.getText().isEmpty()) {
                container.addContainerFilter(
                        new SimpleStringFilter("name", change.getText(), true, false)
                );
            }
        });

        Button clearFilter = new Button(FontAwesome.TIMES);
        clearFilter.setDescription("Clear the current filter");
        clearFilter.addClickListener(click -> {
            filterField.clear();
            container.removeAllContainerFilters();
        });

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterField, clearFilter);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        VerticalLayout mainLayout = new VerticalLayout(filtering, grid);
        mainLayout.setMargin(true);
        setContent(mainLayout);
    }

}