package com.realdolmen.fleet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarOptionServiceTest extends AbstractServiceTest {

    @Autowired
    private CarOptionService carOptionService;

    @Autowired
    private CarOptionRepository carOptionRepositoryMock;

    private CarModel carModel;

    final int NUMBER_OF_DEFAULT_OPTIONS = 4;
    final int NUMBER_OF_AVAILABLE_OPTIONS = 2;

    /**
     * TO BE TESTED:
     * List<CarOption> findGlobalCarOptionsExcludeActiveOnes(CarModel carModel);
     * void addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel);
     * void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption);
     * void makeAvailableOptionDefault(CarModel carModel, CarOption carOption);
     */

    @Before
    public void before()
    {
        List<CarOption> dummyCarOptions = new ArrayList<>();

        for(int i=1; i<= NUMBER_OF_AVAILABLE_OPTIONS + NUMBER_OF_DEFAULT_OPTIONS; i++)
        {
            CarOption carOption = new CarOption("CarOption" + i);
            dummyCarOptions.add(carOption);

            if(i<= NUMBER_OF_AVAILABLE_OPTIONS) {
                carModel.addAvailableOption(carOption);
            }
            else
            {
                carModel.addDefaultOption(carOption);
            }
        }

        Mockito.when(carOptionRepositoryMock.findAll()).thenReturn(dummyCarOptions);


    }

    @Test
    public void testAddGlobalCarOptionAndAddToCarModel()
    {

    }
}
