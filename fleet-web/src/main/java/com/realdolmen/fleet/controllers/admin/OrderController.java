package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarOrder;
import com.realdolmen.fleet.OrderService;
import com.realdolmen.fleet.viewmodels.admin.order.DeliverForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired private OrderService orderService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<CarOrder> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "admin/order/overview";
    }

    @RequestMapping("/{id}")
    public String details(Model model, @PathVariable("id") Long id) {
        CarOrder carOrder = orderService.findOne(id);
        model.addAttribute("order", carOrder);
        model.addAttribute("deliverForm", new DeliverForm());

        return "admin/order/detail";
    }

    @RequestMapping(value = "/{id}/deliver", method = RequestMethod.POST)
    public String deliver(@PathVariable Long id, @ModelAttribute("deliverForm") @Valid DeliverForm deliverForm,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            // Error messages don't seem to work with flash attributes...
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.deliverForm", bindingResult);
            redirectAttributes.addFlashAttribute("deliverForm", deliverForm);
            return "redirect:" + fromMappingName("OC#details").arg(1, id).build();
        }

        orderService.deliver(id, deliverForm.getLicensePlate());
        redirectAttributes.addFlashAttribute("success", "The order's status was successfully changed to delivered.");
        return "redirect:" + fromMappingName("OC#details").arg(1, id).build();
    }
}
