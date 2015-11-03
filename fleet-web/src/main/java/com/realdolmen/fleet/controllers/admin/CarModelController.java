package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarService;
import com.realdolmen.fleet.viewmodels.admin.carModel.EditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/admin/car-model")
public class CarModelController {
    @Autowired private ServletContext servletContext;
    @Autowired private CarService carService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        return "admin/car-model/overview";
    }

    @RequestMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        CarModel carModel = carService.findCarModel(id);

        EditForm editForm = new EditForm();
        editForm.mapFrom(carModel);
        model.addAttribute("editForm", editForm);

        return "admin/car-model/edit";
    }

    @RequestMapping("/new")
    public String newGet(Model model) {
        model.addAttribute("carModel", new EditForm());

        return "admin/car-model/edit";
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

        carService.saveCarModel(editForm.carModel());

        return "redirect:" + fromMappingName("CMC#overview").build();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        carService.deleteCarModel(id);

        return "redirect:" + fromMappingName("CMC#overview").build();
    }

    @RequestMapping("/delete/{ids}/m")
    public String deleteMultiple(@PathVariable Long[] ids) {
        carService.deleteCarModels(ids);

        return "redirect:" + fromMappingName("CMC#overview").build();
    }
}
