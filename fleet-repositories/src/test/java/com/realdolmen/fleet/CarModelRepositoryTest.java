package com.realdolmen.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CarModelRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    private CarModelRepository carModelRepository;

    private CarModel carModel;

    private final int NUMBER_OF_CATEGORY_2 = 5;
    private final int NUMBER_OF_CATEGORY_3 = 20;

    @Before
    public void before()
    {
        carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17),
            "https://upload.wikimedia.org/wikipedia/commons/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG");
    }

    @Test
    public void testFindCarModelsByCategory()
    {
        List<CarModel> carModels = new ArrayList<>();

        for(int i=0; i<NUMBER_OF_CATEGORY_2; i++)
            carModels.add(carModel);

        carModel.setCategory(3);

        for(int i=0; i<NUMBER_OF_CATEGORY_3; i++)
            carModels.add(carModel);

        carModelRepository.save(carModels);

        Assert.assertEquals(carModelRepository.findByCategory(2).size(), NUMBER_OF_CATEGORY_2);
        Assert.assertEquals(carModelRepository.findByCategory(3).size(), NUMBER_OF_CATEGORY_3);
    }
}
