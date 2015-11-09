package com.realdolmen.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
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
            if(!carModel.getOptionsDefaultMap().containsKey(carOption))
            {
               carOptionsActiveOnesExcluded.add(carOption);
            }
        }

        return carOptionsActiveOnesExcluded;
    }

    @Override public CarOption addGlobalCarOption(CarOption carOption) {
        if(carOption != null && !carOption.getName().isEmpty())
            return carOptionRepository.save(carOption);
        else
            return null;
    }

    @Override
    public CarModel addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel) {
        carOption = carOptionRepository.save(carOption);
        carModel.addOption(carOption, false);
        return carModel;
    }

    @Override public void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption) {
        if(carModel.getOptionsDefaultMap().containsKey(carOption))
        {
            carModel.addOption(carOption, false);
        }
    }

    @Override public void makeAvailableOptionDefault(CarModel carModel, CarOption carOption) {
        if(carModel.getOptionsDefaultMap().containsKey(carOption))
        {
            carModel.addOption(carOption, true);
        }
    }

    @Override
    public void makeDefaultOptionsAvailable(CarModel carModel, List<CarOption> carOptions) {
        for (CarOption carOption : carOptions)
        {
            this.makeDefaultOptionAvailable(carModel, carOption);
        }
    }

    @Override
    public void makeAvailableOptionsDefault(CarModel carModel, List<CarOption> carOptions) {
        for (CarOption carOption : carOptions)
        {
            this.makeAvailableOptionDefault(carModel, carOption);
        }
    }

    @Override public CarOptionRepository getCarOptionRepository() {
        return this.carOptionRepository;
    }

    @Override public void setCarOptionRepository(CarOptionRepository carOptionRepository) {
        this.carOptionRepository = carOptionRepository;
    }

    @Override public List<CarOption> getDefaultOptionsForCarModel(CarModel carModel) {
        List<CarOption> defaultCarOptions = new ArrayList<>();
        for(Map.Entry<CarOption, Boolean> option : carModel.getOptionsDefaultMap().entrySet())
        {
            if(option.getValue())
                defaultCarOptions.add(option.getKey());
        }
        return defaultCarOptions;
    }

    @Override public List<CarOption> getAvailableOptionsForCarModel(CarModel carModel) {
        List<CarOption> defaultCarOptions = new ArrayList<>();
        for(Map.Entry<CarOption, Boolean> option : carModel.getOptionsDefaultMap().entrySet())
        {
            if(!option.getValue())
                defaultCarOptions.add(option.getKey());
        }
        return defaultCarOptions;
    }
}
