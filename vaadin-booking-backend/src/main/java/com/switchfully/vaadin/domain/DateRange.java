package com.switchfully.vaadin.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateRange implements Cloneable {

    private LocalDate startDate;
    private LocalDate endDate;

    public DateRange() {
    }

    public DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public DateRange clone() {
        return new DateRange(startDate, endDate);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");

        return String.format("%s to %s", startDate.format(formatter), endDate.format(formatter));
    }
}
