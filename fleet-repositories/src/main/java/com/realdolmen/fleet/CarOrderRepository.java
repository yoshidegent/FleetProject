package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    @Query("SELECT o FROM CarOrder o WHERE o.employee = ?1 ORDER BY o.orderDate DESC")
    List<CarOrder> findEmployeesOrdersOrderedByDate(Employee employee);
}