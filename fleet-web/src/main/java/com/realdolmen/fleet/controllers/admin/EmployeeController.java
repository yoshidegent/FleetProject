package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping({"", "/"})
    public String employees(Model model)
    {
        List<Employee> allEmployees = employeeService.findAllEmployees();
        model.addAttribute("employees", allEmployees);
        return "admin/employee/overview";
    }

    @RequestMapping({"/update/{id}"})
    public String employees(Model model, @PathVariable("id") Long employeeId, @RequestParam("function") String function,
                            @RequestParam("functionalLevel") int functionalLevel,
                            @RequestParam(value = "active", required = false) Boolean active,
                            RedirectAttributes redirectAttributes)
    {
        Employee employee = employeeService.findEmployee(employeeId);
        employee.setFunctionalLevel(functionalLevel);
        employee.setFunction(function);

        if(active == null)
            employee.setActive(false);
        else
            employee.setActive(active);

        employeeService.saveOrUpdateEmployee(employee);

        redirectAttributes.addFlashAttribute("success", "Your changes were successfully saved.");
        return "redirect:/admin/employee/";
    }
}
