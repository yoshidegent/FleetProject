package com.realdolmen.fleet;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarOptionRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private CarOptionRepository carOptionRepository;

    List<CarOption> carOptions;

    private final String TOWING_BRACKET = "Towing Bracket";
    private final String GPS = "GPS";
    private final String GSM_BLUETOOTH = "GSM Bluetooth";

    @Before
    public void before()
    {
        carOptions = new ArrayList<>(Arrays.asList(
            new CarOption(TOWING_BRACKET),
            new CarOption(GPS),
            new CarOption(GSM_BLUETOOTH)
        ));

        carOptionRepository.save(carOptions);
    }

    @Test
    public void testFindCarOptionByName()
    {
        String testName = "";
        Assert.assertNull(carOptionRepository.findByName(testName));

        testName = TOWING_BRACKET;
        Assert.assertEquals(carOptionRepository.findByName(testName).getName(), TOWING_BRACKET);

        testName = TOWING_BRACKET.toLowerCase();
        Assert.assertNull(carOptionRepository.findByName(testName));

        testName = GPS;
        Assert.assertEquals(carOptionRepository.findByName(testName).getName(), GPS);

        testName = GSM_BLUETOOTH;
        Assert.assertEquals(carOptionRepository.findByName(testName).getName(), GSM_BLUETOOTH);

        testName = GSM_BLUETOOTH.toUpperCase();
        Assert.assertNull(carOptionRepository.findByName(testName));
    }

    @Test
    public void testFindCarOptionByNameIgnoreCase()
    {
        String testName = "";
        Assert.assertNull(carOptionRepository.findByNameIgnoreCase(testName));

        testName = TOWING_BRACKET;
        Assert.assertEquals(carOptionRepository.findByNameIgnoreCase(testName).getName(), TOWING_BRACKET);

        testName = TOWING_BRACKET.toLowerCase();
        Assert.assertEquals(carOptionRepository.findByNameIgnoreCase(testName).getName(), TOWING_BRACKET);

        testName = GPS;
        Assert.assertEquals(carOptionRepository.findByNameIgnoreCase(testName).getName(), GPS);

        testName = GSM_BLUETOOTH;
        Assert.assertEquals(carOptionRepository.findByNameIgnoreCase(testName).getName(), GSM_BLUETOOTH);

        testName = GSM_BLUETOOTH.toUpperCase();
        Assert.assertEquals(carOptionRepository.findByNameIgnoreCase(testName).getName(), GSM_BLUETOOTH);
    }
}
