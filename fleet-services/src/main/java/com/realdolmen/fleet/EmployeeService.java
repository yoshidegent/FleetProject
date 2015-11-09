package com.realdolmen.fleet;

import java.time.Period;
import java.util.List;

public interface EmployeeService {
//    List<Employee> findAll();
    Employee findEmployeeByCar(PhysicalCar car);
    PhysicalCar findCurrentCarForEmployee(Employee employee);

    int getHighestAllowedCategory(Employee employee);
    int getLowestAllowedCategory(Employee employee);

    List<Employee> findAllEmployees();

    Employee findEmployee(Long employeeId);

    Employee saveOrUpdateEmployee(Employee employee);
}
