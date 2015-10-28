package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.DateConverter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CarOrder extends AbstractEntity {
    public static enum OrderStatus {
        PENDING,
        DELIVERED
    }

    private PhysicalCar orderedCar;

    @ManyToOne
    private Employee employee;

    @Convert(converter = DateConverter.class)
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Transient
    private LocalDate deliveryDate;

    public CarOrder() {
    }

    public CarOrder(PhysicalCar orderedCar, Employee employee, LocalDate orderDate,
        OrderStatus status) {
        this.orderedCar = orderedCar;
        this.employee = employee;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    @PostConstruct
    public void init() {
        deliveryDate = orderDate.plus(orderedCar.getCarModel().getDeliveryTime());
    }

    public PhysicalCar getOrderedCar() {
        return orderedCar;
    }

    public void setOrderedCar(PhysicalCar orderedCar) {
        this.orderedCar = orderedCar;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
