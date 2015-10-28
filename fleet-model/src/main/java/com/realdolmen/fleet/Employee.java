package com.realdolmen.fleet;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Employee extends AbstractEntity{

    @Transient
    private PhysicalCar currentCar;
}
