package com.realdolmen.fleet;

import java.util.List;

public interface CarService {
    /**
     * Physical cars
     */
    void saveCar(PhysicalCar car);

    List<PhysicalCar> findAllCars();
    PhysicalCar findCar(Long id);

    void addOptionsToCar(PhysicalCar car, List<Long> optionIds);
    void addDefaultOptionsToCar(PhysicalCar car);

    void editOptionsById(PhysicalCar car, List<Long> optionIds);

    /**
     * Car models
     */
    void saveCarModels(List<CarModel> carModels);
    void saveCarModel(CarModel carModel);

    List<CarModel> findAllCarModels();
    List<CarModel> findCarModelsByCategory(int category);
    CarModel findCarModel(Long id);
    void deleteAllCarModels();

    void deleteCarModel(Long id);
    void deleteCarModels(Long[] ids);

    List<CarOption> getAvailableOptionsForModel(CarModel carModel);
    List<CarOption> getDefaultOptionsForModel(CarModel carModel);
}
