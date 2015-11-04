package com.realdolmen.fleet.converters;

import com.realdolmen.fleet.CarOption;
import com.realdolmen.fleet.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CarOptionFormatter implements Formatter<CarOption> {
    @Autowired private CarService carService;

    @Override
    public CarOption parse(String s, Locale locale) throws ParseException {
        if(s == null || s.isEmpty())
            return null;

        Long id = Long.parseLong(s);
        return carService.findOptionById(id);
    }

    @Override
    public String print(CarOption carOption, Locale locale) {
        if(carOption == null)
            return null;

        return carOption.getId().toString();
    }
}
