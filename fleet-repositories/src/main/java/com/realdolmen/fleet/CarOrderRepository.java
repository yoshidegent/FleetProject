package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarOrderRepository extends SoftDeleteRepository<CarOrder, Long> {
    @Query("SELECT o FROM CarOrder o WHERE o.employee = ?1 ORDER BY o.orderDate DESC")
    List<CarOrder> findOrdersByEmployeeOrderedByOrderDate(Employee employee);

    List<CarOrder> findByEmployee(Employee employee);
}
