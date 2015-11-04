package com.realdolmen.fleet;

import javax.persistence.*;

@Entity
public class CarOption extends AbstractEntity {
    private String name;
    private boolean isDefault;

    public CarOption(String name, boolean isDefault) {
        this.name = name;
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
