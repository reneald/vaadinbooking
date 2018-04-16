package com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.DateRange;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;

public class CustomFieldGroupFieldFactory extends DefaultFieldGroupFieldFactory {

    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
        if (DateRange.class.isAssignableFrom(type)
                && (anyField(fieldType) || DateField.class.isAssignableFrom(fieldType))) {
            return (T) new DateRangeField();
        }

        return super.createField(type, fieldType);
    }

}
