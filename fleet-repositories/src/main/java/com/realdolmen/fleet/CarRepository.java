package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<PhysicalCar, Long> {}
