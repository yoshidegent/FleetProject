package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends SoftDeleteRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.currentCar = ?1")
    Employee findByCar(PhysicalCar car);
}
