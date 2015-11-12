package com.realdolmen.fleet.viewmodels.admin.car;

import com.realdolmen.fleet.AbstractEntity;
import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarEditForm {
    private Long id;
    private Long version;

    @NotNull
    @Valid
    private CarModel carModel;

    @Valid
    private Employee employee;

    @NotNull
    @Min(0)
    private Long mileage;

    @NotNull
    @Size(min = 9, max = 9)
    private String licensePlate;
    private List<Long> installedOptions = new ArrayList<>();

    public void mapFrom(PhysicalCar car) {
        this.id = car.getId();
        this.version = car.getVersion();
        this.carModel = car.getCarModel();
        this.employee = car.getEmployee();
        this.mileage = car.getMileage();
        this.licensePlate = car.getLicensePlate();
        this.installedOptions = car.getSelectedCarOptions().stream().map(AbstractEntity::getId).collect(Collectors.toList());
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

    public List<Long> getInstalledOptions() {
        return installedOptions;
    }

    public void setInstalledOptions(List<Long> installedOptions) {
        this.installedOptions = installedOptions;
    }
}
