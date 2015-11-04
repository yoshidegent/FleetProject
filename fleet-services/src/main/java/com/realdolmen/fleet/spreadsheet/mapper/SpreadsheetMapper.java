package com.realdolmen.fleet.spreadsheet.mapper;

import com.realdolmen.fleet.CarService;

import java.util.List;

public interface SpreadsheetMapper <T> {
    T mapRow(List<String> values);

    CarService getCarService();
    void setCarService(CarService carService);
}
