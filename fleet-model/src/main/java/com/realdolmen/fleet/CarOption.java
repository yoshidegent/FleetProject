package com.realdolmen.fleet;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class CarOption extends AbstractEntity {
    private String name;

    public CarOption() {}

    public CarOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOption carOption = (CarOption) o;
        return Objects.equals(id, carOption.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
