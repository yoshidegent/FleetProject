package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Where(clause = "deleted = 0")
public class CarOption extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
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


    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CarOption carOption = (CarOption) o;

        return name.equals(carOption.name);

    }

    @Override public int hashCode() {
        return name.hashCode();
    }
}
