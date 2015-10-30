package com.realdolmen.fleet;

import com.realdolmen.fleet.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    protected CarOrderRepository orderRepository;

//    @Autowired protected EmployeeRepository employeeRepository;
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }

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

    @Override public Integer calculateAgeOfEmployee(Employee employee) {
        LocalDate dateOfBirth = employee.getDateOfBirth();
        LocalDate now = LocalDate.now();

        if(dateOfBirth == null)
            return null;

        Long age = ChronoUnit.YEARS.between(dateOfBirth, now);
        return Math.abs((int) (long) age);
    }

    @Override public Period calculateSeniority(Employee employee) {
        LocalDate dateOfBirth = employee.getHireDate();
        LocalDate now = LocalDate.now();
        return Period.between(dateOfBirth, now);
    }
}
