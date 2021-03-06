package com.realdolmen.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class CarOrderRepositoryTest extends AbstractRepositoryTest{

    private Employee employee;

    @Autowired
    private CarOrderRepository carOrderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void before()
    {
        employee = new Employee();
        employeeRepository.save(employee);

        CarOrder carOrder1 = new CarOrder();
        carOrder1.setEmployee(employee);
        carOrder1.setOrderDate(LocalDateTime.now());
        carOrderRepository.save(carOrder1);

        CarOrder carOrder2 = new CarOrder();
        carOrder2.setEmployee(employee);
        carOrder2.setOrderDate(LocalDateTime.of(2003, 10, 1, 0, 0));
        carOrderRepository.save(carOrder2);


        CarOrder carOrder3 = new CarOrder();
        carOrder3.setEmployee(employee);
        carOrder3.setOrderDate(LocalDateTime.of(1999, 10, 19, 0, 0));
        carOrderRepository.save(carOrder3);
    }

    @Test
    public void testFindOrdersByEmployeeOrderedByDate()
    {
        List<CarOrder> carOrdersOrderedByOrderDate = carOrderRepository.findOrdersByEmployeeOrderedByOrderDate(employee);
        for(int i=0; i<carOrdersOrderedByOrderDate.size(); i++)
        {
            if(i>0)
            {
                CarOrder carOrder = carOrdersOrderedByOrderDate.get(i);
                CarOrder previousCarOrder = carOrdersOrderedByOrderDate.get(i - 1);

                Assert.assertNotNull(carOrder.getOrderDate());
                Assert.assertNotNull(previousCarOrder.getOrderDate());
                Assert.assertTrue(previousCarOrder.getOrderDate().isAfter(carOrder.getOrderDate()));
            }
        }
    }
}
