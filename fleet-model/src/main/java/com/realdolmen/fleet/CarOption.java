package com.realdolmen.fleet;

import javax.persistence.*;

@Entity
public class CarOption extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
