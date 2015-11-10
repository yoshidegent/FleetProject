package com.realdolmen.fleet;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public class EmployeeRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @Before
    public void before()
    {
        employee = new Employee();
    }

    @Test
    public void testEmployeePersists() {
        Assert.assertNull(employee.getId());
        employee = employeeRepository.save(employee);
        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(employee.getVersion());
    }

    @Test
    public void testEmployeeCanBeSoftDeleted() {
        employeeRepository.saveAndFlush(employee);
        employeeRepository.softDelete(employee);
        Assert.assertNull(employeeRepository.findOne(employee.getId()));
    }

    @Test
    public void testAgeInitPostConstruct()
    {
        employee.setDateOfBirth(LocalDate.of(1993,10,19));
        employee = employeeRepository.save(employee);
        Long id = employee.getId();

        employee = employeeRepository.findOne(id);

        Assert.assertEquals(employee.getAge(), employee.calculateAge());

    }
}
