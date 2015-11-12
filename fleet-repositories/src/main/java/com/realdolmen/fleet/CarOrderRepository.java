package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarOrderRepository extends SoftDeleteRepository<CarOrder, Long> {
    @Query("SELECT o FROM CarOrder o WHERE o.employee = ?1 ORDER BY o.orderDate DESC")
    List<CarOrder> findOrdersByEmployeeOrderedByOrderDate(Employee employee);

    List<CarOrder> findFirst10ByOrderByOrderDateDesc();
    List<CarOrder> findByStatus(CarOrder.OrderStatus orderStatus);
    List<CarOrder> findFirst10ByStatus(CarOrder.OrderStatus orderStatus);
    List<CarOrder> findFirst10ByStatusOrderByOrderDateAsc(CarOrder.OrderStatus orderStatus);

    List<CarOrder> findByEmployee(Employee employee);
    Long countByStatus(CarOrder.OrderStatus orderStatus);
}
