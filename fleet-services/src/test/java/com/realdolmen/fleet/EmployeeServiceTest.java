package com.realdolmen.fleet;

import com.realdolmen.fleet.interfaces.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest extends AbstractServiceTest {

    private CarOrderRepository carOrderRepositoryMock;

    private EmployeeService employeeService;

    private Employee employee;

    @Before public void before() {
        employeeService = new EmployeeServiceImpl();
        ((EmployeeServiceImpl) employeeService).orderRepository = carOrderRepositoryMock;

        carOrderRepositoryMock = Mockito.mock(CarOrderRepository.class);
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
        Mockito.verify(carOrderRepositoryMock.findOrdersByEmployeeOrderedByOrderDate(employee),
            Mockito.times(1));
    }
}