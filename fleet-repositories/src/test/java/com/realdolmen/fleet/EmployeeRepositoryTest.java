package com.realdolmen.fleet;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testEmployeePersists() {
        Employee employee = new Employee();
        Assert.assertNull(employee.getId());
        employee = employeeRepository.save(employee);
        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(employee.getVersion());
    }

    @Test
    public void testEmployeeCanBeSoftDeleted() {
        Employee employee = new Employee();
        employeeRepository.save(employee);
        employeeRepository.softDelete(employee);

        Assert.assertTrue(employee.isDeleted());
    }
}
