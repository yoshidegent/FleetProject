package com.realdolmen.fleet;

import java.util.List;

public interface OrderService {
    CarOrder findOne(Long id);
    List<CarOrder> findAll();
    List<CarOrder> findAllByEmployee(Employee employee);
    List<CarOrder> findLatest10();
    List<CarOrder> find10OldestPendingOrders();
    List<CarOrder> findPendingOrders();

    void saveOrder(CarOrder order);
    boolean employeeCanOrder(Employee employee, CarModel carModel);

    void deliver(Long orderId, String licensePlate);

    Long getPendingOrderAmount();
}
