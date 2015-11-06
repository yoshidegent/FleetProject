package com.realdolmen.fleet;

public interface OrderService {
    void saveOrder(CarOrder order);
    boolean employeeCanOrder(Employee employee);
}
