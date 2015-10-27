package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DWSAX40 on 27/10/2015.
 */
public interface CarRepository extends JpaRepository<PhysicalCar, Long> {}
