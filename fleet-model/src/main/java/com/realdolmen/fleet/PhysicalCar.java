package com.realdolmen.fleet;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class PhysicalCar {
    private List<Option> selectedOptions;
}
