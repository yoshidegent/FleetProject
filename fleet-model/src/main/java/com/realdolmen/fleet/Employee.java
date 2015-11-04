package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.DateConverter;
import org.hibernate.validator.constraints.Email;

import javax.annotation.PostConstruct;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Employee extends User {

    @Transient
    private PhysicalCar currentCar;

    @Max(7)
    @Min(2)
    private int functionalLevel; //according to this field the available categories of companyCars will be determined

    private String firstName;
    private String lastName;

    public Employee() {
        this.setFunctionalLevel(2);
    }

    @Convert(converter = DateConverter.class)
    private LocalDate dateOfBirth;

    @Convert(converter = DateConverter.class)
    private LocalDate hireDate;

    private String function;

    public PhysicalCar getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(PhysicalCar currentCar) {
        this.currentCar = currentCar;
    }

    public int getFunctionalLevel() {
        return functionalLevel;
    }

    public void setFunctionalLevel(int functionalLevel) {

        this.functionalLevel = functionalLevel;

        if(functionalLevel < 2)
            this.functionalLevel = 2;

        if(functionalLevel > 7)
            this.functionalLevel = 7;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
