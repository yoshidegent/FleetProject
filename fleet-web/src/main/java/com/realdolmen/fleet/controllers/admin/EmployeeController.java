package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
