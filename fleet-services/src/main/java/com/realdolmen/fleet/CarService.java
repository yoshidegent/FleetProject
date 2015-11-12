package com.realdolmen.fleet;

import java.util.List;

public interface CarService {
    /**
     * Physical cars
     */
    void saveCar(PhysicalCar car);

    List<PhysicalCar> findAllCars();
    PhysicalCar findCar(Long id);
    PhysicalCar findCarByLicensePlate(String licensePlate);
    List<PhysicalCar> findCarsThatExceedMaxKm();

    Boolean sendRenewalEmail(PhysicalCar physicalCar);

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
}
