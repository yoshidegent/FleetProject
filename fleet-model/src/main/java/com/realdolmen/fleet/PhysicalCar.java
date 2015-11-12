package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "deleted = 0")
public class PhysicalCar extends AbstractEntity {
    public enum RenewalStatus {
        NO_RENEWAL,
        NEEDS_RENEWAL,
        NEEDS_RENEWAL_MAIL_SENT
    }

    @ManyToOne
    private CarModel carModel;

    @ManyToMany
    private List<CarOption> selectedCarOptions = new ArrayList<>();

    @OneToOne(mappedBy = "currentCar")
    private Employee employee;

    @NotNull
    private Long mileage = 0L;

    @Column(unique = true)
    @Size(min = 9, max = 9)
    @Pattern(regexp = "^1-[a-zA-Z]{3}-\\d{3}$")
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private RenewalStatus renewalStatus = RenewalStatus.NO_RENEWAL;

    public PhysicalCar() {}

    public PhysicalCar(CarModel carModel) {
        this.carModel = carModel;
    }

    public void addSelectedOption(CarOption carOption) {
        selectedCarOptions.add(carOption);
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<CarOption> getSelectedCarOptions() {
        return selectedCarOptions;
    }

    public void setSelectedCarOptions(List<CarOption> selectedCarOptions) {
        this.selectedCarOptions = selectedCarOptions;
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

    public RenewalStatus getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(RenewalStatus renewalStatus) {
        this.renewalStatus = renewalStatus;
    }
}
