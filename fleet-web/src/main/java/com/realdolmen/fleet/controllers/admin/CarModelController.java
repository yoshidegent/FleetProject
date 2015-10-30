package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/admin/car-model")
public class CarModelController {
    @Autowired private CarService carService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        return "admin/car-model/overview";
    }

    @RequestMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        CarModel carModel = carService.findCarModel(id);
        model.addAttribute("carModel", carModel);

        return "admin/car-model/edit";
    }

    @RequestMapping("/new")
    public String newGet(Model model) {
        model.addAttribute("carModel", new CarModel());

        return "admin/car-model/edit";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public String modelPost(@ModelAttribute CarModel carModel) {
        carService.saveCarModel(carModel);

        return "redirect:" + fromMappingName("CMC#overview").build();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        carService.deleteCarModel(id);

        return "redirect:" + fromMappingName("CMC#overview").build();
    }
}
