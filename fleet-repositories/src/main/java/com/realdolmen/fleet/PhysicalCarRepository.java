package com.realdolmen.fleet;

import java.util.List;

public interface PhysicalCarRepository extends SoftDeleteRepository<PhysicalCar, Long> {
    PhysicalCar findByLicensePlate(String licensePlate);
}
