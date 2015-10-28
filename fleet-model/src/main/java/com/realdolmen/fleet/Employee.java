package com.realdolmen.fleet;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Employee extends User {

    @Transient
    private PhysicalCar currentCar;
}
