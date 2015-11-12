package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhysicalCarRepository extends SoftDeleteRepository<PhysicalCar, Long> {
    PhysicalCar findByLicensePlate(String licensePlate);
    List<PhysicalCar> findByRenewalStatus(PhysicalCar.RenewalStatus renewalStatus);

    @Query("SELECT c FROM PhysicalCar c WHERE c.mileage >= c.carModel.maxKm")
    List<PhysicalCar> findByMileageGreaterThanMaxKm();
}
