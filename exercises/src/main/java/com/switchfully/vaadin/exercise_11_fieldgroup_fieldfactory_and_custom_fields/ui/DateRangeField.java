package com.switchfully.vaadin.exercise_11_fieldgroup_fieldfactory_and_custom_fields.ui;

import com.switchfully.vaadin.domain.DateRange;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateRangeField extends CustomField<DateRange> {

    private static final long serialVersionUID = 7462756001701404411L;
    private static final String PRIMARY_STYLE = "date-range-field";

    private Layout layout;
    private DateField startDateField;
    private DateField endDateField;

    private DateRange internalValue;

    public DateRangeField() {
        setPrimaryStyleName(PRIMARY_STYLE);
        setInvalidAllowed(false);

        startDateField = new DateField();
        endDateField = new DateField();

        setBuffered(true);
    }

    public DateRangeField(String caption) {
        this();
        setCaption(caption);
    }

    @Override
    protected Component initContent() {
        layout = new HorizontalLayout();
        layout.addComponent(startDateField);
        layout.addComponent(endDateField);
        return layout;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void setPropertyDataSource(Property newDataSource) {
        super.setPropertyDataSource(newDataSource);

        DateRange dateRange = (DateRange) newDataSource.getValue();
        if (dateRange != null) {
            internalValue = dateRange.clone();
        } else {
            internalValue = new DateRange();
        }
        startDateField.setPropertyDataSource(new MethodProperty<Date>(internalValue,
                "startDate"));
        startDateField.setConverter(new LocalDateToDateConverter());

        endDateField.setPropertyDataSource(new MethodProperty<Date>(internalValue,
                "endDate"));
        endDateField.setConverter(new LocalDateToDateConverter());
    }

    @Override
    public Class<? extends DateRange> getType() {
        return DateRange.class;
    }

    @Override
    public void commit() throws SourceException, Validator.InvalidValueException {
        startDateField.commit();
        endDateField.commit();
        setInternalValue(internalValue.clone());
        super.commit();
    }

    @Override
    public void discard() throws SourceException {
        super.discard();
        DateRange i = getInternalValue();
        if(i != null) {
            startDateField.setValue(toDate(i.getStartDate()));
            endDateField.setValue(toDate(i.getEndDate()));
        } else {
            startDateField.setValue(null);
            endDateField.setValue(null);
        }
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setResolution(Resolution resolution) {
        startDateField.setResolution(resolution);
        endDateField.setResolution(resolution);
    }

    @Override
    public void setImmediate(boolean immediate) {
        super.setImmediate(immediate);
        startDateField.setImmediate(immediate);
        endDateField.setImmediate(immediate);
    }

    @Override
    public void setBuffered(boolean buffered) {
        super.setBuffered(buffered);
        startDateField.setBuffered(buffered);
        endDateField.setBuffered(buffered);
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        startDateField.setReadOnly(readOnly);
        endDateField.setReadOnly(readOnly);
    }

}
