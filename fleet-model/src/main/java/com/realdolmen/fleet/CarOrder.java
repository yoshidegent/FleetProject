package com.realdolmen.fleet;

import com.realdolmen.fleet.converters.DateConverter;
import com.realdolmen.fleet.converters.DateTimeConverter;
import org.hibernate.annotations.Where;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Where(clause = "deleted = 0")
public class CarOrder extends AbstractEntity {
    public enum OrderStatus {
        PENDING,
        DELIVERED
    }

    public enum UpgradeStatus {
        DOWNGRADE,
        NORMAL,
        UPGRADE
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private UpgradeStatus upgradeStatus = UpgradeStatus.NORMAL;

    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private PhysicalCar orderedCar;

    @ManyToOne
    private Employee employee;

    @NotNull
    @Convert(converter = DateTimeConverter.class)
    private LocalDateTime orderDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Convert(converter = DateConverter.class)
    private LocalDate deliveryDate;

    protected CarOrder() {}

    public CarOrder(CarModel carModel) {
        orderedCar = new PhysicalCar(carModel);
    }

    public CarOrder(PhysicalCar orderedCar, Employee employee, LocalDateTime orderDate,
        OrderStatus status) {
        this.orderedCar = orderedCar;
        this.employee = employee;
        this.orderDate = orderDate;
        this.status = status;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
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

    public UpgradeStatus getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(UpgradeStatus upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }
}
