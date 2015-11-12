package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long>, SoftDeleteRepository<CarModel, Long> {
    @Query("SELECT DISTINCT cm.brand FROM CarModel cm")
    String findAllBrands();

    List<CarModel> findByCategory(int category);
    List<CarModel> findByCategoryOrderByBrandAscModelAsc(int category);
}
