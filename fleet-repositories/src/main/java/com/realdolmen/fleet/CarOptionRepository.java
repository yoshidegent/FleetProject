package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarOptionRepository extends JpaRepository<CarOption, Long> {
    CarOption findByName(String name);
    CarOption findByNameIgnoreCase(String name);
}
