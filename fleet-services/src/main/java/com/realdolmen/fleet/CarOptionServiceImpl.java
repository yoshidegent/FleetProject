package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarOptionServiceImpl implements CarOptionService {

    @Autowired
    private CarOptionRepository carOptionRepository;

    @Override public List<CarOption> findGlobalCarOptions() {
        return carOptionRepository.findAll();
    }

    @Override public CarOption findCarOptionByNameIgnoreCase(String s) {
        return carOptionRepository.findByNameIgnoreCase(s);
    }

    @Override
    public List<CarOption> findOptionsByIds(List<Long> ids) {
        return carOptionRepository.findAll(ids);
    }

    @Override
    public CarOption findOptionById(Long id) {
        return carOptionRepository.findOne(id);
    }

    @Override public List<CarOption> findGlobalCarOptionsExcludeActiveOnes(CarModel carModel) {
        List<CarOption> allCarOptions = carOptionRepository.findAll();

        List<CarOption> carOptionsActiveOnesExcluded = new ArrayList<>();

        for(CarOption carOption : allCarOptions)
        {
            if(!carModel.getAvailableOptions().contains(carOption))
            {
                if(!carModel.getDefaultOptions().contains(carOption))
                {
                    carOptionsActiveOnesExcluded.add(carOption);
                }
            }
        }

        return carOptionsActiveOnesExcluded;
    }

    @Override
    public void addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel) {
        carOption = carOptionRepository.save(carOption);
        carModel.addAvailableOption(carOption);
    }

    @Override public void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption) {
        if(carModel.getDefaultOptions().contains(carOption))
        {
            carModel.removeDefaultOption(carOption);
            carModel.addAvailableOption(carOption);
        }
    }

    @Override public void makeAvailableOptionDefault(CarModel carModel, CarOption carOption) {
        if(carModel.getDefaultOptions().contains(carOption))
        {
            carModel.removeAvailableOption(carOption);
            carModel.addDefaultOption(carOption);
        }

    }
}
