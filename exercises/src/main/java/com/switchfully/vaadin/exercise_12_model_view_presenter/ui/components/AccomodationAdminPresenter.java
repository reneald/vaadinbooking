package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;

import java.util.List;

public class AccomodationAdminPresenter implements
        AccomodationAdminView.AccomodationAdminViewListener,
        AccomodationAdminModel.AccomodationAdminModelListener {

    private AccomodationAdminModel model;
    private AccomodationAdminView view;

    public AccomodationAdminPresenter(AccomodationAdminModel model, AccomodationAdminView view) {
        this.model = model;
        this.model.addListener(this);

        this.view = view;
        this.view.addListener(this);

        this.view.setCities(model.getCities());
        this.view.setSearchFilter(model.getSearchFilter());
        this.view.setSearchResults(model.getResultList());
        this.view.setActiveAccomodation(model.getActiveAccomodation());
    }

    @Override
    public void searchFilterChanged(String searchFilter) {
        this.model.setSearchFilter(searchFilter);
    }

    @Override
    public void clearSearchFilterClicked() {
        this.model.setSearchFilter("");
    }

    @Override
    public void accomodationSelected(Accomodation accomodation) {
        this.model.setActiveAccomodation(accomodation);
    }

    @Override
    public void addNewAccomodationClicked() {
        this.model.setNewActiveAccomodation();
    }

    @Override
    public void acccomodationSaved(Accomodation accomodation) {
        this.model.saveAccomodation(accomodation);
    }

    @Override
    public void accomodationDeleted(Accomodation accomodation) {
        this.model.deleteAccomodation(accomodation);
    }

    @Override
    public void accomodationFormCanceled() {
        this.model.setActiveAccomodation(null);
    }

    @Override
    public void resultListChanged(List<Accomodation> newResultList) {
        this.view.setSearchResults(model.getResultList());
    }

    @Override
    public void activeAccomodationChanged(Accomodation accomodation) {
        this.view.setActiveAccomodation(accomodation);
    }

}
