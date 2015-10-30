package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired protected CarModelRepository carModelRepository;
    @Autowired private PhysicalCarRepository physicalCarRepository;
    @Autowired private OptionRepository optionRepository;

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
}
