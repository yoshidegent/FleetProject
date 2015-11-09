package com.realdolmen.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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
            new CarOrder(new PhysicalCar(), new Employee(), LocalDateTime.of(2010, 1, 1, 0, 0),
                CarOrder.OrderStatus.DELIVERED),
            new CarOrder(new PhysicalCar(), new Employee(), LocalDateTime.of(2014, 1, 1, 0, 0),
                CarOrder.OrderStatus.DELIVERED),
            new CarOrder(new PhysicalCar(), new Employee(), LocalDateTime.of(2015, 1, 1, 0, 0),
                CarOrder.OrderStatus.DELIVERED)));

        Mockito.when(carOrderRepositoryMock.findOrdersByEmployeeOrderedByOrderDate(employee))
            .thenReturn(dummyCarOrders);
    }

    @Test public void testFindCurrentCarForEmployee() {
        PhysicalCar physicalCar = employeeService.findCurrentCarForEmployee(employee);
        Assert.assertNotNull(physicalCar);
        Mockito.verify(carOrderRepositoryMock,
            Mockito.times(1)).findOrdersByEmployeeOrderedByOrderDate(employee);
    }

    @Test public void testGetLowestAllowedCategory()
    {
        employee.setFunctionalLevel(2);
        Assert.assertEquals(employeeService.getLowestAllowedCategory(employee), 2);

        employee.setFunctionalLevel(3);
        Assert.assertEquals(employeeService.getLowestAllowedCategory(employee), 2);

        employee.setFunctionalLevel(-10);
        Assert.assertEquals(employeeService.getLowestAllowedCategory(employee), 2);

        employee.setFunctionalLevel(4);
        Assert.assertEquals(employeeService.getLowestAllowedCategory(employee), 3);

        employee.setFunctionalLevel(20);
        Assert.assertEquals(employeeService.getLowestAllowedCategory(employee), 6);
    }

    @Test public void testGetHighestAllowedCategory()
    {
        employee.setFunctionalLevel(7);
        Assert.assertEquals(employeeService.getHighestAllowedCategory(employee), 7);

        employee.setFunctionalLevel(3);
        Assert.assertEquals(employeeService.getHighestAllowedCategory(employee), 4);

        employee.setFunctionalLevel(-10);
        Assert.assertEquals(employeeService.getHighestAllowedCategory(employee), 3);

        employee.setFunctionalLevel(4);
        Assert.assertEquals(employeeService.getHighestAllowedCategory(employee), 5);

        employee.setFunctionalLevel(20);
        Assert.assertEquals(employeeService.getHighestAllowedCategory(employee), 7);
    }
}
