package com.realdolmen.fleet;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarServiceTest extends AbstractServiceTest {

    private CarService carService;


    @Autowired private PhysicalCarRepository physicalCarRepository;
    @Autowired private CarModelRepository carModelRepository;

    List<PhysicalCar> dummyPhysicalCars = new ArrayList<>();
    List<PhysicalCar> dummyCarModels = new ArrayList<>();

    /*
    void saveCar(PhysicalCar car);

    List<PhysicalCar> findAllCars();
    PhysicalCar findCar(Long id);
    PhysicalCar findCarByLicensePlate(String licensePlate);

    void saveCarModels(List<CarModel> carModels);
    void saveCarModel(CarModel carModel);

    List<CarModel> findAllCarModels();
    List<CarModel> findCarModelsByCategory(int category);
    CarModel findCarModel(Long id);

    void deleteAllCarModels();
    void deleteCarModel(Long id);
    void deleteCarModels(Long[] ids);
    */

    @Before
    public void before(){
        carService = new CarServiceImpl();
        carService.setCarModelRepository(carModelRepository);
        carService.setPhysicalCarRepository(physicalCarRepository);
    }

    @Test
    public void testFindCarByLicensePlate()
    {
        //valid licensePlate
        String licencePlate = "1-LCF-840";
        Assert.fail("To be implemented");
    }

    //TODO: methods to be tested
}
