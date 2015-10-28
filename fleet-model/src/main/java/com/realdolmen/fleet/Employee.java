package com.realdolmen.fleet;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Employee extends AbstractEntity{

    @Email
    private String email;
    private String password;

    @Transient
    private PhysicalCar currentCar;
}
