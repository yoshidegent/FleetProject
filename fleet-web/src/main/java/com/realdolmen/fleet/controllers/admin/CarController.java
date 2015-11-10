package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.*;
import com.realdolmen.fleet.viewmodels.admin.car.CarEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/admin/car")
public class CarController {
    @Autowired private CarService carService;
    @Autowired private EmployeeService employeeService;
    @Autowired private CarOptionService carOptionService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<PhysicalCar> cars = carService.findAllCars();
        model.addAttribute("cars", cars);

        return "admin/car/overview";
    }

    @RequestMapping("/{id}")
    public String details(Model model, @PathVariable("id") Long id) {
        PhysicalCar car = carService.findCar(id);
        model.addAttribute("car", car);

        return "admin/car/detail";
    }

    @RequestMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        PhysicalCar car = carService.findCar(id);

        CarEditForm editForm = new CarEditForm();
        editForm.mapFrom(car);
        model.addAttribute("editForm", editForm);

        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);

        return "admin/car/edit";
    }

    @RequestMapping("/new")
    public String newGet(Model model) {
        model.addAttribute("editForm", new CarEditForm());

        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);

        return "admin/car/edit";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public String modelPost(@ModelAttribute CarEditForm editForm) {
        PhysicalCar newCar = editForm.physicalCar();
        PhysicalCar oldCar = carService.findCar(newCar.getId());

        Employee newEmployee = newCar.getEmployee();
        Employee oldEmployee = oldCar.getEmployee();

        // The car gets unassigned
        if(newEmployee == null) {
            // Get the old employee and remove its current car
            oldEmployee.setCurrentCar(null);
        } else {
            if(oldEmployee != null)
                oldEmployee.setCurrentCar(null);
            newEmployee.setCurrentCar(newCar);
        }

        List<Long> installedOptionIds = editForm.getInstalledOptions();
        carOptionService.editOptionsById(newCar, installedOptionIds);
        carService.saveCar(newCar);

        return "redirect:" + fromMappingName("CC#overview").build();
    }

    @RequestMapping("/{id}/installed")
    @ResponseBody
    public List<CarOption> getInstalledOptions(@PathVariable("id") Long id) {
        PhysicalCar car = carService.findCar(id);
        return car.getSelectedCarOptions();
    }
}
