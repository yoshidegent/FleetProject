package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller @RequestMapping({"/", "/home"}) public class HomeController {

    @RequestMapping(method = RequestMethod.GET) public String  home(Model model) {

        //TODO: get the active logged in employee
        Employee employee = new Employee();
        employee.setFirstName("Yoshi");
        employee.setLastName("Degent");


        model.addAttribute("employeeName", employee.getFirstName() + " " + employee.getLastName());

        //TODO: get these cars from the database
        CarModel carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17));

        List<CarModel> allCarModels = new ArrayList<CarModel>(Arrays
            .asList(carModel, carModel, carModel, carModel, carModel, carModel, carModel, carModel,
                carModel, carModel, carModel, carModel, carModel, carModel, carModel, carModel,
                carModel, carModel, carModel, carModel, carModel, carModel, carModel, carModel,
                carModel, carModel, carModel, carModel, carModel, carModel));

        model.addAttribute("carModelList", allCarModels);

        return "home";
    }
}
