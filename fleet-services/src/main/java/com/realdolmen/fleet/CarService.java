package com.realdolmen.fleet;

import org.springframework.context.annotation.Profile;

import java.util.List;

public interface CarService {
    /**
     * Physical cars
     */
    void saveCar(PhysicalCar car);

    List<PhysicalCar> findAllCars();
    PhysicalCar findCar(Long id);
    PhysicalCar findCarByLicensePlate(String licensePlate);

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

    @Profile("test")
    CarModelRepository getCarModelRepository();
    @Profile("test")
    PhysicalCarRepository getPhysicalCarRepository();
    @Profile("test")
    void setCarModelRepository(CarModelRepository carModelRepository);
    @Profile("test")
    void setPhysicalCarRepository(PhysicalCarRepository physicalCarRepository);
}
