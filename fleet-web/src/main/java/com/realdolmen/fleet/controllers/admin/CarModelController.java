package com.realdolmen.fleet.controllers.admin;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.CarOption;
import com.realdolmen.fleet.CarOptionService;
import com.realdolmen.fleet.CarService;
import com.realdolmen.fleet.viewmodels.admin.carModel.CarModelEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/admin/car-model")
public class CarModelController {
    @Autowired private CarService carService;
    @Autowired private CarOptionService carOptionService;

    @RequestMapping({"", "/"})
    public String overview(Model model) {
        List<CarModel> carModels = carService.findAllCarModels();
        model.addAttribute("carModels", carModels);

        return "admin/car-model/overview";
    }

    @RequestMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        CarModel carModel = carService.findCarModel(id);

        CarModelEditForm carModelEditForm = new CarModelEditForm();
        carModelEditForm.mapFrom(carModel);
        model.addAttribute("editForm", carModelEditForm);

        model.addAttribute("optionMap", carModel.getOptionsDefaultMap());
        model.addAttribute("globalOptions", carOptionService.findGlobalCarOptionsExcludeActiveOnes(carModel));

        return "admin/car-model/edit";
    }

    @RequestMapping("/new")
    public String newGet(Model model) {
        model.addAttribute("editForm", new CarModelEditForm());

        return "admin/car-model/edit";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public String modelPost(@ModelAttribute("editForm") @Valid CarModelEditForm editForm, BindingResult bindingResult, Model model) {
        /*if(carModelEditForm.getImageFile() != null && !carModelEditForm.getImageFile().isEmpty()) {
            try {
                String fileName = carModelEditForm.getImageFile().getOriginalFilename();
                int lastDotIndex = fileName.lastIndexOf(".");
                String extension = fileName.substring(lastDotIndex + 1);
                String newFileName = Instant.now().getEpochSecond() + "." + extension;
                String webappRoot = servletContext.getRealPath("/");
                String relativeFolder = File.separator + "resources" + File.separator
                        + "images" + File.separator + "car-models" + File.separator;

                carModelEditForm.getImageFile().transferTo(new File(webappRoot + relativeFolder + newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        if(bindingResult.hasErrors()) {
            model.addAttribute("editForm", editForm);
            return "admin/car-model/edit";
        }

        Map<CarOption, Boolean> carOptionDefaultMap = new HashMap<>();
        CarModel carModel = editForm.carModel();
        List<Long> optionIds = editForm.getOptionIds();
        List<Boolean> isDefaultList = editForm.getOptionDefaultList();

        for (int i=0; i<optionIds.size(); i++)
        {
            CarOption carOption = carOptionService.findCarOptionById(optionIds.get(i));

            if(carOption != null)
                carOptionDefaultMap.put(carOption, isDefaultList.get(i));
        }

        carModel.setOptionsDefaultMap(carOptionDefaultMap);

        carService.saveCarModel(carModel);

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

    @RequestMapping("/options/add")
    @ResponseBody
    public Long method(@RequestParam("optionName") String optionName)
    {
        CarOption newCarOption = carOptionService.addGlobalCarOption(new CarOption(optionName));

        if(newCarOption != null)
            return newCarOption.getId();
        else
            return null;
    }

    @RequestMapping("/{id}/options")
    @ResponseBody
    public List<CarOption> getAvailableCarOptions(@PathVariable("id") Long id) {
        CarModel carModel = carService.findCarModel(id);
        return carOptionService.findAvailableOptionsForCarModel(carModel);
    }
}
