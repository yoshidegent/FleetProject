package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.*;
import com.realdolmen.fleet.viewmodels.admin.carModel.EditForm;
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

        return "admin/order/detail";
    }

    @RequestMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        return "admin/order/edit";
    }

    @RequestMapping("/new")
    public String newGet(Model model) {
        return "admin/order/edit";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public String modelPost(@ModelAttribute EditForm editForm) {
        /*if(editForm.getImageFile() != null && !editForm.getImageFile().isEmpty()) {
            try {
                String fileName = editForm.getImageFile().getOriginalFilename();
                int lastDotIndex = fileName.lastIndexOf(".");
                String extension = fileName.substring(lastDotIndex + 1);
                String newFileName = Instant.now().getEpochSecond() + "." + extension;
                String webappRoot = servletContext.getRealPath("/");
                String relativeFolder = File.separator + "resources" + File.separator
                        + "images" + File.separator + "car-models" + File.separator;

                editForm.getImageFile().transferTo(new File(webappRoot + relativeFolder + newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        return "redirect:" + fromMappingName("OC#overview").build();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return "redirect:" + fromMappingName("OC#overview").build();
    }

    @RequestMapping("/delete/{ids}/m")
    public String deleteMultiple(@PathVariable Long[] ids) {
        return "redirect:" + fromMappingName("OC#overview").build();
    }
}
