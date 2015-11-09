package com.realdolmen.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class EmployeeTest {

    private Employee employee;


    @Before
    public void before()
    {
        employee = new Employee();
    }

    @Test public void testCalculateSeniority()
    {
        Assert.assertNull(employee.calculateSeniority());

        employee.setHireDate(LocalDate.of(2015, 9, 1));
        Period seniority = Period.between(employee.getHireDate(), LocalDate.now());
        Assert.assertEquals(seniority, employee.calculateSeniority());

        employee.setHireDate(LocalDate.now());
        seniority = Period.between(employee.getHireDate(), LocalDate.now());
        Assert.assertEquals(seniority, employee.calculateSeniority());
    }


    @Test public void testAgeInit()
    {
        //Check if no dateOfBirth was specified
        Assert.assertNull(employee.calculateAge());

        //Valid birth date
        employee.setDateOfBirth(LocalDate.of(1993, 10, 19));
        Integer age =  Math.abs(
            (int) (long) ChronoUnit.YEARS.between(LocalDate.now(), employee.getDateOfBirth()));
        Assert.assertEquals(age, employee.calculateAge());

        //New born
        employee.setDateOfBirth(LocalDate.now());
        age = 0;
        Assert.assertEquals(age, employee.calculateAge());
    }
}
