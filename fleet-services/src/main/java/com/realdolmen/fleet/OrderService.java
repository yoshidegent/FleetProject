package com.realdolmen.fleet;

import java.util.List;

public interface OrderService {
    CarOrder findOne(Long id);
    List<CarOrder> findAll();
    List<CarOrder> findAllByEmployee(Employee employee);

    void saveOrder(CarOrder order);
    boolean employeeCanOrder(Employee employee);

    void deliver(Long orderId, String licensePlate);

    Long getPendingOrderAmount();
}
