package com.switchfully.vaadin.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Id implements Serializable {

    private String id;

    protected Id() {
        this.id = UUID.randomUUID().toString();
    }

    protected Id(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
