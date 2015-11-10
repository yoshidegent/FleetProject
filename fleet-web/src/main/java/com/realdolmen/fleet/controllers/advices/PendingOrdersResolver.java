package com.realdolmen.fleet.controllers.advices;

import com.realdolmen.fleet.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class PendingOrdersResolver {
    @Autowired private OrderService orderService;

    @ModelAttribute("pendingOrders")
    public Long pendingOrders() {
        return orderService.getPendingOrderAmount();
    }
}
