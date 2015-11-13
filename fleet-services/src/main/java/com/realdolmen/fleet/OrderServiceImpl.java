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
    @Autowired private EmployeeRepository employeeRepository;

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
    public List<CarOrder> findLatest10() {
        return carOrderRepository.findFirst10ByOrderByOrderDateDesc();
    }

    @Override
    public List<CarOrder> find10OldestPendingOrders() {
        return carOrderRepository.findFirst10ByStatusOrderByOrderDateAsc(CarOrder.OrderStatus.PENDING);
    }

    @Override
    public List<CarOrder> findPendingOrders() {
        return carOrderRepository.findByStatus(CarOrder.OrderStatus.PENDING);
    }

    @Override
    public void saveOrder(CarOrder order) {
        order.setOrderDate(LocalDateTime.now());
        carOrderRepository.save(order);
    }

    @Override
    public boolean employeeCanOrder(Employee employee, CarModel carModel) {
        if(employee == null)
            return false;

        // Apparently the logged in user (this employee) does not get updated in memory, because it stays stored in session.
        // That's why we need to look them up by their id.
        employee = employeeRepository.findOne(employee.getId());

        // First check if the category is possible
        boolean categoryCorrect = false;
        int carModelCategory = carModel.getCategory();
        if(carModelCategory == employee.getFunctionalLevel() ||
                carModelCategory - 1 == employee.getFunctionalLevel() ||
                carModelCategory + 1 == employee.getFunctionalLevel())
            categoryCorrect = true;

        if(!categoryCorrect)
            return false;

        // Then check for existing orders
        boolean hasPendingOrders = carOrderRepository.findByEmployee(employee)
                .stream()
                .filter(o -> o.getStatus() == CarOrder.OrderStatus.PENDING)
                .count() > 0;
        if(hasPendingOrders)
            return false;

        PhysicalCar currentCar = employee.getCurrentCar();
        // If the employee has no car, or if the car needs renewal (his mileage exceeds max. kilometers)
        if(currentCar == null || currentCar.getRenewalStatus() == PhysicalCar.RenewalStatus.NEEDS_RENEWAL ||
                currentCar.getRenewalStatus() == PhysicalCar.RenewalStatus.NEEDS_RENEWAL_MAIL_SENT)
            return true;

        // The employee has a car assigned that needs no renewal, so they can't order
        return false;
    }

    @Override
    public void deliver(Long orderId, String licensePlate) {
        CarOrder carOrder = carOrderRepository.findOne(orderId);
        carOrder.setStatus(CarOrder.OrderStatus.DELIVERED);
        carOrder.setDeliveryDate(LocalDate.now());

        PhysicalCar car = carOrder.getOrderedCar();
        car.setLicensePlate(licensePlate);

        Employee employee = carOrder.getEmployee();
        employee.setCurrentCar(car);
    }

    @Override
    public Long getPendingOrderAmount() {
        return carOrderRepository.countByStatus(CarOrder.OrderStatus.PENDING);
    }
}
