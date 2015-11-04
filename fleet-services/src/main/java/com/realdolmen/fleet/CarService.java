package com.realdolmen.fleet;

import java.util.List;

public interface CarService {
    void saveCarModels(List<CarModel> carModels);
    void saveCarModel(CarModel carModel);

    List<CarModel> findAllCarModels();
    List<CarModel> findCarModelsByCategory(int category);
    CarModel findCarModel(Long id);
    void deleteAllCarModels();

    void deleteCarModel(Long id);
    void deleteCarModels(Long[] ids);

    void saveOption(CarOption carOption);

    List<CarOption> findOptionsByIds(List<Long> ids);
    CarOption findOptionById(Long id);

    CarOption findCarOptionByNameIgnoreCase(String s);
}
