package com.realdolmen.fleet;

import com.realdolmen.fleet.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired private CarModelRepository carModelRepository;
    @Autowired private PhysicalCarRepository physicalCarRepository;
    @Autowired private OptionRepository optionRepository;
}
