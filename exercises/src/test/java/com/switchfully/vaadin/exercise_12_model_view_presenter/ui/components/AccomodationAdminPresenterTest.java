package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.testing.MockitoExtension;
import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;
import com.switchfully.vaadin.service.AccomodationService;
import com.switchfully.vaadin.service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.switchfully.vaadin.domain.AccomodationTestBuilder.anAccomodation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccomodationAdminPresenterTest {

    @Mock
    private AccomodationService accomodationService;
    @Mock
    private CityService cityService;
    private AccomodationAdminModel model;
    private AccomodationAdminPresenter presenter;
    private AccomodationAdminViewForTest view;

    @Test
    public void allAccomodationsAreShownOnStartup() {
        // Given
        givenAccomodationsWithNames("Hotel alpha", "Hotel beta", "Hotel gamma");

        // When
        model = new AccomodationAdminModel(accomodationService, cityService);
        view = new AccomodationAdminViewForTest();
        presenter = new AccomodationAdminPresenter(model, view);

        // Then
        assertThat(view.accomodations).extracting(Accomodation::getName)
                .containsExactly("Hotel alpha", "Hotel beta", "Hotel gamma");
    }

    @Test
    public void whenSearchFilterChangesThenAccomodationsAreFiltered() {
        // Given
        givenAccomodationsWithNames("Hotel alpha", "Hotel beta", "Hotel gamma");

        model = new AccomodationAdminModel(accomodationService, cityService);
        view = new AccomodationAdminViewForTest();
        presenter = new AccomodationAdminPresenter(model, view);

        // When
        view.listener.searchFilterChanged("beta");

        // Then
        assertThat(view.accomodations).hasSize(1);
        assertThat(view.accomodations).extracting(Accomodation::getName).containsExactly("Hotel beta");
    }

    // And so on ...

    private void givenAccomodationsWithNames(String... names) {
        List<Accomodation> accomodations = Stream.of(names)
                .map(name -> anAccomodation().withName(name).build())
                .collect(Collectors.toList());

        when(accomodationService.getAccomodations()).thenReturn(accomodations);
    }

    static class AccomodationAdminViewForTest implements AccomodationAdminView {

        private List<Accomodation> accomodations;
        private Accomodation accomodation;
        private String searchFilter;
        private List<City> cities;
        private AccomodationAdminViewListener listener;

        @Override
        public void setSearchResults(List<Accomodation> accomodations) {
            this.accomodations = accomodations;
        }

        @Override
        public void setActiveAccomodation(Accomodation accomodation) {
            this.accomodation = accomodation;
        }

        @Override
        public void setSearchFilter(String searchFilter) {
            this.searchFilter = searchFilter;
        }

        @Override
        public void setCities(List<City> cities) {
            this.cities = cities;
        }

        @Override
        public void addListener(AccomodationAdminViewListener listener) {
            this.listener = listener;
        }
    }

}