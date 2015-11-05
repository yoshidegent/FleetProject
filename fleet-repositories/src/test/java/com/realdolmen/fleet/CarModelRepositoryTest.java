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
    @Autowired private CarModelRepository carModelRepository;

    private List<CarModel> carModels = new ArrayList<>();

    private final int NUMBER_OF_CATEGORY_2 = 5;
    private final int NUMBER_OF_CATEGORY_3 = 20;

    @Before public void before() {

        for(int i=0; i<NUMBER_OF_CATEGORY_2 + NUMBER_OF_CATEGORY_3; i++)
        {
           carModels.add(new CarModel(
               "https://upload.wikimedia.org/wikipedia/commons/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG",
               2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
               "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
               Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, new BigDecimal(25048.99),
               null, new BigDecimal(3924.43), new BigDecimal(104.17)));
        }

        carModelRepository.save(carModels);
    }

    @Test public void testFindCarModelsByCategory() {
        for (int i = 0; i < NUMBER_OF_CATEGORY_2; i++) {
            carModels.get(i).setCategory(2);
        }

        for (int i = 0; i < NUMBER_OF_CATEGORY_3; i++) {
            carModels.get(i).setCategory(3);
        }

        List<CarModel> allCarModels = carModelRepository.findAll();
        Assert.assertTrue(allCarModels.size() > 0);

        Assert.assertEquals(carModelRepository.findByCategory(2).size(), NUMBER_OF_CATEGORY_2);
        Assert.assertEquals(carModelRepository.findByCategory(3).size(), NUMBER_OF_CATEGORY_3);
    }

    @Test
    public void testCarModelCanBeSoftDeleted() {
        CarModel carModel = carModels.get(0);
        carModelRepository.softDelete(carModel);

        carModel = carModelRepository.findOne(carModel.getId());
        Assert.assertTrue(carModel.isDeleted());
    }
}
