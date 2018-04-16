package com.switchfully.vaadin.exercise_12_model_view_presenter.ui.components;

import com.switchfully.vaadin.domain.Accomodation;

public interface EditAccomodationFormListener {

    void saveAccomodationClicked(Accomodation accomodation);
    void deleteAccomodationClicked(Accomodation accomodation);
    void cancelClicked();

}
