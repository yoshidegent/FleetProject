package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT o FROM CarOrder o WHERE o.employee = ?1 ORDER BY o.orderDate")
    List<CarOrder> findOrdersOrderedOrderByDate(Employee employee);
}
