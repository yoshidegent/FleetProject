package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.CarModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.time.Period;

@Controller @RequestMapping("/carModelDetail") public class CarModelDetailController {

    @RequestMapping(value = {"/{carModelId}"}, method = RequestMethod.GET)
    public String carModelDetail(@PathVariable(value = "carModelId") final String id, Model model) {
        //TODO: parse this id to an integer and use it to find the matching carModel, return to home page if the String is not parsable
        System.out.print("carModelId=" + id);

        //TODO: get these cars from the database
        CarModel carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17),
            "https://upload.wikimedia.org/wikipedia/commons/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG");

        model.addAttribute("carModel", carModel);

        return "carmodeldetail";
    }
}
