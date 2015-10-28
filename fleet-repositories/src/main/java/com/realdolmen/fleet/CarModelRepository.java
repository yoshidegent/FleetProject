package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    @Query("SELECT DISTINCT cm.brand FROM CarModel cm")
    String findAllBrands();
}
