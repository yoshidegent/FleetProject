package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/car-models")
public class CarModelController {
    @Autowired private CarService carService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        return "admin/car-models/overview";
    }
}
