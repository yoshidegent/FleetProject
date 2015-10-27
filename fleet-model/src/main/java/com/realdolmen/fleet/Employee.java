package com.realdolmen.fleet;

import javax.persistence.Transient;

public class Employee extends AbstractEntity{

    @Transient
    private PhysicalCar currentCar;
}
