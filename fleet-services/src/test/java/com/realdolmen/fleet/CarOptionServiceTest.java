package com.realdolmen.fleet;

import org.junit.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarOptionServiceTest extends AbstractServiceTest {

    private CarOptionService carOptionService;

    @Autowired
    private CarOptionRepository carOptionRepositoryMock;

    private CarModel carModel;

    final int NUMBER_OF_DEFAULT_OPTIONS = 4;
    final int NUMBER_OF_AVAILABLE_OPTIONS = 2;
    final int NUMBER_OF_GLOBAL_OPTIONS = 10;


    private List<CarOption> dummyCarOptions;


    private CarOption testCarOption;

    /**
     * TO BE TESTED:
     * List<CarOption> findGlobalCarOptionsExcludeActiveOnes(CarModel carModel);
     * void addGlobalCarOptionAndAddToCarModel(CarOption carOption, CarModel carModel);
     * void makeDefaultOptionAvailable(CarModel carModel, CarOption carOption);
     * void makeAvailableOptionDefault(CarModel carModel, CarOption carOption);
     * List<CarOption> findDefaultOptionsForCarModel(CarModel carModel);
     * List<CarOption> findAvailableOptionsForCarModel(CarModel carModel);
     */

    @Before
    public void before()
    {
        testCarOption = new CarOption("test option");

        carOptionService = new CarOptionServiceImpl();
        carOptionService.setCarOptionRepository(carOptionRepositoryMock);

        dummyCarOptions = new ArrayList<>();

        carModel = new CarModel();

        //Init the dummy car options
        for(int i=1; i<= NUMBER_OF_GLOBAL_OPTIONS; i++)
        {
            CarOption carOption = new CarOption("CarOption" + i);
            dummyCarOptions.add(carOption);

            if(i<= NUMBER_OF_AVAILABLE_OPTIONS) {
                carModel.addOption(carOption, false);
            }
            else if(i <= NUMBER_OF_AVAILABLE_OPTIONS + NUMBER_OF_DEFAULT_OPTIONS)
            {
                carModel.addOption(carOption, true);
            }
        }

        //Tell mockito what to return on findAll()
        Mockito.when(carOptionRepositoryMock.findAll()).thenReturn(dummyCarOptions);
        //Tell mockito what to return on save()
        Mockito.when(carOptionRepositoryMock.save(testCarOption)).thenReturn(testCarOption);
    }

    @Test
    public void testFindGlobalCarOptionsExcludeActiveOnes()
    {
        List<CarOption> globalCarOptionsActiveOnesExcluded = carOptionService.findGlobalCarOptionsExcludeActiveOnes(
            carModel);
        Assert.assertEquals(globalCarOptionsActiveOnesExcluded.size(),
            NUMBER_OF_GLOBAL_OPTIONS - NUMBER_OF_DEFAULT_OPTIONS - NUMBER_OF_AVAILABLE_OPTIONS);
    }

    @Test
    public void testAddGlobalCarOptionAndAddToCarModel()
    {
        dummyCarOptions.add(testCarOption);
        carOptionService.addGlobalCarOptionAndAddToCarModel(testCarOption, carModel);

        List<CarOption> globalCarOptions = carOptionService.findGlobalCarOptions();
        Assert.assertTrue(globalCarOptions.contains(testCarOption));

        Assert.assertTrue(carModel.getOptionsDefaultMap().containsKey(testCarOption));
    }

    @Test
    public void testMakeDefaultOptionAvailable()
    {
        for(Map.Entry<CarOption, Boolean> entry : carModel.getOptionsDefaultMap().entrySet())
        {
            if(entry.getValue()) //Check if option is default
                carOptionService.makeDefaultOptionAvailable(carModel, entry.getKey());

            Assert.assertFalse(entry.getValue()); //Check that option is available and thus not default
        }
    }

    @Test
    public void testMakeAvailableOptionDefault()
    {
        for(Map.Entry<CarOption, Boolean> entry : carModel.getOptionsDefaultMap().entrySet())
        {
            if(!entry.getValue()) //Check if option is available
                carOptionService.makeAvailableOptionDefault(carModel, entry.getKey());

            Assert.assertTrue(entry.getValue()); //Check if option is default and thus not available
        }
    }

    @Test
    public void testGetDefaultOptionsForCarModel()
    {
        Assert.assertEquals(carOptionService.findDefaultOptionsForCarModel(carModel).size(), NUMBER_OF_DEFAULT_OPTIONS);
    }

    @Test
    public void testGetAvailableOptionsForCarModel()
    {
        Assert.assertEquals(carOptionService.findAvailableOptionsForCarModel(carModel).size(), NUMBER_OF_AVAILABLE_OPTIONS);
    }
}
