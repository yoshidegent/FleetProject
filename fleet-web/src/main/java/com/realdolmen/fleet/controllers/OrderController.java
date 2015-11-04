package com.realdolmen.fleet.controllers;

import com.realdolmen.fleet.CarOrder;
import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.OrderService;
import com.realdolmen.fleet.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import java.time.LocalDateTime;

@Controller
public class OrderController {
    @Autowired private User currentUser;
    @Autowired private ServletContext servletContext;
    @Autowired private OrderService orderService;

    public CarOrder createOrder() {
        CarOrder carOrder = new CarOrder();
        carOrder.setEmployee((Employee) currentUser);
        carOrder.setOrderDate(LocalDateTime.now());
        carOrder.setStatus(CarOrder.OrderStatus.PENDING);

        return carOrder;
    }

    public void saveOrder(CarOrder carOrder) {
        orderService.saveOrder(carOrder);
    }
}
