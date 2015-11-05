package com.realdolmen.fleet;

import java.util.List;

public interface CarOptionService {
    List<CarOption> findOptionsByIds(List<Long> ids);
    CarOption findOptionById(Long id);

    CarOption findCarOptionByNameIgnoreCase(String s);

    List<CarOption> findGlobalCarOptions();

    List<CarOption> findGlobalCarOptionsExcludeActiveOnes(CarModel carModel);

    void addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel);

    void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption);
    void makeAvailableOptionDefault(CarModel carModel, CarOption carOption);

    void makeDefaultOptionsAvailable(CarModel carModel, List<CarOption> carOptions);
    void makeAvailableOptionsDefault(CarModel carModel, List<CarOption> carOptions);

    CarOptionRepository getCarOptionRepository();
    void setCarOptionRepository(CarOptionRepository carOptionRepository);

    List<CarOption> getDefaultOptionsForCarModel(CarModel carModel);
    List<CarOption> getAvailableOptionsForCarModel(CarModel carModel);
}
