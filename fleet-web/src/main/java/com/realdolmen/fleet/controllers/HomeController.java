package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.*;
import com.realdolmen.fleet.authentication.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller @RequestMapping({"/", "/home"}) public class HomeController {

    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET) public String  home(@CurrentUser User user, Model model) {
        if(user instanceof Employee) {
            Employee employee = (Employee) user;
            model.addAttribute("employee", employee);

            model.addAttribute("maxCategory", employeeService.getHighestAllowedCategory(employee));
            model.addAttribute("minCategory", employeeService.getLowestAllowedCategory(employee));

            model.addAttribute("employeeName",
                employee.getFirstName() + " " + employee.getLastName());
        }

        /**
        CarModel carModel = new CarModel(2, 89, 9, CarModel.FuelType.DIESEL, "Audi",
            "A3 sportback 1,6tdi 110pk ultra attraction", "Pack intuition Plus attraction",
            Period.of(0, 5, 0), CarModel.RimType.STEEL, 14000, 180000, null,
            new BigDecimal(25048.99), null, new BigDecimal(3924.43), new BigDecimal(104.17),
            "https://upload.wikimedia.org/wikipedia/commons/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG");
         */

        return "home";
    }

    @RequestMapping(value = "/carmodels/{category}",method = RequestMethod.GET)
    public String getCarModels(Model model, @PathVariable("category") int category,
                               @RequestParam(name = "type", required = false, defaultValue = "grid") String type) {
        List<CarModel> allCarModels = carService.findCarModelsByCategory(category);
        model.addAttribute("carModelList", allCarModels);

        switch(type) {
            case "grid":
                return "fragments/carmodelgrid :: carmodelgrid";
            case "list":
                return "fragments/carmodelgrid :: carmodellist";
        }

        return "fragments/carmodelgrid :: carmodelgrid";
    }
}
