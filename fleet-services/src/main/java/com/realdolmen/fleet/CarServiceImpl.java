package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired protected CarModelRepository carModelRepository;
    @Autowired private PhysicalCarRepository physicalCarRepository;
    @Autowired private CarOptionRepository carOptionRepository;

    @Override
    public List<PhysicalCar> findAllCars() {
        return physicalCarRepository.findAll();
    }

    @Override
    public PhysicalCar findCar(Long id) {
        return physicalCarRepository.findOne(id);
    }

    @Override
    public void addOptionsToCar(PhysicalCar car, List<Long> optionIds) {
        if(car == null || optionIds == null)
            return;

        List<CarOption> options = carOptionRepository.findAll(optionIds);
        if(options != null)
            car.getSelectedCarOptions().addAll(options);
    }

    @Override
    public void addDefaultOptionsToCar(PhysicalCar car) {
        if(car == null)
            return;

        List<CarOption> options = this.getDefaultOptionsForModel(car.getCarModel());
        if(options != null)
            car.getSelectedCarOptions().addAll(options);
    }

    @Override
    public void saveCarModels(List<CarModel> carModels) {
        carModelRepository.save(carModels);
    }

    @Override
    public void saveCarModel(CarModel carModel) {
        carModelRepository.save(carModel);
    }

    @Override
    public List<CarModel> findAllCarModels() {
        return carModelRepository.findAll();
    }

    @Override public List<CarModel> findCarModelsByCategory(int category) {
        return carModelRepository.findByCategory(category);
    }

    @Override
    public CarModel findCarModel(Long id) {
        return carModelRepository.findOne(id);
    }

    @Override public void deleteAllCarModels() {
        carModelRepository.deleteAll();
    }

    @Override
    public void deleteCarModel(Long id) {
        carModelRepository.delete(id);
    }

    @Override
    public void deleteCarModels(Long[] ids) {
        for(Long id : ids)
            carModelRepository.delete(id);
    }

    @Override
    public List<CarOption> getAvailableOptionsForModel(CarModel carModel) {
        return carModel.getOptionsDefaultMap().entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarOption> getDefaultOptionsForModel(CarModel carModel) {
        return carModel.getOptionsDefaultMap().entrySet()
                .stream()
                .filter(entry -> !entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
