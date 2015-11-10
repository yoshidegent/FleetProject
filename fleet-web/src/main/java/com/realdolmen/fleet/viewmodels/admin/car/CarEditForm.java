package com.realdolmen.fleet.viewmodels.admin.car;

import com.realdolmen.fleet.AbstractEntity;
import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;

import java.util.List;
import java.util.stream.Collectors;

public class CarEditForm {
    private Long id;
    private Long version;
    private CarModel carModel;
    private Employee employee;
    private Long mileage;
    private String licensePlate;
    private List<Long> options;

    public void mapFrom(PhysicalCar car) {
        this.id = car.getId();
        this.version = car.getVersion();
        this.carModel = car.getCarModel();
        this.employee = car.getEmployee();
        this.mileage = car.getMileage();
        this.licensePlate = car.getLicensePlate();
        this.options = car.getSelectedCarOptions().stream().map(AbstractEntity::getId).collect(Collectors.toList());
    }

    public PhysicalCar physicalCar() {
        PhysicalCar car = new PhysicalCar();
        car.setId(this.id);
        car.setVersion(this.version);
        car.setCarModel(this.carModel);
        car.setEmployee(this.employee);
        car.setMileage(this.mileage);
        car.setLicensePlate(this.licensePlate);

        return car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Long> getOptions() {
        return options;
    }

    public void setOptions(List<Long> options) {
        this.options = options;
    }
}
