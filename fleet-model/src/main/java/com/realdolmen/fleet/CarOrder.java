package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.DateConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CarOrder extends AbstractEntity {
    private PhysicalCar orderedCar;
    private Employee employee;

    @Convert(converter = DateConverter.class)
    private LocalDate orderDate;

    @Transient
    private LocalDate deliveryDate;

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
}
