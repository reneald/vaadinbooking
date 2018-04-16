package com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.DateRange;
import com.vaadin.data.util.converter.Converter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * Provides a conversion between old {@link Date} and new {@link LocalDate} API.
 */
public class DateRangeToStringConverter implements Converter<String, DateRange> {

    private static final long serialVersionUID = 1L;

    @Override
    public DateRange convertToModel(String value, Class<? extends DateRange> targetType, Locale locale) throws ConversionException {
        return null;
    }

    @Override
    public String convertToPresentation(DateRange value, Class<? extends String> targetType, Locale locale) throws ConversionException {
        return null;
    }

    @Override
    public Class<DateRange> getModelType() {
        return null;
    }

    @Override
    public Class<String> getPresentationType() {
        return null;
    }
}