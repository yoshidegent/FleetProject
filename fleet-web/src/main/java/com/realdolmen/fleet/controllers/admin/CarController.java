package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.*;
import com.realdolmen.fleet.viewmodels.admin.car.CarEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        if(!model.containsAttribute("editForm")) {
            PhysicalCar car = carService.findCar(id);

            CarEditForm editForm = new CarEditForm();
            editForm.mapFrom(car);
            model.addAttribute("editForm", editForm);
        }

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
    public String modelPost(@ModelAttribute("editForm") @Valid CarEditForm editForm, BindingResult bindingResult,
                            Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.editForm", bindingResult);
            redirectAttributes.addFlashAttribute("editForm", editForm);
            return "redirect:" + fromMappingName("CC#editGet").arg(1, editForm.getId()).build();
        }

        PhysicalCar newCar = editForm.physicalCar();

        // If it's an existing car
        if(editForm.getId() != null) {
            PhysicalCar oldCar = carService.findCar(newCar.getId());
            if(oldCar != null) {
                Employee newEmployee = newCar.getEmployee();
                Employee oldEmployee = oldCar.getEmployee();

                // The car gets unassigned
                if(newEmployee == null && oldEmployee != null) {
                    // Get the old employee (if any) and remove its current car
                    oldEmployee.setCurrentCar(null);
                }

                // The car gets assigned to another employee, so set that employee's current car.
                if(newEmployee != null) {
                    newEmployee.setCurrentCar(newCar);
                }
            }
        } else {
            // If it's a new car, set it as the employees current car
            if(newCar.getEmployee() != null)
                newCar.getEmployee().setCurrentCar(newCar);
        }

        List<Long> installedOptionIds = editForm.getInstalledOptions();
        carOptionService.editOptionsById(newCar, installedOptionIds);
        carService.saveCar(newCar);

        redirectAttributes.addFlashAttribute("success", "Your changes were successfully saved.");
        return "redirect:" + fromMappingName("CC#overview").build();
    }

    @RequestMapping("/{id}/installed")
    @ResponseBody
    public List<CarOption> getInstalledOptions(@PathVariable("id") Long id) {
        PhysicalCar car = carService.findCar(id);
        return car.getSelectedCarOptions();
    }
}
