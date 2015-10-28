package com.realdolmen.fleet.interfaces;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;

public interface EmployeeService {
    PhysicalCar findEmployeesCurrentCar(Employee employee);
}
