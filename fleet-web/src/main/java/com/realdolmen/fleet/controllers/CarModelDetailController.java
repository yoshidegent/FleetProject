package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.CarModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.Period;

@Controller
@RequestMapping("/carModelDetail")
public class CarModelDetailController {

    @RequestMapping
    public String carModelDetail(Model model)
    {
        //TODO: get these cars from the database
        CarModel carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17));


        model.addAttribute("carModel", carModel);

        return "carmodeldetail";
    }
}
