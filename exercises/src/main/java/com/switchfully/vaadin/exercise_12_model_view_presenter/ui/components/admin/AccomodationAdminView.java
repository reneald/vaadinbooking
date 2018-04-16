package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components.admin;

import com.switchfully.vaadin.domain.Accomodation;
import com.switchfully.vaadin.domain.City;

import java.util.List;

public interface AccomodationAdminView {

    void setSearchResults(List<Accomodation> accomodations);
    void setActiveAccomodation(Accomodation accomodation);
    void setSearchFilter(String searchFilter);
    void setCities(List<City> cities);

    void addListener(AccomodationAdminViewListener listener);


    interface AccomodationAdminViewListener {

        void searchFilterChanged(String searchFilter);
        void clearSearchFilterClicked();

        void accomodationSelected(Accomodation accomodation);

        void addNewAccomodationClicked();

        void acccomodationSaved(Accomodation accomodation);
        void accomodationDeleted(Accomodation accomodation);
        void accomodationFormCanceled();

    }

}
