package com.realdolmen.fleet;

import com.realdolmen.fleet.CarModel;

import java.util.List;

public interface CarService {
    void saveCarModels(List<CarModel> carModels);
    List<CarModel> findAllCarModels();
}
