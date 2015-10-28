package com.realdolmen.fleet;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testEmployeePersists()
    {
        Employee employee = new Employee();
        Assert.assertNull(employee.getId());
        Assert.assertNull(employee.getVersion());
        employee = employeeRepository.save(employee);
        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(employee.getVersion());
    }
}
