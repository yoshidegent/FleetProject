package com.realdolmen.fleet.spreadsheet.mapper;

import com.realdolmen.fleet.CarOption;
import com.realdolmen.fleet.CarOptionService;
import com.realdolmen.fleet.CarService;

import java.util.List;

public interface SpreadsheetMapper <T> {
    T mapRow(List<String> values);

    CarOptionService getCarOptionService();
    void setCarOptionService(CarOptionService carOptionService);
}
