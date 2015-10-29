package com.realdolmen.fleet;

import com.realdolmen.fleet.spreadsheet.ExcelSpreadsheetServiceImpl;
import com.realdolmen.fleet.spreadsheet.SpreadsheetService;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class SpreadsheetServiceTest {
    private SpreadsheetService spreadsheetService = new ExcelSpreadsheetServiceImpl();

    @Test
    public void testExcel() throws FileNotFoundException {
        List<CarModel> carModelList = spreadsheetService.parse(new FileInputStream(new File("C:\\Users\\dwsax40\\Desktop\\Projectoefening 2\\RealDolmen Wagenparktabel Mei 2015.xlsx")), 0);
        System.out.println(carModelList);
    }
}
