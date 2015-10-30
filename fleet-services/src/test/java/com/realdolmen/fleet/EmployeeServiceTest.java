package com.realdolmen.fleet;

import com.realdolmen.fleet.interfaces.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest extends AbstractServiceTest {

    @Autowired
    private CarOrderRepository carOrderRepositoryMock;

    private EmployeeService employeeService;

    private Employee employee;

    @Before public void before() {
        employeeService = new EmployeeServiceImpl();
        ((EmployeeServiceImpl) employeeService).orderRepository = carOrderRepositoryMock;

        employee = new Employee();

        List<CarOrder> dummyCarOrders = new ArrayList<CarOrder>(Arrays.asList(
            new CarOrder(new PhysicalCar(), new Employee(), LocalDate.of(2010, 1, 1),
                CarOrder.OrderStatus.DELIVERED),
            new CarOrder(new PhysicalCar(), new Employee(), LocalDate.of(2014, 1, 1),
                CarOrder.OrderStatus.DELIVERED),
            new CarOrder(new PhysicalCar(), new Employee(), LocalDate.of(2015, 1, 1),
                CarOrder.OrderStatus.DELIVERED)));

        Mockito.when(carOrderRepositoryMock.findOrdersByEmployeeOrderedByOrderDate(employee))
            .thenReturn(dummyCarOrders);
    }

    @Test public void testFindCurrentCarForEmployee() {
        PhysicalCar physicalCar = employeeService.findCurrentCarForEmployee(employee);
        Assert.assertNotNull(physicalCar);
        Mockito.verify(carOrderRepositoryMock, Mockito.times(1)).findOrdersByEmployeeOrderedByOrderDate(
            employee);
    }

    @Test public void testCalculateAgeForEmployee()
    {
        //Check if no dateOfBirth was specified
        Assert.assertNull(employeeService.calculateAgeOfEmployee(employee));

        //Valid birth date
        employee.setDateOfBirth(LocalDate.of(1993, 10, 19));
        Integer age =  Math.abs((int) (long) ChronoUnit.YEARS.between(LocalDate.now(), employee.getDateOfBirth()));
        Assert.assertEquals(age, employeeService.calculateAgeOfEmployee(employee));

        //New born
        employee.setDateOfBirth(LocalDate.now());
        age = 0;
        Assert.assertEquals(age, employeeService.calculateAgeOfEmployee(employee));
    }

    @Test public void testCalculateSeniority()
    {
        //TODO: implement this test
        Assert.fail("To be implemented");
    }
}
