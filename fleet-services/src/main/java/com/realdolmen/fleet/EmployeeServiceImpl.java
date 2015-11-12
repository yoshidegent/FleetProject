package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired protected CarOrderRepository orderRepository;
    @Autowired protected EmployeeRepository employeeRepository;

    @Override
    public Employee findOne(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee findEmployeeByCar(PhysicalCar car) {
        return employeeRepository.findByCar(car);
    }

    @Override
    public PhysicalCar findCurrentCarForEmployee(Employee employee) {
        List<CarOrder> orderList = orderRepository.findOrdersByEmployeeOrderedByOrderDate(employee);

        // Filter on delivered orders. It's ordered by date descending, so the first one is the last.
        Optional<CarOrder> carOrderOptional = orderList.stream().filter(o -> o.getStatus() == CarOrder.OrderStatus.DELIVERED).findFirst();
        // If there is one present, return its car.
        if(carOrderOptional.isPresent()) {
            return carOrderOptional.get().getOrderedCar();
        }

        return null;
    }

    @Override public int getHighestAllowedCategory(Employee employee) {
        if(employee.getFunctionalLevel() >= 7)
            return 7;
        else
            return employee.getFunctionalLevel() + 1;
    }

    @Override public int getLowestAllowedCategory(Employee employee) {
        if(employee.getFunctionalLevel() <= 2)
            return 2;
        else
            return employee.getFunctionalLevel() - 1;
    }

    @Override public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override public Employee findEmployee(Long employeeId){
        return employeeRepository.findOne(employeeId);
    }

    @Override public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
