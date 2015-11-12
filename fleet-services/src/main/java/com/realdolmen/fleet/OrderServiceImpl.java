package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired private CarOrderRepository carOrderRepository;

    @Override
    public CarOrder findOne(Long id) {
        return carOrderRepository.findOne(id);
    }

    @Override
    public List<CarOrder> findAll() {
        return carOrderRepository.findAll();
    }

    @Override
    public List<CarOrder> findAllByEmployee(Employee employee) {
        return carOrderRepository.findByEmployee(employee);
    }

    @Override
    public void saveOrder(CarOrder order) {
        order.setOrderDate(LocalDateTime.now());
        carOrderRepository.save(order);
    }

    @Override
    public boolean employeeCanOrder(Employee employee) {
        // TODO: add more checks
        return carOrderRepository.findByEmployee(employee)
                .stream()
                .filter(o -> o.getStatus() == CarOrder.OrderStatus.PENDING)
                .count() == 0;
    }

    @Override
    public void deliver(Long orderId, String licensePlate) {
        CarOrder carOrder = carOrderRepository.findOne(orderId);
        carOrder.setStatus(CarOrder.OrderStatus.DELIVERED);
        carOrder.setDeliveryDate(LocalDate.now());

        PhysicalCar car = carOrder.getOrderedCar();
        car.setLicensePlate(licensePlate);
        carOrder.getEmployee().setCurrentCar(car);
    }

    @Override
    public Long getPendingOrderAmount() {
        return carOrderRepository.countByStatus(CarOrder.OrderStatus.PENDING);
    }
}
