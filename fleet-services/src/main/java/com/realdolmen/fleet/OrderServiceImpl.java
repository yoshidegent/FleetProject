package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired private CarOrderRepository carOrderRepository;

    @Override
    public void saveOrder(CarOrder order) {
        order.setOrderDate(LocalDateTime.now());
        carOrderRepository.save(order);
    }

    @Override
    public boolean employeeCanOrder(Employee employee) {
        return carOrderRepository.findByEmployee(employee)
                .stream()
                .filter(o -> o.getStatus() == CarOrder.OrderStatus.PENDING)
                .count() == 0;
    }
}
