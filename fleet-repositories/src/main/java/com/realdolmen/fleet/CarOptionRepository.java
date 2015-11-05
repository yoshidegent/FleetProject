package com.realdolmen.fleet;

public interface CarOptionRepository extends SoftDeleteRepository<CarOption, Long> {
    CarOption findByName(String name);
    CarOption findByNameIgnoreCase(String name);
}
