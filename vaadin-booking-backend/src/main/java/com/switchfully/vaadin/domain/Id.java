package com.switchfully.vaadin.domain;

import java.io.Serializable;
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

}
