package com.realdolmen.fleet.spreadsheet.mapper;

import com.realdolmen.fleet.CarModel;

import java.math.BigDecimal;
import java.util.List;

public class ExcelCarModelSpreadsheetMapperImpl implements SpreadsheetMapper<CarModel> {
    @Override
    public CarModel mapRow(List<String> values) {
        CarModel carModel = new CarModel();

        for(int i = 0; i < values.size(); i++) {
            String value = values.get(i);

            switch(i) {
                case 0: // Category
                    carModel.setCategory(Integer.parseInt(value));
                    break;

                case 1: // Emission
                    carModel.setCo2Emission(Integer.parseInt(value));
                    break;

                case 2: // Fiscal HP
                    carModel.setFiscalHorsePower(Integer.parseInt(value));
                    break;

                case 3: // Fuel type
                    if(value.toUpperCase().equals("D"))
                        carModel.setFuelType(CarModel.FuelType.DIESEL);
                    else
                        carModel.setFuelType(CarModel.FuelType.GASOLINE);
                    break;

                case 4: // Brand
                    carModel.setBrand(value);
                    break;

                case 5: // Model
                    carModel.setType(value);
                    break;

                case 6: // Pack
                    carModel.setPack(value);
                    break;

                case 7: // Delivery Time
                    carModel.setDeliveryTime(null);
                    break;

                case 12:
                    carModel.setIdealKm(Integer.parseInt(value));
                    break;

                case 13:
                    carModel.setMaxKm(Integer.parseInt(value));
                    break;

                case 14:
                    carModel.setListPriceInclVat(new BigDecimal(value));
                    break;

                case 16:
                    carModel.setAmountUpgradeInclVat(new BigDecimal(value));
                    break;

                case 17:
                    carModel.setAmountDowngradeInclVat(new BigDecimal(value));
                    break;
            }
        }

        return carModel;
    }
}
