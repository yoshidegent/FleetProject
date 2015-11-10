package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.DateConverter;
import org.hibernate.annotations.Where;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Where(clause = "deleted = 0")
public class Employee extends User {

    private boolean active = true;

    @OneToOne
    private PhysicalCar currentCar;

    @Max(7)
    @Min(2)
    private int functionalLevel; //according to this field the available categories of companyCars will be determined

    @NotNull
    @Size(min = 1, max = 255)
    private String firstName;

    @Size(min = 1, max = 255)
    private String lastName;

    public Employee() {
        this.setFunctionalLevel(2);
    }

    @NotNull
    @Convert(converter = DateConverter.class)
    private LocalDate dateOfBirth;

    @NotNull
    @Convert(converter = DateConverter.class)
    private LocalDate hireDate;

    @NotNull
    @Size(min = 1, max = 255)
    private String function;

    public PhysicalCar getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(PhysicalCar currentCar) {
        this.currentCar = currentCar;

        if(currentCar != null)
            this.currentCar.setEmployee(this);
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getAge() {
        return this.calculateAge();
    }

    public Period getSeniority() {
        return this.calculateSeniority();
    }

    public Integer calculateAge() {
        LocalDate dateOfBirth = this.getDateOfBirth();
        LocalDate now = LocalDate.now();

        if(dateOfBirth == null)
            return null;

        Long age = ChronoUnit.YEARS.between(dateOfBirth, now);
        return Math.abs((int) (long) age);
    }

    public Period calculateSeniority() {

        LocalDate hireDate = this.getHireDate();
        if(hireDate == null)
            return null;

        LocalDate now = LocalDate.now();
        return Period.between(hireDate, now);
    }
}
