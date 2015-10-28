package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    @Query("SELECT o FROM CarOrder o WHERE o.employee = ?1 ORDER BY o.orderDate DESC")
    List<CarOrder> findOrdersByEmployeeOrderedByOrderDate(Employee employee);
}
