package com.switchfully.vaadin.exercise_02_grids.ui;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.service.AccomodationService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class ExerciseUI extends UI {

    private AccomodationService accomodationService;

    @Autowired
    public ExerciseUI(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.setMargin(true);
        setContent(mainLayout);
        BeanItemContainer<Accomodation> accomodationBeanItemContainer = new BeanItemContainer<>(Accomodation.class, accomodationService.getAccomodations());

        /*
        The following is a really complicated way to show the city name:
        */
//        GeneratedPropertyContainer gpaccomodations = new GeneratedPropertyContainer(accomodationBeanItemContainer);
//        gpaccomodations.addGeneratedProperty("city",
//                new PropertyValueGenerator<String>() {
//                    @Override
//                    public String getValue(Item item, Object o, Object o1) {
//                        City city = (City) item.getItemProperty("city").getValue();
//                        return city.getName();
//                    }
//
//                    @Override
//                    public Class<String> getType() {
//                        return String.class;
//                    }
//                });

        /*
        And now the easier way to do it:
        */

        accomodationBeanItemContainer.addNestedContainerProperty("city.name");

        Grid accomodations = new Grid("Accomodations", accomodationBeanItemContainer);
        accomodations.setColumns("name", "starRating", "city.name");
        accomodations.getColumn("city.name").setHeaderCaption("City");
        accomodations.setColumnOrder("name", "starRating", "city.name");

        mainLayout.addComponent(accomodations);
    }

}