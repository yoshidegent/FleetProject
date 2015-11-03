package com.realdolmen.fleet;

import com.realdolmen.fleet.spreadsheet.ExcelSpreadsheetServiceImpl;
import com.realdolmen.fleet.spreadsheet.SpreadsheetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class FleetApplication {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(FleetApplication.class, args);

        //Import the carModels from excel
        SpreadsheetService<CarModel> spreadsheetService = app.getBean(
            ExcelSpreadsheetServiceImpl.class);
        List<CarModel> carModels = spreadsheetService.parse(
            app.getClass().getResourceAsStream("/excel/RealDolmenWagenparktabelMei2015.xlsx"), 0);

        CarService carService = app.getBean(CarServiceImpl.class);
        Map<CarOption, BigDecimal> p = new HashMap<>();
        CarOption carOption = new CarOption();
        carOption.setName("Trekhaak");
        carService.saveOption(carOption);
        p.put(carOption, BigDecimal.valueOf(123));
        carModels.get(0).setOptionPriceMap(p);
        carService.saveCarModels(carModels);
    }
}
