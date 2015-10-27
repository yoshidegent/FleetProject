package com.realdolmen.fleet;

import javax.persistence.Transient;

public class Employee {

    @Transient
    private PhysicalCar currentCar;
}
