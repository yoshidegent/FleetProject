package com.realdolmen.fleet.spreadsheet.mapper;

import com.realdolmen.fleet.CarModel;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;

public class ExcelCarModelSpreadsheetMapperImpl implements SpreadsheetMapper<CarModel> {
    @Override
    public CarModel mapRow(List<String> values) {
        CarModel carModel = new CarModel();

        // If the values are null, or empty, or if the first String value (Category) is empty, return null;
        if(values == null)
            return null;
        if(!values.isEmpty() && values.get(0).isEmpty())
            return null;

        for(int i = 0; i < values.size(); i++) {
            String value = values.get(i);

            /**
             * Apache POI always returns a double for a numeric cell. Cell value "2" would return "2.0".
             * To solve this, I always parse a double where needed and then cast it to an integer.
             * If there's a better solution, let me know!
             */
            switch(i) {
                case 0: // Category
                    carModel.setCategory((int) Double.parseDouble(value));
                    break;

                case 1: // Emission
                    carModel.setCo2Emission((int) Double.parseDouble(value));
                    break;

                case 2: // Fiscal HP
                    carModel.setFiscalHorsePower((int) Double.parseDouble(value));
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
                    //TODO: use real value and no hard-coded one
                    carModel.setDeliveryTime(Period.ofMonths(1));
                    break;

                case 12:
                    carModel.setIdealKm((int) Double.parseDouble(value));
                    break;

                case 13:
                    carModel.setMaxKm((int) Double.parseDouble(value));
                    break;

                case 14:
                    carModel.setListPriceInclVat(new BigDecimal(value));
                    break;

                case 16:
                    if(value.isEmpty())
                        carModel.setAmountUpgradeInclVat(null);
                    else
                        carModel.setAmountUpgradeInclVat(new BigDecimal(value));
                    break;

                case 17:
                    if(value.isEmpty())
                        carModel.setAmountDowngradeInclVat(null);
                    else
                        carModel.setAmountDowngradeInclVat(new BigDecimal(value));
                    break;

                //TODO: add benefit conversion
            }
        }

        return carModel;
    }
}
