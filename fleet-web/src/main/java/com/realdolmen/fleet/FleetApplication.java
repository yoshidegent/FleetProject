package com.realdolmen.fleet;

import com.realdolmen.fleet.spreadsheet.ExcelSpreadsheetServiceImpl;
import com.realdolmen.fleet.spreadsheet.SpreadsheetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class FleetApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(FleetApplication.class, args);
    }
}
