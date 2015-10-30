package com.realdolmen.fleet;

import java.util.List;

public interface CarService {
    void saveCarModels(List<CarModel> carModels);
    void saveCarModel(CarModel carModel);

    List<CarModel> findAllCarModels();
    CarModel findCarModel(Long id);
    void deleteAllCarModels();

    void deleteCarModel(Long id);
}
