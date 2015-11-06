package com.realdolmen.fleet;

import java.time.Period;

public interface EmployeeService {
//    List<Employee> findAll();
    Employee findEmployeeByCar(PhysicalCar car);
    PhysicalCar findCurrentCarForEmployee(Employee employee);
    Integer calculateAgeOfEmployee(Employee employee);
    Period calculateSeniority(Employee employee);

    int getHighestAllowedCategory(Employee employee);
    int getLowestAllowedCategory(Employee employee);
}
