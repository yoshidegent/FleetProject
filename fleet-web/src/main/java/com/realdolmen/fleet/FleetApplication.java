package com.realdolmen.fleet;

import com.realdolmen.fleet.spreadsheet.ExcelSpreadsheetServiceImpl;
import com.realdolmen.fleet.spreadsheet.SpreadsheetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class FleetApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(FleetApplication.class, args);

        //Import the carModels from excel
        SpreadsheetService<CarModel> spreadsheetService = app.getBean(
            ExcelSpreadsheetServiceImpl.class);
        List<CarModel> carModels = spreadsheetService.parse(
            app.getClass().getResourceAsStream("/excel/RealDolmenWagenparktabelMei2015.xlsx"), 0);

        CarService carService = app.getBean(CarService.class);

        carService.saveCarModels(carModels);
    }
}
