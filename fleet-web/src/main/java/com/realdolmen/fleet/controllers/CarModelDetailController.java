package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.time.Period;

@Controller @RequestMapping("/carModelDetail") public class CarModelDetailController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = {"/{carModelId}"}, method = RequestMethod.GET)
    public String carModelDetail(@PathVariable(value = "carModelId") final String id, Model model) {

        Long idLong = null;

        //Check if a parameter was passed
        if(id == null)
            return "redirect:/";
        else {
            //Try to parse the String parameter to an integer
            try {
                idLong = Long.parseLong(id);
            }
            catch (NumberFormatException nfe)
            {
                return "redirect:/";
            }
        }

        // Static object to try the UI
        /**
        CarModel carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17),
            "https://upload.wikimedia.org/wikipedia/commons/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG");
        */

        //Get carModel from database
        CarModel carModel = carService.findCarModel(idLong);

        if(carModel != null) {
            model.addAttribute("carModel", carModel);
            return "carmodeldetail";
        }

        return "redirect:/";
    }
}
