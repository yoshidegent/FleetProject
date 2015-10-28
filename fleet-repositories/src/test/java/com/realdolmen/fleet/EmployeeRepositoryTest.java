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
        employee = employeeRepository.save(employee);
        Assert.assertNotNull(employee.getId());
    }
}
