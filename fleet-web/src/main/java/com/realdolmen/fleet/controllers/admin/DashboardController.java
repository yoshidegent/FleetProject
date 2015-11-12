package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarOrder;
import com.realdolmen.fleet.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @Autowired private OrderService orderService;

    @RequestMapping({"", "/"})
    public String index(Model model) {
        List<CarOrder> carOrders = orderService.findLatest10();
        model.addAttribute("latestOrders", carOrders);

        List<CarOrder> pendingCarOrders = orderService.find10OldestPendingOrders();
        model.addAttribute("pendingOrders", pendingCarOrders);

        return "admin/dashboard";
    }
}
