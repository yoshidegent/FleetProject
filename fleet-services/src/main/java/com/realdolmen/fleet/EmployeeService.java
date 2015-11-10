package com.realdolmen.fleet;

import java.time.Period;
import java.util.List;

public interface EmployeeService {
    Employee findOne(Long id);
    Employee findEmployeeByCar(PhysicalCar car);
    PhysicalCar findCurrentCarForEmployee(Employee employee);

    int getHighestAllowedCategory(Employee employee);
    int getLowestAllowedCategory(Employee employee);

    List<Employee> findAllEmployees();

    Employee findEmployee(Long employeeId);

    Employee saveOrUpdateEmployee(Employee employee);
}
