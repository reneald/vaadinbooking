package com.switchfully.vaadin.exercise_07_custom_fields.ui;

import com.vaadin.data.util.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

/**
 * Provides a conversion between old {@link Date} and new {@link LocalDate} API.
 */
public class LocalDateToDateConverter implements Converter<Date, LocalDate> {

    private static final long serialVersionUID = 1L;

    @Override
    public LocalDate convertToModel(Date value, Class<? extends LocalDate> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {

        if (value != null) {
            return value.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate();
        }

        return null;
    }

    @Override
    public Date convertToPresentation(LocalDate value, Class<? extends Date> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {

        if (value != null) {
            return Date.from(value.atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant());
        }

        return null;
    }

    @Override
    public Class<LocalDate> getModelType() {
        return LocalDate.class;
    }

    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}