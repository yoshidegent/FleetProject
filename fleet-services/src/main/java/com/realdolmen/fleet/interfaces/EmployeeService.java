package com.realdolmen.fleet.interfaces;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    PhysicalCar findEmployeesCurrentCar(Employee employee);
}
