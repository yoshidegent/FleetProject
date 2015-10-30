package com.realdolmen.fleet.interfaces;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;

import java.time.Period;

public interface EmployeeService {
//    List<Employee> findAll();
    PhysicalCar findCurrentCarForEmployee(Employee employee);
    Integer calculateAgeOfEmployee(Employee employee);
    Period calculateSeniority(Employee employee);
}
