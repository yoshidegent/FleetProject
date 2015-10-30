package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/car-models")
public class CarModelController {
    @Autowired private CarService carService;

    @RequestMapping({"", "/"})
    public String overview(Model model,
                           @RequestParam(value = "amount", defaultValue = "15") Integer amount,
                           @RequestParam(value = "page", defaultValue = "1") Integer page) {
        List<CarModel> carModels = carService.findAllCarModels();
        PagedListHolder<CarModel> pagedListHolder = new PagedListHolder<>(carModels);
        pagedListHolder.setPageSize(amount);
        pagedListHolder.setPage(page);
        model.addAttribute("carModels", pagedListHolder);

        return "admin/car-models/overview";
    }
}
