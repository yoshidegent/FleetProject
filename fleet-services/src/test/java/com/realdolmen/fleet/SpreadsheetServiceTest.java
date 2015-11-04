package com.realdolmen.fleet;

import com.realdolmen.fleet.spreadsheet.ExcelSpreadsheetServiceImpl;
import com.realdolmen.fleet.spreadsheet.SpreadsheetService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class SpreadsheetServiceTest extends AbstractServiceTest {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private SpreadsheetService spreadsheetService = new ExcelSpreadsheetServiceImpl();

    @Autowired
    private CarService carServiceMock;

    @Before
    public void before()
    {
        spreadsheetService.getSpreadsheetMapper().setCarService(carServiceMock);
        Mockito.when(carServiceMock.findCarOptionByNameIgnoreCase("towing bracket")).thenReturn(
            new CarOption("Towing Bracket"));
        Mockito.when(carServiceMock.findCarOptionByNameIgnoreCase("gps")).thenReturn(new CarOption("GPS"));
        Mockito.when(carServiceMock.findCarOptionByNameIgnoreCase("gsm bluetooth")).thenReturn(new CarOption("GSM Bluetooth"));
    }

    @Test
    public void testParseExcel() throws FileNotFoundException {
        List<CarModel> carModelList = spreadsheetService.parse(this.getClass().getResourceAsStream("/excel/RealDolmenWagenparktabelMei2015.xlsx"), 0);
        carModelList.stream().forEach(c -> LOG.debug(c.toString()));
        Assert.assertTrue(carModelList.size() > 0);
    }


}
