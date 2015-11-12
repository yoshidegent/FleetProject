package com.realdolmen.fleet;

import org.springframework.context.annotation.Profile;

import java.util.List;

public interface CarOptionService {

    List<CarOption> findGlobalCarOptions();
    List<CarOption> findGlobalCarOptionsExcludeActiveOnes(CarModel carModel);

    List<CarOption> findCarOptionsByIds(List<Long> ids);
    CarOption findCarOptionById(Long id);

    CarOption findCarOptionByNameIgnoreCase(String s);

    List<CarOption> findDefaultOptionsForCarModel(CarModel carModel);
    List<CarOption> findAvailableOptionsForCarModel(CarModel carModel);

    CarOption addGlobalCarOption(CarOption carOption);
    CarModel addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel);

    void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption);
    void makeAvailableOptionDefault(CarModel carModel, CarOption carOption);
    void makeDefaultOptionsAvailable(CarModel carModel, List<CarOption> carOptions);
    void makeAvailableOptionsDefault(CarModel carModel, List<CarOption> carOptions);

    void addOptionsToCar(PhysicalCar car, List<Long> optionIds);
    void editOptionsById(PhysicalCar car, List<Long> optionIds);
    void addDefaultOptionsToCar(PhysicalCar car);

    @Profile("test")
    void setCarOptionRepository(CarOptionRepository carOptionRepository);
    @Profile("test")
    CarOptionRepository getCarOptionRepository();
}
